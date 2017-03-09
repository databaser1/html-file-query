package app.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlanReaderController {
	
	@RequestMapping("/")
	public String index(Model model) {
		return "forward:index.html";
	}
	
    @RequestMapping(value="/plan/{month}/{day}", produces = {MediaType.TEXT_HTML_VALUE})
    public @ResponseBody String getHtml(@PathVariable String month, @PathVariable String day) {
    	String html = "";
        return html;
    } 
}