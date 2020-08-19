package user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

@Transactional	//commit과 close 역할을 한다.
@Repository //component 와 같은 역할이지만 디비에선 리파지토리 많이 사용
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
		
	}

	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
		
	}

	@Override
	public UserDTO checkId(String id) {
		return sqlSession.selectOne("userSQL.checkId", id);
	}

	@Override
	public void modify(UserDTO userDTO) {
		sqlSession.update("userSQL.modify", userDTO);
	}
	/*
	@Override
	public void modify(Map<String, String> map) {
		sqlSession.update("userSQL.modify", map);
	}
*/
	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.deleteId", id);
	}
	/*
	@Override
	public Map<String, String> getUser(String id) {
		
		return sqlSession.selectOne("userSQL.getUser", id);
	}
	*/
	
}
