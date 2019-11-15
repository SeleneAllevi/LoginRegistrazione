package com.ats.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * Servlet implementation class ListaServlet
 */
@WebServlet("/ListaServlet")
public class ListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtenteService s=new UtenteService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//IN CONSOLE STAMPA LA LISTA
		//String userIns=request.getParameter("username");
		//String pswIns=request.getParameter("psw");
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
		
		if (((Utente)((session.getAttribute("UtenteCorrente")))).getUsername().equalsIgnoreCase("admin") && ((Utente)((session.getAttribute("UtenteCorrente")))).getPsw().equalsIgnoreCase("admin123")){
			ArrayList<Utente> listaTutti=null;
		try {
			listaTutti = s.selezionaTutti();
		} catch (DaoException e) {
			session.setAttribute("erroreDao", "Error occurred during ListView");
			rd= request.getRequestDispatcher("PagError.jsp");
			rd.forward(request, response);
		}
		
		session.setAttribute("EveryOne", listaTutti);
		System.out.println("stampalista" + listaTutti);
		rd=request.getRequestDispatcher("EveryOne.jsp");
		rd.forward(request, response);}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
