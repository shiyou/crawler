package com.crawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("file")
public class FileuploadController {

	@RequestMapping("up")
	public String upload(){
		
		return "";
	}
}
