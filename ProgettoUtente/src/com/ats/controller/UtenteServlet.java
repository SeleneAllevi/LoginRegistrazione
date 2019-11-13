package com.ats.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		s.cancellaUtente(usernameInserito);
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
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			if (utrovato.getNome()==null) {
			Utente utente=new Utente();
			utente.setUsername(request.getParameter("username"));
			utente.setPsw(request.getParameter("psw"));
			utente.setNome(request.getParameter("nome"));
			utente.setCognome(request.getParameter("cognome"));
			utente.setIndirizzo(request.getParameter("indirizzo"));
			utente.setCitta(request.getParameter("citta"));
//			try {
			//LocalDate tmpDate= LocalDate.of(Integer.parseInt(request.getParameter("anno")),
								//			Integer.parseInt(request.getParameter("mese")),
								//			Integer.parseInt(request.getParameter("giorno")));
				

				String date = (request.getParameter("dataNascita"));
				
				//convert String to LocalDate
				LocalDate tmpDate = LocalDate.parse(date);
			utente.setDataNascita(tmpDate);
			s.aggiungiUtente(utente);
			response.getWriter().append("ho aggiunto un utente");
			session.setAttribute("UtenteCorrente", utente);
			rd= request.getRequestDispatcher("WelcomeUtente.jsp");
			rd.forward(request, response);
			}
//		 catch (InputMismatchException | NumberFormatException x) {
//			String eccezioneMismatch=("Eccezione: " + x + " ");
//			response.getWriter().append("Non hai inserito la data correttamente" + eccezioneMismatch);
//			rd= request.getRequestDispatcher("Registrazione.jsp");
//			rd.forward(request, response);

//		} catch (Exception e) {
//			System.out.println("Eccezione: " + e);
//		}
			
//		}
		else {
			String errore1=("Username già esistente");
			session.setAttribute("erroreUser", errore1);
			rd= request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			
		}
	}

}
