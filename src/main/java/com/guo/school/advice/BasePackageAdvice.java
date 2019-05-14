package com.guo.school.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import com.guo.school.webdataeditor.IntegerEditor;

@ControllerAdvice("com.guo.school")
public class BasePackageAdvice  {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Integer.class,"sex", new IntegerEditor());
	    binder.registerCustomEditor(Integer.class,"age", new IntegerEditor());
	    binder.registerCustomEditor(Integer.class,"id", new IntegerEditor());
	}
}
