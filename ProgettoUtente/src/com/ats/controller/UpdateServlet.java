package com.ats.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		UtenteService s=new UtenteService();
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
		Utente utente=new Utente();
		String username=((Utente)(session.getAttribute("UtenteCorrente"))).getUsername();
		utente.setUsername(username);
		utente.setPsw(request.getParameter("psw"));
		utente.setNome(request.getParameter("nome"));
		utente.setCognome(request.getParameter("cognome"));
		utente.setIndirizzo(request.getParameter("indirizzo"));
		utente.setCitta(request.getParameter("citta"));
		
		try {
		String date = (request.getParameter("dataNascita"));
		LocalDate tmpDate = LocalDate.parse(date);
		utente.setDataNascita(tmpDate);
		
		try {
			s.aggiornaUtente(utente);
		} catch (DaoException e) {
			session.setAttribute("erroreDao", "Error occurred during Update");
			rd= request.getRequestDispatcher("PagError.jsp");
			rd.forward(request, response);
		}
		session.setAttribute("UtenteAggiornato", "Il profilo è stato aggiornato!");
		rd= request.getRequestDispatcher("WelcomeUtente.jsp");
		rd.forward(request, response);
	}
	 catch (DateTimeParseException x) {
		session.setAttribute("erroreData", "Wrong date format: try again registration");
		rd= request.getRequestDispatcher("Update.jsp");
		rd.forward(request, response);

	} catch (Exception e) {
		session.setAttribute("erroreData", "Wrong date format: try again registration");
		rd= request.getRequestDispatcher("Update.jsp");
		rd.forward(request, response);
	}

		
	
	}

}
