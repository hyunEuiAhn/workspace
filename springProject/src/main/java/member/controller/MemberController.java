package member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping(value="/member/writeForm.do", method=RequestMethod.GET)
	public String writeForm(Model model) {
		model.addAttribute("display", "/member/writeForm.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="/member/checkId.do", method=RequestMethod.POST)
	public @ResponseBody String checkId(@RequestParam String id) {
		MemberDTO memberDTO = memberDAO.isExistId(id);

		System.out.println("asdf");
		if(memberDTO==null)
			return "not_exist";
		else {
			System.out.println(memberDTO.getId());
			return "exist";		}
	}
	
	@RequestMapping(value="/member/checkPost.do", method=RequestMethod.GET)
	public String checkPost() {
		return "/member/checkPost";
	}
	
	@RequestMapping(value="/member/postSearch.do", method=RequestMethod.POST)
	public ModelAndView postSearch(@RequestParam Map<String,String> map) {
		List<ZipcodeDTO> list = memberDAO.getZipcodeList(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/member/write.do", method=RequestMethod.POST)
	public String write(@ModelAttribute MemberDTO memberDTO, Model model) {
		System.out.println(memberDTO.getId());
		memberDAO.write(memberDTO);
		
		model.addAttribute("display", "/member/write.jsp");
		return "/main/index";
	}
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public @ResponseBody String login(@RequestParam Map<String,String> map,HttpSession session) {
		System.out.println(map.get("id"));
		MemberDTO memberDTO = memberDAO.login(map);
		if(memberDTO==null)
			return "not_exist";
		else {
			session.setAttribute("memName",memberDTO.getName());
			session.setAttribute("memId",memberDTO.getId());
			session.setAttribute("memEmail",memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			return "exist";
		}
	}
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		
		return new ModelAndView("redirect:/main/index.do");
		
	}
}



