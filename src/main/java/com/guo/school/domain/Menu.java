package com.guo.school.domain;

import java.util.Date;
import java.util.List;

public class Menu {
	private Integer id;
	private String name;
	private Integer parentId;
	private String url;
	private Integer levels;
	private Integer orders;
	private Date createTime;
	private Date updateTime;
	private Integer firstId;
	private Integer secondId;
	private Integer thridId;
	private String firstName;
	private String secondName;
	private String thridName;
	private List<Menu> childMenus;
	private String style;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getLevels() {
		return levels;
	}
	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	public Integer getOrders() {
		return orders;
	}
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getFirstId() {
		return firstId;
	}
	public void setFirstId(Integer firstId) {
		this.firstId = firstId;
	}
	public Integer getSecondId() {
		return secondId;
	}
	public void setSecondId(Integer secondId) {
		this.secondId = secondId;
	}
	public Integer getThridId() {
		return thridId;
	}
	public void setThridId(Integer thridId) {
		this.thridId = thridId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getThridName() {
		return thridName;
	}
	public void setThridName(String thridName) {
		this.thridName = thridName;
	}
	public List<Menu> getChildMenus() {
		return childMenus;
	}
	public void setChildMenus(List<Menu> childMenus) {
		this.childMenus = childMenus;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	
}
