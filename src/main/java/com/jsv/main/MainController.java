package com.jsv.main;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("mainController")
public class MainController {

	//method
		//요청함수    
		@RequestMapping(value="/main.mo")
		public String main(HttpServletRequest request, 
								 HttpServletResponse response) throws Exception {
			System.out.println("main이당");
			
			return "main";
		}
}
