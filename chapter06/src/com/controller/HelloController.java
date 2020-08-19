package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value="/hello.do", method=RequestMethod.GET)	//요청이 hello.do로 온다면 
	public ModelAndView hello() {	//callback method 호출 안 해도 스프링이 알아서 불러온다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("result","Hello Spring!!");
		mav.setViewName("hello");	//hello.jsp
		mav.setViewName("/view/hello");
		return mav;
	}
}
