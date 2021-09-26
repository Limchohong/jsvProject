/*package com.jsv.reserve.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.xerces.dom3.as.DocumentAS;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import com.jsv.reserve.dto.InfoDTO;

@Controller
public class InfoController {
	private static Logger logger = LoggerFactory.getLogger(InfoController.class);
	
	@ResponseBody
	@RequestMapping(value = "crawling.mo", method = {RequestMethod.GET, RequestMethod.POST}, produces="text/plain;charset=UTF-8")
	public String getCrawling() {
		logger.info("크롤링" + new Date());
		DocumentAS doc;
		String gson = "";
		
		try {
			doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
			
			// Elements
			Elements ranks = doc.select(".rank");
			Elements imgs = doc.select(".thumb-image > img");
			Elements movieAges = doc.select(".ico-grade");
			Elements movieTitles = doc.select("div.box-contents strong.title");
			Elements movieRates = doc.select(".percent span");
			Elements movieOpenDates = doc.select(".txt-info strong");
			Elements likes = doc.select(".count strong>i");
			
			List<InfoDTO> list = new ArrayList<InfoDTO>();
			
			for(int i = 0; i < ranks.size(); i++) {
				
				String rank = ranks.get(i).ownText();
				String img  = imgs.get(i).attr("src");
				String movieAge = movieAges.get(i).text();
				String movieTitle = movieTitles.get(i).text();
				String movieRate = movieRates.get(i).text();
				String movieOpenDate = movieOpenDates.get(i).text();
				String like = likes.get(i).text();
				int seq = i;
				InfoDTO infoDTO = new InfoDTO(rank, img, movieAge, movieTitle, movieRate, movieOpenDate, like, seq);
			
				logger.info(infoDTO.toString());
				list.add(infoDTO);
			}
			gson = new Gson().toJson(list);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return gson;
	}//getCrawling End
}*/
