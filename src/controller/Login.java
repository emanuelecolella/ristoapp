package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Crud;
import model.Piatto;
import model.Tavolo;
import model.Utente;
import model.dao.DaoUtente;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DaoUtente du=new DaoUtente();
		Utente u=du.returnUtentebyUsername(request.getParameter("username"),request.getParameter("password"));
		HttpSession session=request.getSession();
		if(u!=null) {
			session.setAttribute("utente", u);
			session.getLastAccessedTime();
			
			Crud c=new Crud();
			ArrayList<Piatto> piatti=c.visualizza();
			session.setAttribute("menu", piatti);
			ArrayList<Tavolo> tavoli=c.visualizzaTavoli();
			session.setAttribute("tavoli", tavoli);	
			
			response.sendRedirect("home.jsp");
		}else {
			request.setAttribute("messaggio", "username o password sbagliati");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		}

}
