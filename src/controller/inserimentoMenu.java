package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Piatto;
import model.Tavolo;
import model.Crud;

/**
 * Servlet implementation class inserimentoMenu
 */
@WebServlet("/inserimentoMenu")
public class inserimentoMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inserimentoMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Crud c=new Crud();
		ArrayList<Piatto> piatti=c.visualizza();
		HttpSession session=request.getSession();
		session.setAttribute("menu", piatti);
		ArrayList<Tavolo> tavoli=c.visualizzaTavoli();
		session.setAttribute("tavoli", tavoli);		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Piatto p=new Piatto();
	p.setNome(request.getParameter("nome"));
	p.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
	
	Crud c=new Crud();
	c.inserimento(p);
	
	response.sendRedirect("success.jsp");
	
}

}
