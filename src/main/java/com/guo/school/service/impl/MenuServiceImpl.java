package com.guo.school.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guo.school.dao.MenuDao;
import com.guo.school.domain.Menu;
import com.guo.school.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	private MenuDao menuDao;
	
	public MenuDao getMenuDao() {
		return menuDao;
	}
	@Resource
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<Menu> listMenus() {
		// TODO Auto-generated method stub
		List<Menu> menus=new ArrayList<Menu>();
		menus=menuDao.findMenusByLevels(1);
		Iterator<Menu> it = menus.iterator();
		while (it.hasNext()) {
		   List<Menu> secondMenus=new ArrayList<Menu>();
		   Menu firstMenu = (Menu) it.next();
		   secondMenus=menuDao.findMenusByParentId(firstMenu.getId());
		   Iterator<Menu> secondIt = secondMenus.iterator();
		   while (secondIt.hasNext()) {
			Menu menu = (Menu) secondIt.next();
			List<Menu> thirdMens=new ArrayList<Menu>();
			thirdMens=menuDao.findMenusByParentId(menu.getId());
			menu.setChildMenus(thirdMens);
		   }
		   
		   firstMenu.setChildMenus(secondMenus);
		}
		return menus;
	}

}
