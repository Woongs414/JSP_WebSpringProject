package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.service.MemberServiceImpl;
import com.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements
MemberController {
	private MemberService memberService;
	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception{
	String viewName = getViewName(request);
	List membersList = memberService.listMembers();
	ModelAndView mav = new ModelAndView(viewName);
	mav.addObject("membersList", membersList);
	return mav;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		// http://localhost:8080/member/listMember.do로 요청시
		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length(); // contextPath.length = 6이다 /pro21(/도 포함)
		}
		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";"); // 요청 uri에 ;가 있을경우 ;문자 위치를 구함
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length(); // /pro21/test/login.do 로서 20이다.
		}

		// http://localhost:8080/member/listMember.do로 요청시 먼저 '.do'를 제거한
		// http://localhost:8080/member/listMember를 구한후, 다시
		// 위에서 역순으로(뒤에서부터) 첫번째 '/'위치를 구한후, /뒤의 listMember를 구한다.
		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}
		return fileName; // /login이 나온다.
	}
	@Override
	public ModelAndView addMember(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		MemberVO memberVO = new MemberVO();
		bind(request,memberVO);
		int result=0;
		result = memberService.addMember(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@Override
	public ModelAndView removeMember(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	public ModelAndView form(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
}
