package com.guo.school.dao;

import java.util.List;

import com.guo.school.domain.Menu;

public interface MenuDao {
	public List<Menu> listMenus();
	public List<Menu> findMenusByParentId(Integer parentId);
	public List<Menu> findMenusByLevels(Integer levels);
}
