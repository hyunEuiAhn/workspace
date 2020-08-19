package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;

@Controller
public class SumController {

//	@RequestMapping(value="sum/input.do", method=RequestMethod.GET)	//요청이 input.do로 온다면 
//	public ModelAndView input() {	//callback method 호출 안 해도 스프링이 알아서 불러온다.
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/sum/input");
//		return mav;
//	}
	
	@RequestMapping(value="/sum/input.do", method=RequestMethod.GET)	//요청이 input.do로 온다면 
	public String input() {	//callback method 호출 안 해도 스프링이 알아서 불러온다.
		return "/sum/input";
	}		//jsp 파일을 찾아간다.
	
	//리턴타입이 String 이면 문자열이 아니라 뷰이름으로 사용된다.
	//뷰이름이 아니라 실제 문자열로 리턴하고 싶을 땐 @ResponseBody를 사용
	//	public @ResponseBody String input() {
	
//	------------------------------------------------
	/*
	@RequestMapping(value="/result.do", method=RequestMethod.GET)	
	public ModelAndView result() {	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/sum/result");
		return mav;
	}*/
	
//	@RequestMapping(value="sum/result.do", method=RequestMethod.GET)	
//	public ModelAndView result(@RequestParam int x,@RequestParam int y) {	
//		//@RequestParam 으로 선언하면 이전 페이지에서 보낸 값을 받을 수 있다.
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x",x);
//		mav.addObject("y",y);
//		mav.setViewName("/sum/result");
//		return mav;
//	}

//	@RequestMapping(value="sum/result.do", method=RequestMethod.GET)	
//	public ModelAndView result(@RequestParam(required=false, defaultValue="0")String x,
//								//데이터가 들어왔을 때 값이 없으면 0으로 처리
//							   @RequestParam(required=false, defaultValue="0")String y) {	
//		//@RequestParam 으로 선언하면 이전 페이지에서 보낸 값을 받을 수 있다.
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x",x);
//		mav.addObject("y",y);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@RequestMapping(value="sum/result.do", method=RequestMethod.GET)	
//	public String result(@RequestParam Map<String, String> map,
//						 ModelMap modelMap) {
//		modelMap.put("x", map.get("x"));
//		modelMap.put("y", map.get("y"));
//		return "/sum/result";
//	}
	
	
	@RequestMapping(value="/sum/result.do", method=RequestMethod.GET)	
	public String result(@ModelAttribute SumDTO sumDTO,	//DTO로 값을 받아 올 경우 사용
						 Model model) {
		model.addAttribute("x", sumDTO.getX());
		model.addAttribute("y", sumDTO.getY());
		//model.addAttribute("sumDTO",sumDTO);  //DTO 값으로 보내줘도 상관 없다.
		return "/sum/result";
	}
}

//	get,post 이건 데이터가 매개면수로 넘어오면 세 가지 방식으로 받는다
//		- String name = request.getParameter("name")
//		- ${param.name}
//		- @RequestParam
	
	
