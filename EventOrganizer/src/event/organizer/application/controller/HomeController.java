package event.organizer.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import event.organizer.domain.User;

@Controller
@RequestMapping("eventsHome")
public class HomeController {

	@RequestMapping("login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@RequestMapping("homePage")
	public ModelAndView homeScreen(@ModelAttribute User user) {
		System.out.println(user.getUserName());
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	

}
