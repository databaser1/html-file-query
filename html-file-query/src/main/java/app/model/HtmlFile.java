package app.model;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class HtmlFile {
	private String path;
	private String name;
	
	public HtmlFile() {
		path = null;
		name = null;
	}
	public HtmlFile(String path, String name) {
		this.path = path;
		this.name = name;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	public String getPath() {
		return path;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	@JsonIgnore
	public String getHtml() {
		String html = null;
    	try {
	        html = new String(Files.readAllBytes(Paths.get(path)));
		}
		catch (Exception ex) {
		}
		return html;
	}

}