package user.dao;

import java.util.List;
import java.util.Map;

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
	public void write(Map<String, String> map) {

		sqlSession.insert("userSQL.write", map);
	}

	@Override
	public UserDTO checkId(String id) {
		return sqlSession.selectOne("userSQL.checkId", id);
	}

	@Override
	public UserDTO login(Map<String, String> map) {
		return sqlSession.selectOne("userSQL.login", map);
	}
	
}
