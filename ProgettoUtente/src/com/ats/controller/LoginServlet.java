package com.ats.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.model.Utente;
import com.ats.service.UtenteService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.sendRedirect("http://localhost:8082/ProgettoUtente/WelcomeUtente.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		UtenteService s=new UtenteService();
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
		String errore2="Username non riconosciuto";
		String errore3="Password non riconosciuta";
		try {
			Utente utrovato=s.trovaUtente(request.getParameter("username"));
			if (utrovato.getUsername()==null) {
				//response.sendRedirect("Registrazione.jsp");
				session.setAttribute("erroreUserInesistente", errore2);
				rd= request.getRequestDispatcher("Registrazione.jsp");
				rd.forward(request, response);
				
			}
			else {
				session.setAttribute("UtenteCorrente", utrovato);
				String passwordInserita=request.getParameter("psw");
				if (passwordInserita.equalsIgnoreCase(utrovato.getPsw())) {
				//response.sendRedirect("http://localhost:8082/ProgettoUtente/WelcomeUtente.jsp");
					rd= request.getRequestDispatcher("WelcomeUtente.jsp");
					rd.forward(request, response);	
					
				}
				else {
					session.setAttribute("errorePasswordInesistente", errore3);
					rd= request.getRequestDispatcher("home.jsp");
					rd.forward(request, response);
					
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
