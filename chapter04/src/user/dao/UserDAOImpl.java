package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import lombok.Setter;
import user.bean.UserDTO;

/*
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {
//	@Setter
//	private JdbcTemplate jdbcTemplate;
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	} JdbcDaoSupport에 상속을 받아서 없어져도 된다..

//	@Override
//	public void write(UserDTO userDTO) {
//		String sql = "insert into usertable values(?,?,?)";
//		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
//	}
	
	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		getJdbcTemplate().update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, 
				new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
				//db에서 꺼내온 값을 알아서 한 줄 한 줄 맵핑한다.
	}

}
*/
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {

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
	//public UserDTO getUser(String id) {
	public Map<String, Object> getUser(String id) {
		String sql = "select * from usertable where id=:id";
		try{
//			return getJdbcTemplate().queryForObject(sql, 
//								new BeanPropertyRowMapper<UserDTO>(UserDTO.class),
//								id);//queryForObject 한 줄만 꺼내서 가져옴
			return getJdbcTemplate().queryForMap(sql,id);
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
/*
	@Override
	public void update(UserDTO userDTO) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		getNamedParameterJdbcTemplate().update(sql, map);
	}
*/
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
