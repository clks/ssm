package com.guo.school.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		mav.setViewName("menu/menu");
		return mav;
	}
	
	@RequestMapping(value = "charts",method = RequestMethod.GET)
    public String charts(HttpServletRequest request, HttpServletResponse response){
		List<Menu> listMenus=menuServiceImpl.listMenus();
		request.setAttribute("listMenus", listMenus);
        return "menu/jsp/charts";
    }
	@RequestMapping(value = "components",method = RequestMethod.GET)
    public String components(HttpServletRequest request, HttpServletResponse response){
		List<Menu> listMenus=menuServiceImpl.listMenus();
		request.setAttribute("listMenus", listMenus);
        return "menu/jsp/components";
    }
	@RequestMapping(value = "dashboard",method = RequestMethod.GET)
    public String dashboard(HttpServletRequest request, HttpServletResponse response){
		List<Menu> listMenus=menuServiceImpl.listMenus();
		request.setAttribute("listMenus", listMenus);
        return "menu/jsp/dashboard";
    }
	@RequestMapping(value = "examplepages",method = RequestMethod.GET)
    public String examplePages(HttpServletRequest request, HttpServletResponse response){
		List<Menu> listMenus=menuServiceImpl.listMenus();
		request.setAttribute("listMenus", listMenus);
        return "menu/jsp/examplePages";
    }
	@RequestMapping(value = "link",method = RequestMethod.GET)
    public String link(HttpServletRequest request, HttpServletResponse response){
		List<Menu> listMenus=menuServiceImpl.listMenus();
		request.setAttribute("listMenus", listMenus);
        return "menu/jsp/link";
    }
	@RequestMapping(value = "menulevels",method = RequestMethod.GET)
    public String menuLevels(HttpServletRequest request, HttpServletResponse response){
		List<Menu> listMenus=menuServiceImpl.listMenus();
		request.setAttribute("listMenus", listMenus);
        return "menu/jsp/menuLevels";
    }
	@RequestMapping(value = "tables",method = RequestMethod.GET)
    public String tables(HttpServletRequest request, HttpServletResponse response){
		List<Menu> listMenus=menuServiceImpl.listMenus();
		request.setAttribute("listMenus", listMenus);
        return "menu/jsp/tables";
    }
}
