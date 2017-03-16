package app.controller;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlanReaderController {
private static String planFolder = "plan";
  @Autowired
  Map<String, String> bookList;
	
	@RequestMapping("/")
	public String index(Model model) {
		return "forward:index.html";
	}
	
  @RequestMapping(value="/plan/{month}/{date}", produces = {MediaType.TEXT_HTML_VALUE})
  public @ResponseBody String getHtml(@PathVariable String month, @PathVariable String date) {
  	String html = "";

  	String planPrefix = (month.length() < 2 ? "0" + month : month) + "." + (date.length() < 2 ? "0" + date : date); 
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String path = classLoader.getResource(planFolder).getPath();
		File planFolder = new File(path);
		File[] planFiles = planFolder.listFiles(
			new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.startsWith(planPrefix);
				}
		});
		if (planFiles == null)
			return "";
		
	  ArrayList<File> files = new ArrayList<File>(Arrays.asList(planFiles));
	 
	  Collections.sort(files, new Comparator<File>() { 
	    public int compare(File f1, File f2) { 
	      return f1.getName().compareTo(f2.getName()); 
      }
	  });
	  
		String[] nameParts;
		String fileName, bookCode, bookName, chapterNum, content;
		for(File file : files) {
		  fileName = file.getName();
		  nameParts = fileName.split("\\.");
		  bookCode = nameParts[2];
		  bookName = bookList.get(bookCode);
		  chapterNum = nameParts[3];
	    path = file.getPath();
	    content = "";
      try {
          content = new String(Files.readAllBytes(Paths.get(path)));
      }
      catch (Exception ex) {
      }
      content = "<div class='plan-content'><h3><a class='content-anchor' id='" + bookCode + "." + chapterNum + "'></a>" + bookName + " " + chapterNum + "</h3>" + content + "</div>";
      html += content;
		}
    	
    return html;
  } 
}