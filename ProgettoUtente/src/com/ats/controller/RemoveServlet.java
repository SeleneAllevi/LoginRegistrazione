package com.ats.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.dao.IUtenteDao;
import com.ats.dao.UtenteDao;
import com.ats.model.Utente;
import com.ats.service.UtenteService;


@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	private UtenteDao dao;



//ciao//


	public RemoveServlet() {
		super();
		dao = new UtenteDao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		RequestDispatcher rd=null;

		
	
		String userIns=request.getParameter("userCanc");
	
		
		System.out.println("c'è l'username?" + userIns);
		//request.getParameter("username");
		//String pswIns=request.getParameter("psw");

		//String Inserisci_o_modifica = "WelcomeUtente.jsp";
		//String listaUtenti = "EveryOne.jsp";
		//String forward="";
		// String bottom = request.getParameter("bottom");
		
		UtenteService s=new UtenteService();

		//    
		//if (bottom.equals("delete")){

		if (((Utente)((session.getAttribute("UtenteCorrente")))).getUsername().equalsIgnoreCase("admin") && ((Utente)((session.getAttribute("UtenteCorrente")))).getPsw().equalsIgnoreCase("admin123")){
			//ArrayList <Utente>listaTutti=s.selezionaTutti();
			s.cancellaUtente(userIns);
			request.setAttribute("users",userIns);
			rd = request.getRequestDispatcher("WelcomeUtente.jsp");
			rd.forward(request, response);
		}
		else {
			rd=request.getRequestDispatcher("home.jsp");
			session.getAttribute("userCanc");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
