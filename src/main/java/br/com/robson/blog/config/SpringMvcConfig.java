package br.com.robson.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("br.com.robson.blog")
public class SpringMvcConfig extends WebMvcConfigurerAdapter{

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResovler = new CommonsMultipartResolver();
		multipartResovler.setMaxUploadSize(100000);
		
		return multipartResovler;
	}
	
	@Bean(name = "jspViewResolver")
	public InternalResourceViewResolver resouverViewRosolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		
		return viewResolver;
	}
}
