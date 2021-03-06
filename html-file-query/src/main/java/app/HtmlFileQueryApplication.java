package app;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import app.model.HtmlFileList;

@SpringBootApplication
public class HtmlFileQueryApplication {
	@Autowired
	private Environment environment;
	
	@Bean
	public HtmlFileList getHtmlFileList() {
		String appDataFolder = environment.getProperty("app.data.folder");
		return new HtmlFileList(appDataFolder);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HtmlFileQueryApplication.class, args);
	}
}
