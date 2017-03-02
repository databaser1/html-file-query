package app;

import org.springframework.context.annotation.Bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import app.model.HtmlFileList;

@SpringBootApplication
public class HtmlFileQueryApplication {
	@Bean
	public HtmlFileList getHtmlFileList() {
		return new HtmlFileList();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HtmlFileQueryApplication.class, args);
	}
}
