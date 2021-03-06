//package event.organizer.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurity extends AbstractSecurityWebApplicationInitializer {
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth)
//			throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("password")
//				.roles("USER");
//	}
//
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/eventsHome/homePage")
//				.hasRole("ADMIN").anyRequest().authenticated().and()
//				.formLogin().loginPage("/eventsHome/homePage").permitAll();
//	}
//
//}
