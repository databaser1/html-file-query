package app.model;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class HtmlFile {
	private String path;
	private String name;
	private String basename;
	private String extension;
	
	public HtmlFile() {
		path = null;
		name = null;
		basename = null;
		extension = null;
	}
	public HtmlFile(String path, String name) {
		this.path = path;
		this.name = name;
		int i = name.lastIndexOf('.');
		if (i > 0) {
		    basename = name.substring(0, i);
		    extension = name.substring(i+1);
		}
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

	public String getBasename() {
		return basename;
	}
	public void setBasename(String basename) {
		this.basename = basename;
	}
	
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
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