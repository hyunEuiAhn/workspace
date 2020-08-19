package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import user.bean.UserDTO;

@Component	//생성자 역할을 함으로 다른 클래스에서 사용할 때 new를 사용하지 않고 사용할 수 있다.
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	/*
	@Autowired
	public void setDS(DataSource dataSource) {
		setDataSource(dataSource);
	}*/
	
	public UserDAOImpl(DataSource dataSource) {
		setDataSource(dataSource);
		//dataSource는 NamedParameterJdbcDaoSupport 에 생성 돼 있는 setter이다. 
	}//생성자를 통해서 실행됭 때 context의 값을 전달한다.
	
	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(:name,:id,:pwd)";
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, 
				new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
				//db에서 꺼내온 값을 알아서 한 줄 한 줄 맵핑한다.
	}
	@Override
	public Map<String, Object> getUser(String id) {
		String sql = "select * from usertable where id=:id";
		try{

			return getJdbcTemplate().queryForMap(sql,id);
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public void modify(Map<String, Object> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:ID";
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public void delete(String id) {
		String sql = "delete usertable where id=:ID";
		getJdbcTemplate().update(sql, id);
	}
	
	
}
