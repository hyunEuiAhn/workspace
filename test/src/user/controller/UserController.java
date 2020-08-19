package user.controller;

import java.util.List;
import java.util.Map;

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
	
	
	@RequestMapping(value="/checkId.do", method=RequestMethod.POST)
	public @ResponseBody String checkId(@RequestParam String id) {		//@ResponseBody사용 안 하면 jsp파일을 실행하기 때문에 텍스트로 보내기 이해 작성
		if(id.equals("")) return "empty";
		
		UserDTO userDTO = userDAO.checkId(id);
		if(userDTO==null) return "not_exist";
		
		return "exist";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public @ResponseBody void write(@RequestParam Map<String,String> map) {
		
		//DB
		userDAO.write(map);
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public @ResponseBody String login(@RequestParam Map<String,String> map) {
		//DB
		UserDTO userDTO = userDAO.login(map);
		if(userDTO==null) return "not_exist";
		return "exist";
	}
}

