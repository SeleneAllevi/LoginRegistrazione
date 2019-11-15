package com.ats.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;

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
 * Servlet implementation class UtenteServlet
 */
@WebServlet("/UtenteServlet")
public class UtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//ArrayList <Utente> lista= new ArrayList <Utente>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtenteServlet() {
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
		String usernameInserito=((Utente)(session.getAttribute("UtenteCorrente"))).getUsername();
		try {
			s.cancellaUtente(usernameInserito);
		} catch (DaoException e) {
			session.setAttribute("erroreDao", "Error occurred during Delete");
			rd= request.getRequestDispatcher("PagError.jsp");
			rd.forward(request, response);
		}
		String messaggioDelete="Utente cancellato";
		session.setAttribute("messaggioDelete", messaggioDelete);
		rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteService s=new UtenteService();
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
		//boolean nomeuser_ok=true;
		Utente utrovato=null;
		try {
			utrovato = s.trovaUtente(request.getParameter("username"));
		} catch (DaoException e) {
			session.setAttribute("erroreDao", "Error occurred during Registration");
			rd= request.getRequestDispatcher("PagError.jsp");
			rd.forward(request, response);
			
		}
		
			if (utrovato.getNome()==null) {
			Utente utente=new Utente();
			utente.setUsername(request.getParameter("username"));
			utente.setPsw(request.getParameter("psw"));
			utente.setNome(request.getParameter("nome"));
			utente.setCognome(request.getParameter("cognome"));
			utente.setIndirizzo(request.getParameter("indirizzo"));
			utente.setCitta(request.getParameter("citta"));
			try {
			//LocalDate tmpDate= LocalDate.of(Integer.parseInt(request.getParameter("anno")),
								//			Integer.parseInt(request.getParameter("mese")),
								//			Integer.parseInt(request.getParameter("giorno")));
				

				String date = (request.getParameter("dataNascita"));
				
				//convert String to LocalDate
				LocalDate tmpDate = LocalDate.parse(date);
				utente.setDataNascita(tmpDate);
			try {
				s.aggiungiUtente(utente);
			} catch (DaoException e) {
				session.setAttribute("erroreDao", "Error occurred during Registration");
				rd= request.getRequestDispatcher("PagError.jsp");
				rd.forward(request, response);
			}
			response.getWriter().append("ho aggiunto un utente");
			session.setAttribute("UtenteCorrente", utente);
			rd= request.getRequestDispatcher("WelcomeUtente.jsp");
			rd.forward(request, response);
			}
		 catch (DateTimeParseException x) {
			session.setAttribute("erroreData", "Wrong date format: try again registration");
			rd= request.getRequestDispatcher("Registrazione.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			session.setAttribute("erroreData", "Wrong date format: try again registration");
			rd= request.getRequestDispatcher("Registrazione.jsp");
			rd.forward(request, response);
		}
			
		}
		else {
			String errore1=("Username già esistente");
			session.setAttribute("erroreUser", errore1);
			rd= request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			
		}
	}

}
