package com.jsv.event.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsv.event.dto.EventDTO;
import com.jsv.event.service.EventService;
@Controller("eventController")
public class EventControllerImpl implements EventController {


	@Autowired
	private EventService eventservice;
	
	//이벤트 목록보기
	@Override
	@RequestMapping(value="/event/eventList.mo",method=RequestMethod.GET)
	public ModelAndView getElist(HttpServletRequest request, 
			HttpServletResponse response,Model model) throws Exception {
		
		//비지니스로직
		List<EventDTO> Elist = eventservice.getElist();
		model.addAttribute("Elist", Elist);
		//뷰지정
		ModelAndView mv = new ModelAndView("/event/eventList");
		return mv;
	}
	
	//이벤트 상세보기
	@RequestMapping(value="/event/eventDetail.mo")
	@Override
	public ModelAndView getEdetail(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("eno") int eno)
			throws Exception {
		
		//비지니스 로직
		EventDTO eDetail=eventservice.getEdetail(eno);
		ModelAndView mv = new ModelAndView("/event/eventDetail");
		mv.addObject("eDetail", eDetail);
		return mv;
	}


}
