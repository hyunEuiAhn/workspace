package board.dao;

import java.util.List;
import java.util.Map;

import board.bean.BoardDTO;

public interface BoardDAO {

	void boardWrite(Map<String, String> map);

	List<BoardDTO> getBoardList(Map<String, Integer> map);

	int getTotalA();

}

