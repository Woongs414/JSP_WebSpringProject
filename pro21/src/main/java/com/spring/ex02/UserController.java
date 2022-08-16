package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {
	 /* 1번 방법 
	 public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
	 	String userID ="";
	 	String passwd ="";
	 	ModelAndView mav = new ModelAndView();
	 	request.setCharacterEncoding("utf-8");
	 	userID = request.getParameter("userID");
	 	passwd = request.getParameter("passwd");
	 	
	 	mav.addObject("userID",userID);
	 	mav.addObject("passwd",passwd);
	 	mav.setViewName("result");
	 	return mav;
	 }

	2번 방법 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userID ="";
		String passwd = "";
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
		String viewName=getViewName(request);
		
		mav.addObject("userID",userID);
		mav.addObject("passwd",passwd);
		//mav.setViewName("result"); 를 직접선언하지않고 아래처럼 참조변수로 선언
		mav.setViewName(viewName);
		System.out.println("ViewName:" + viewName);
		return mav;
	}
	
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		mav.addObject("id",id);
		mav.addObject("pwd",pwd);
		mav.addObject("name",name);
		mav.addObject("email",email);
		mav.setViewName("memberInfo");
		return mav;
	}
	private String getViewName(HttpServletRequest request) throws Exception{
		String contextPath = request.getContextPath();
		String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
		if(uri==null || uri.trim().equals("")) {
			uri=request.getRequestURI();
		}
		
		//    http://localhost:8080/member/listMember.do로 요청시
			int begin = 0;
			if(!((contextPath==null)||("".equals(contextPath)))) {
 begin = contextPath.length(); //contextPath.length = 6이다 /pro21(/도 포함)
	}
			int end;
			if(uri.indexOf(";")!=-1) {
				end=uri.indexOf(";"); // 요청 uri에 ;가 있을경우 ;문자 위치를 구함
			}else if(uri.indexOf("?")!=-1) {
				end=uri.indexOf("?");
			}else {
				end=uri.length(); // /pro21/test/login.do 로서 20이다.
			}
			
			
	//	http://localhost:8080/member/listMember.do로 요청시 먼저 '.do'를 제거한
	//	http://localhost:8080/member/listMember를 구한후, 다시
	// 위에서 역순으로(뒤에서부터) 첫번째 '/'위치를 구한후, /뒤의 listMember를 구한다.
			String fileName=uri.substring(begin,end);
			if(fileName.indexOf(".")!=-1) {
				fileName=fileName.substring(0,fileName.lastIndexOf("."));
			}
			if(fileName.lastIndexOf("/")!=-1) {
				fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length());
			}
			return fileName;  //   /login이 나온다.
} 
}