package board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import board.bean.BoardDTO;

@Transactional
@Repository
public class BoardDAOMybatis implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void boardWrite(Map<String, String> map) {
		System.out.println(map);
		sqlSession.insert("boardSQL.boardWrite",map);
		
	}

	@Override
	public List<BoardDTO> getBoardList(Map<String, Integer> map) {
		return 	sqlSession.selectList("boardSQL.getBoardList",map);
	}

	@Override
	public int getTotalA() {
		return sqlSession.selectOne("boardSQL.getTotalA");
	}

}
