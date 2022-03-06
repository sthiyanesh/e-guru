package com.eguru.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/joinus")
	public String joinus() {
		return "desktop1.jsp";
	}
}
