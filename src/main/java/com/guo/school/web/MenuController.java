package com.guo.school.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guo.school.domain.Menu;
import com.guo.school.service.MenuService;

@Controller
@RequestMapping(value="/menu")
public class MenuController {
	private MenuService menuServiceImpl;

	public MenuService getMenuServiceImpl() {
		return menuServiceImpl;
	}
	@Resource
	public void setMenuServiceImpl(MenuService menuServiceImpl) {
		this.menuServiceImpl = menuServiceImpl;
	}



	@RequestMapping(value="listMenus")
	public ModelAndView listMenus() {
		List<Menu> listMenus=menuServiceImpl.listMenus();
		ModelAndView mav=new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value="menuIndex")
	public ModelAndView menuIndex() {
		List<Menu> listMenus=menuServiceImpl.listMenus();
		ModelAndView mav=new ModelAndView();
		mav.addObject("listMenus", listMenus);
		mav.setViewName("common/menu");
		return mav;
	}
}
