package app.model;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import app.model.HtmlFile;

public class HtmlFileList {
	private List<HtmlFile> htmlFileList;
	
	public HtmlFileList() {
		htmlFileList = new ArrayList<HtmlFile>();
		loadAll();
	}
	
	public void loadAll() {
		htmlFileList.clear();
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String path = classLoader.getResource("data").getPath();
		File dataFolder = new File(path);
		File[] htmlFiles = dataFolder.listFiles(
			new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.endsWith("html");
				}
		});
		if (htmlFiles == null)
			return;
		
		for(File file : htmlFiles) {
			HtmlFile htmlFile = new HtmlFile(file.getPath(), file.getName());
			htmlFileList.add(htmlFile);
		}
	}
	
	public List<HtmlFile> getAll() {
		return htmlFileList;
	}
	
	
	public static String getHtml(String fileName) {
		String html = "<h1>Resource not found<h1>";
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String path = classLoader.getResource("data").getPath() + "/" + fileName + ".html";

    	try {
	        html = new String(Files.readAllBytes(Paths.get(path)));
		}
		catch (Exception ex) {
		}
		return html;
	}
}