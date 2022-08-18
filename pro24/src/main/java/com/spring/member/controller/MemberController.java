package com.spring.member.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

@WebServlet("/mem4.do")
public interface MemberController {

	ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
