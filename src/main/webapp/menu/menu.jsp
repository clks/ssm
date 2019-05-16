<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        
        
	      <c:forEach items="${listMenus }" var="menu">
	      <c:if test="${fn:length(menu.childMenus)==0 }">
	      	<li class="nav-item" data-toggle="tooltip" data-placement="right" title="${menu.name}">
	          <a class="nav-link" href="<%=basePath%>${menu.url }">
	            <i class="fa fa-fw ${menu.style }"></i>
	            <span class="nav-link-text">${menu.name}</span>
	          </a>
	        </li>
	      </c:if>
	      <c:if test="${ fn:length(menu.childMenus)!=0 }">
	      		<li class="nav-item" data-toggle="tooltip" data-placement="right" title="${menu.name}">
			          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents${menu.id }" data-parent="#exampleAccordion">
			            <i class="fa fa-fw ${menu.style }"></i>
			            <span class="nav-link-text">${menu.name}</span>
			          </a>
			          <ul class="sidenav-second-level collapse" id="collapseComponents${menu.id }">
			      		<c:forEach items="${menu.childMenus }" var="secondMenus">
					            <li>
					            <c:if test="${fn:length(secondMenus.childMenus)==0 }">
					            	<a href="#collapseComponents${secondMenus.id }">${secondMenus.name }</a>
					            </c:if>
						      		<c:if test="${fn:length(secondMenus.childMenus)!=0 }">
					              <a class="nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents${secondMenus.id }">${secondMenus.name }</a>
						      			<ul class="sidenav-third-level collapse" id="collapseComponents${secondMenus.id }">
						      			<c:forEach items="${secondMenus.childMenus }" var="thirdMenus">
							                <li>
							                  <a href="#">${thirdMenus.name }</a>
							                </li>
							                
								      	</c:forEach>
							             </ul>
						      		</c:if>
					  		  </li>  	
				      	</c:forEach>
				      </ul>
			    </li>
	      </c:if>
		 </c:forEach>
        
      </ul>

    
 
