package com.ats.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.exception.DaoException;
import com.ats.model.Utente;
import com.ats.service.UtenteService;

/**
 * Servlet implementation class Update2Servlet
 */
@WebServlet("/Update2Servlet")
public class Update2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UtenteService s=new UtenteService();
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
		Utente utente=new Utente();
		String username=(String)session.getAttribute("usernamePortamiVia");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteService s=new UtenteService();
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
		Utente utente=new Utente();
		String username=(String)session.getAttribute("usernamePortamiVia");
		System.out.println(username);
		
		utente.setUsername(username);
		utente.setPsw(request.getParameter("psw"));
		utente.setNome(request.getParameter("nome"));
		utente.setCognome(request.getParameter("cognome"));
		utente.setIndirizzo(request.getParameter("indirizzo"));
		utente.setCitta(request.getParameter("citta"));
		
		String date = (request.getParameter("dataNascita"));
		LocalDate tmpDate = LocalDate.parse(date);
		utente.setDataNascita(tmpDate);
		
		try {
			s.aggiornaUtente(utente);
		} catch (DaoException e) {
			session.setAttribute("erroreDao", "Error occurred during UpdateTable");
			rd= request.getRequestDispatcher("PagError.jsp");
			rd.forward(request, response);
		}
		session.setAttribute("UtenteAggiornato", "Il profilo è stato aggiornato!");
		rd= request.getRequestDispatcher("WelcomeUtente.jsp");
		rd.forward(request, response);
	}

}
