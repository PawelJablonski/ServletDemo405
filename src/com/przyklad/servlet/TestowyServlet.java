package com.przyklad.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestowyServlet
 */
@WebServlet("/TestowyServlet")
public class TestowyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestowyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		List<String> napisy = new ArrayList<String>();
		
		
		
		
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		
		Integer odwiedziny = (Integer) context.getAttribute("odwiedziny");
		if(odwiedziny.equals(null)) odwiedziny=0;
		odwiedziny++;

		String name = request.getParameter("name");
		
		napisy.add((String)request.getParameter("napisy"));
		if(name!=null)
		{
		session.setAttribute("name", name);
		session.setAttribute("napisy", napisy);
		context.setAttribute("odwiedziny", odwiedziny);
		}
		
		ArrayList<String> odtworzone = (ArrayList<String>) session.getAttribute("napisy");
		writer.println("<h1>HELLO "+ session.getAttribute("name") +" </h1>");
		writer.println("ze zmiennej context: "+context.getAttribute("name"));
		writer.println("<a href='DrugiServlet' > klik </a>");
		writer.println("odtworzone:" + odtworzone.get(0));
		writer.print("<br /> Odwiedziny: " +odwiedziny);
		
		
	}

}
