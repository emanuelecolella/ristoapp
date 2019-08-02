package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import model.dao.DaoUtente;

/**
 * Servlet implementation class RegistrazioeUtente
 */
@WebServlet("/RegistrazioneUtente")
public class RegistrazioneUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> errori=new ArrayList<String>();
		DaoUtente du=new DaoUtente();
		String[] asterischi= {" "," "," "," "};
		
		if(request.getParameter("nome").equals("")) {
			errori.add("inserire il nome!");
			asterischi[0]="Inserire il nome";
		}else {
			asterischi[0]=" ";
		}
		if(request.getParameter("cognome").equals("")) {
			errori.add("inserire il cognome!");
			asterischi[1]="Inserire il cognome";
		}else {
			asterischi[1]="";
		}
		if(request.getParameter("username").equals("")) {
			errori.add("inserire l'username!");
			asterischi[2]="Inserire il nome utente";
		}else {
			asterischi[2]="";
		}
		if(request.getParameter("password").equals("")) {
			errori.add("inserire la password!");
			asterischi[3]="Inserire la password";
		}else {
			asterischi[3]="";
		}
		if(errori.size()==0) {
			Utente u=new Utente();
			u.setNome(request.getParameter("nome"));
			u.setCognome(request.getParameter("cognome"));
			u.setUsername(request.getParameter("username"));
			u.setPassword(request.getParameter("password"));
			du.inserimento(u);
			response.sendRedirect("inserimentoMenu");
		}else {
			
			request.setAttribute("listaErrori", errori);
			request.setAttribute("asterischi", asterischi);
			RequestDispatcher view=request.getRequestDispatcher("registrazione.jsp");
			view.forward(request, response);
				
		}
			}

}
