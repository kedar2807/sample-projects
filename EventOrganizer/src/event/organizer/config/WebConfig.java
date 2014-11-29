package event.organizer.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer{
	
	@Override
	public void onStartup(ServletContext context) throws ServletException {
		WebApplicationContext webContext = getApplicationContext();
		context.addListener(new ContextLoaderListener(webContext));
		ServletRegistration.Dynamic dynamic = context.addServlet("DispatcherServlet", new DispatcherServlet(webContext));
		dynamic.setLoadOnStartup(1);
		dynamic.addMapping("/");
		
	}
	
	private AnnotationConfigWebApplicationContext getApplicationContext(){
		
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.setConfigLocation("event.organizer.config");
		return applicationContext;
	}
	
//	 protected Class<?>[] getRootConfigClasses() {
//	        return new Class[] {SpringSecurity.class };
//	    }

}
