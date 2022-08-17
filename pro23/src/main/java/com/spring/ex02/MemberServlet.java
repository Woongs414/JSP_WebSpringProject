/*
 * package com.spring.ex02;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import javax.servlet.RequestDispatcher; import javax.servlet.Servlet; import
 * javax.servlet.ServletConfig; import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 *//**
	 * Servlet implementation class MemberServlet
	 */
/*
 * @WebServlet("/mem2.do") public class MemberServlet extends HttpServlet {
 * private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public MemberServlet() { super(); // TODO Auto-generated constructor stub }
 * 
 *//**
	 * @see Servlet#init(ServletConfig)
	 */
/*
 * public void init(ServletConfig config) throws ServletException { // TODO
 * Auto-generated method stub }
 * 
 *//**
	 * @see Servlet#destroy()
	 */
/*
 * public void destroy() { // TODO Auto-generated method stub }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { doHandle(request,response);
 * }
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub doHandle(request, response); }
		 * 
		 * private void doHandle(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException{
		 * request.setCharacterEncoding("UTF-8");
		 * response.setContentType("text/html;charset=utf-8"); MemberDAO dao = new
		 * MemberDAO(); //String name = dao.selectName(); int pwd = dao.selectPwd();
		 * PrintWriter pw = response.getWriter(); pw.write("<script>"); //스크립트 형태로 출력
		 * //pw.write("alert('이름: " + name + "');");
		 * pw.write("alert('비밀번호 : "+pwd+"');"); pw.write("</script>"); }
		 * 
		 * private void doHandle(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException{
		 * request.setCharacterEncoding("UTF-8");
		 * response.setContentType("text/html;charset=utf-8"); MemberDAO dao = new
		 * MemberDAO(); List membersList = dao.selectAllMemberList();
		 * request.setAttribute("membersList", membersList); RequestDispatcher dispatch
		 * = request.getRequestDispatcher("test01/listMembers.jsp");
		 * dispatch.forward(request, response); } }
		 */