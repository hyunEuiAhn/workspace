package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@Component
@Transactional //커밋 크로즈를 다 알아서 해결 함
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private DataSourceTransactionManager dataSourceTransactionManager;
	
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write",userDTO);//mapper에 정의
	}

	@Override
	public List<UserDTO> getUserList() {
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		return list;
	}

	@Override
	public Map<String, Object> getUser(String id) {
		Map<String, Object> map = sqlSession.selectOne("userSQL.getUser", id);
		return map;
	}

	@Override
	public void modify(Map<String, Object> map) {
		sqlSession.update("userSQL.modify", map);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);
	}
}
