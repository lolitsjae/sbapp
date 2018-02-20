package studentz.controller;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;




@EnableWebMvc
@EnableAutoConfiguration
public class WebConfig{
	
	@Component
	public static class interceptorconfig extends WebMvcConfigurerAdapter{
		@Override
		public void addInterceptors(InterceptorRegistry registry) { //add interceptors for specific paths
				registry.addInterceptor(new Interceptorz())
				.addPathPatterns("/addStudent", "/getAll", "/getStudent", "/deleteStudent", "/deleteAll", "/updateStudent");
		}
	}
}
