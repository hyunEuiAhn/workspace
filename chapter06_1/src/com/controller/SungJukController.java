package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SungJukDTO;

@Controller		//핸들러 맵핑이 controller 를 찾아서 실행
public class SungJukController {
	
	@RequestMapping(value="/sungjuk/input.do", method=RequestMethod.GET)
	public String input() { //사용자가 만든 메소드를 콜백한다.
		return "/sungjuk/input";
	}
	
	@RequestMapping(value="/sungjuk/result.do", method=RequestMethod.POST)	
	public ModelAndView result(@ModelAttribute SungJukDTO sungJukDTO) {
		sungJukDTO.setTot(sungJukDTO.getKor()+sungJukDTO.getEng()+sungJukDTO.getMath());
		sungJukDTO.setAvg(sungJukDTO.getTot()/3.0);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("sungJukDTO", sungJukDTO);
		mav.setViewName("/sungjuk/result");
		return mav;
	}
}
