package com.brokersystems.nav.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * System Main Navigation Controller
 * @author mugenyq
 *
 */
@Controller
@RequestMapping(value = "/protected/home")
public class NavigationController {
	
	 @RequestMapping(value="/orgsetups",method = RequestMethod.GET)
	    public ModelAndView orgSetups() {
	        return new ModelAndView("orgSetupScreen");
	    }
	 
	 /**
	  * Navigation to System Setups Screen
	  * @return
	  */
	 @RequestMapping(value="/setups",method = RequestMethod.GET)
	    public ModelAndView tensetups() {
	        return new ModelAndView("tensetups");
	    }
	 
	 /**
	  * Navigation to System Transaction Screen
	  * @return
	  */
	 @RequestMapping(value="/trans",method = RequestMethod.GET)
	    public ModelAndView trans() {
	        return new ModelAndView("tentrans");
	    }
	 
	
	 
	    
	    

}
