package studentz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("heyhey")
public class Interceptorz implements HandlerInterceptor{
	

//checks that the header for request is valid	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
	         Object handler) throws Exception {
			String authHeader = req.getHeader("Authentication");
			boolean same = authHeader.equals("hello");
			
			try {
				if(!same) {
					throw new NullPointerException();
				}
			} 
			catch (NullPointerException e) {				
				System.out.println("Wrong Header Key!");
				res.setStatus(404);
			}
		return same;
		}
	
	 @Override
	   public void postHandle(HttpServletRequest req, HttpServletResponse res, 
	         Object handler, ModelAndView model)  throws Exception {
	 }
	 
	 @Override
	   public void afterCompletion(HttpServletRequest req, HttpServletResponse res,
	         Object handler, Exception ex)  throws Exception {
	 }

}
