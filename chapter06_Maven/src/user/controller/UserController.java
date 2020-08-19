package user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/writeForm.do", method=RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String write(@ModelAttribute UserDTO userDTO) {
		//DB
		userDAO.write(userDTO);
		return "/user/write";
	}
	
	@RequestMapping(value="/getUserList.do", method=RequestMethod.GET)
	public String getUserList() {
		return "/user/getUserList";
	}
	
	@RequestMapping(value="/getList.do", method=RequestMethod.POST)
	public ModelAndView getList() {
		List<UserDTO> list = userDAO.getUserList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;		 
	}
	@RequestMapping(value="/checkId.do", method=RequestMethod.POST)
	public @ResponseBody String checkId(@RequestParam String id) {		//@ResponseBody사용 안 하면 jsp파일을 실행하기 때문에 텍스트로 보내기 이해 작성
		if(id.equals("")) return "empty";
		
		UserDTO userDTO = userDAO.checkId(id);
		if(userDTO==null) return "not_exist";
		
		return "exist";
	}
	
	@RequestMapping(value="/modifyForm.do", method=RequestMethod.GET)
	public String modifyForm() {
		return "/user/modifyForm";
	}
	
	@RequestMapping(value="/getDTO.do", method=RequestMethod.POST)
	public ModelAndView getDTO(@RequestParam String id) {		//@ResponseBody사용 안 하면 jsp파일을 실행하기 때문에 텍스트로 보내기 이해 작성
		ModelAndView mav = new ModelAndView();

		UserDTO userDTO = userDAO.checkId(id);	
		mav.addObject("userDTO", userDTO);
		mav.setViewName("jsonView");

		return mav;
	}
	
	/*
	@RequestMapping(value="/getDTO.do", method=RequestMethod.POST)
	public ModelAndView getUser(@RequestParam String id) {
		ModelAndView mav = new ModelAndView();

		Map <String, String> map = userDAO.getUser(id);	
		mav.addObject("map", map);
		mav.setViewName("jsonView");

		return mav;
	}
	*/
	@RequestMapping(value="/modify.do", method=RequestMethod.POST)
	public String modify(@ModelAttribute UserDTO userDTO) {
		//DB
		userDAO.modify(userDTO);
		return "/user/modify";
	}
	/*
	@RequestMapping(value="/modify.do", method=RequestMethod.POST)
	public @ResponsBody void modify(@ModelAttribute Map<String,String> map) {
		//DB
		userDAO.modify(userDTO);
	}		//@ResponsBody를 하면 jsp를 안 찾아간다.
	*/
	@RequestMapping(value="/deleteForm.do", method=RequestMethod.GET)
	public String deleteForm() {
		return "/user/deleteForm";
	}
	
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String delete(String id) {
		//DB
		userDAO.delete(id);
		return "/user/delete";
	}
}

