package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import lombok.Setter;
import user.bean.UserDTO;

public class UserDAOMybatis implements UserDAO {
	@Setter
	private SqlSession sqlSession;
	@Setter
	private DataSourceTransactionManager dataSourceTransactionManager;
	
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write",userDTO);//mapper에 정의
		sqlSession.commit();
		sqlSession.close();
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
