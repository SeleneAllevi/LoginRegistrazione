package com.ats.service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.ats.dao.UtenteDao;
import com.ats.exception.DaoException;
import com.ats.model.Utente;

public class UtenteService {
	UtenteDao dao=new UtenteDao();
	
	public void aggiungiUtente(Utente utente) throws DaoException {
		dao.addUtente(utente);
	}
	public void aggiornaUtente(Utente utente) throws  DaoException {
		dao.updateUtente(utente);
	}
	public void cancellaUtente (String username) throws DaoException {
		dao.deleteUtente(username);
	}
	public ArrayList<Utente> selezionaTutti() throws DaoException{
		return dao.selectAll();
	}
	public Utente trovaUtente(String username) throws DaoException  {
		return dao.getUtente(username);
		
	}
	

}
