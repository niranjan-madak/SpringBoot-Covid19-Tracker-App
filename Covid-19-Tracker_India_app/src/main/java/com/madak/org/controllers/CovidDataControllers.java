package com.madak.org.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.madak.org.model.CovidDataSource;
import com.madak.org.services.CovidDataServices;

@Controller
public class CovidDataControllers {
	
	@Autowired
	private CovidDataServices obj2;
	
	@GetMapping("/")
	public String home(Model model){
		
		 List<CovidDataSource> allData = obj2.getAllData();
		 long totalconfirmed=allData.stream().mapToLong(actual ->actual.getConfirmed()).sum();
		 long totalrecovered=allData.stream().mapToLong(actual ->actual.getRecovered()).sum();
		 long totaldeceased=allData.stream().mapToLong(actual ->actual.getDeceased()).sum();
		 model.addAttribute("totalconfirmed",totalconfirmed);
		 model.addAttribute("totalrecovered",totalrecovered);
		 model.addAttribute("totaldeceased",totaldeceased);
		 model.addAttribute("CovidData",allData);
		 
		
		return "home";
	}

}
