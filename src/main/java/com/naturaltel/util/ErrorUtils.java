package com.naturaltel.util;

import org.apache.logging.log4j.Logger;
import org.springframework.ui.Model;

public class ErrorUtils {
	public static String showError(Logger logger, Model model, Exception e) {
	    logger.error(e);
	    model.addAttribute("errorMessage", e.getMessage());
	    
	    return "/Common/busy";
	}
	
	public static String showError(Logger logger, Model model, String reportAction) {
	    logger.error(reportAction);
	    model.addAttribute("errorMessage", reportAction);
	    
	    return "/Common/busy";
	}

	public static String showError(Logger logger, Exception e) {
	    logger.error(e);
	    return "/Common/busy";
	}
	
	public static String fail(Logger logger ,Model model,String  reportAction) {
	    logger.error(reportAction);
	    model.addAttribute("errorMessage", reportAction);
	    return "fail";
	}
	
	public static void error(Logger logger ,Exception e) {
	    logger.error(e);
	}
}