package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Tavolo;
import model.Crud;

/**
 * Servlet implementation class inserimentoMenu
 */
@WebServlet("/inserimentoTavolo")
public class inserimentoTavolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inserimentoTavolo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Crud c=new Crud();
		ArrayList<Tavolo> tavoli=c.visualizzaTavoli();
		HttpSession session=request.getSession();
		session.setAttribute("tavolo", tavoli);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recupero parametri tavolo

		Tavolo t=new Tavolo();
		t.setCoperti(Integer.parseInt(request.getParameter("coperti")));
		
		Crud c=new Crud();
		c.inserimentoTavolo(t);
		
		ArrayList<Tavolo> tavoli=c.visualizzaTavoli();
		HttpSession session=request.getSession();
		session.setAttribute("tavolo", tavoli);
		
		response.sendRedirect("success.jsp");		
		
	}
		

}
