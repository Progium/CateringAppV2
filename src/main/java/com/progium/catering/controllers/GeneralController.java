package com.progium.catering.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
* Esta clase se encarga de crear el controlador
* para el manejo de las diferentes funcionalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
@Controller
@RequestMapping(value = "/")
public class GeneralController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login(Locale locale, Model model,HttpServletRequest request,HttpServletResponse response) {				
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value = "app", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model,HttpServletRequest request,HttpServletResponse response) {				
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
}
