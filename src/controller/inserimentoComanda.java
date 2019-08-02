package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Crud;
import model.Piatto;
import model.Tavolo;

/**
 * Servlet implementation class inserimentoComanda
 */
@WebServlet("/inserimentoComanda")
public class inserimentoComanda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inserimentoComanda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				Piatto p=new Piatto();
				Tavolo t=new Tavolo();
				
				t.setNumeroTavolo(Integer.parseInt(request.getParameter("idtavolo")));	// Passo il parametro numero tavolo
				p.setId(Integer.parseInt(request.getParameter("idpiatto"))); 			// Passo il parametro id piatto
				// t.setCoperti(Integer.parseInt(request.getParameter("coperti")));     // Passo il parametro numero coperti
				
				Crud c=new Crud();
				c.inserimentoComanda(p,t);
				
				
//			    view=request.getRequestDispatcher("index.jsp");
//			    view.forward(request, response);
				
				request.setAttribute("inserimentoRiuscito", "");
				request.getRequestDispatcher("index.jsp").forward(request, response);
//			    response.sendRedirect("inserimentoMenu");
	}

}
