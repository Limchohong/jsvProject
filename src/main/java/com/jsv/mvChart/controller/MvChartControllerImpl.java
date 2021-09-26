package com.jsv.mvChart.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsv.mvChart.dto.MvChartDTO;
import com.jsv.mvChart.service.MvChartService;

@Controller("mvchartcontroller")
public class MvChartControllerImpl implements MvChartController {

	@Autowired
	private MvChartService mychartservice;
	
	//무비차트 목록보기
	@Override
	@RequestMapping(value="/mvchart/mvChartList.mo",method=RequestMethod.GET)
	public ModelAndView getmvChart(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		
		List<MvChartDTO> mvlist =mychartservice.getmvChart();
		model.addAttribute("mvlist", mvlist);
		
		ModelAndView mv = new ModelAndView("/mvchart/mvChartList");
		return mv;
	}

	
	//무비차트 상세보기
	@Override
	@RequestMapping("/mvchart/mvDetail.mo")
	public ModelAndView getmvdetail(HttpServletRequest request, HttpServletResponse response, int cno)
			throws Exception {
		MvChartDTO mvdto = mychartservice.getmvdetail(cno);
		ModelAndView mv = new ModelAndView("/mvchart/mvDetail");
		mv.addObject("mvdto", mvdto);
		return mv;
	}

	

}
