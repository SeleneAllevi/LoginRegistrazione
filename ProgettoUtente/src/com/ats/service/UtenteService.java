package com.ats.service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.ats.dao.UtenteDao;
import com.ats.model.Utente;

public class UtenteService {
	UtenteDao dao=new UtenteDao();
	
	public void aggiungiUtente(Utente utente) {
		dao.addUtente(utente);
	}
	public void aggiornaUtente(Utente utente) throws SQLException {
		dao.updateUtente(utente);
	}
	public void cancellaUtente (String username) {
		dao.deleteUtente(username);
	}
	public ArrayList<Utente> selezionaTutti(){
		return dao.selectAll();
	}
	public Utente trovaUtente(String username) throws SQLException {
		return dao.getUtente(username);		
	}
	

}
