package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Conto;
import model.Crud;
import model.Piatto;
import model.Tavolo;
import model.Utente;
import model.dao.DaoUtente;

/**
 * Servlet implementation class stampaConto
 */
@WebServlet("/stampaConto")
public class stampaConto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stampaConto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Crud c=new Crud();
		double somm=c.stampaConto(Integer.parseInt(request.getParameter("idtavolo")));
		if(somm!=0) {
			request.setAttribute("conto", somm);
			request.getRequestDispatcher("contoDaPagare.jsp").forward(request, response);
		} else {
			System.out.println("Non ho trovato l'id");
		}
	}

}
