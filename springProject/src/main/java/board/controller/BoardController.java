package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;


@Controller
public class BoardController {
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private BoardPaging boardPaging;
	
	@RequestMapping(value="/board/boardWriteForm.do", method=RequestMethod.GET)
	public String boardWriteForm(Model model) {
		model.addAttribute("display","/board/boardWriteForm.jsp");
		return "/main/index";
	}
	@RequestMapping(value="/board/boardWrite.do", method=RequestMethod.POST)
	public ModelAndView boardWrite(@RequestParam Map <String,String> map, 
									HttpSession session) {
		String id= (String)session.getAttribute("memId");
		String name= (String)session.getAttribute("memName");
		String email= (String)session.getAttribute("memEmail");

		map.put("id",id);
		map.put("name",name);
		map.put("email",email);
		
		System.out.println(map.get("id"));
		System.out.println(map.get("subject"));
		boardDAO.boardWrite(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg","1");
		mav.addObject("display", "/board/boardList.jsp");
		mav.setViewName("/main/index");
		return mav;
	}
	
	@RequestMapping(value="/board/boardList.do", method=RequestMethod.GET)
	public String boardList(@RequestParam(required=false, defaultValue="1") String pg, Model model) {
		model.addAttribute("pg", pg);
		model.addAttribute("display","/board/boardList.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="/board/getBoardList.do", method=RequestMethod.POST)
	public ModelAndView getBoardList(@RequestParam(required=false, defaultValue="1")String pg) {
		int endNum = Integer.parseInt(pg)*5;
		int startNum = endNum-4;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum",startNum);
		map.put("endNum",endNum);
		
		List<BoardDTO> list = boardDAO.getBoardList(map);
		
		//페이징처리
		int totalA = boardDAO.getTotalA();//총글 수
		boardPaging.setCurrentPage(Integer.parseInt(pg));
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("boardPaging",boardPaging);
		mav.setViewName("jsonView");
		return mav;
	}



}
