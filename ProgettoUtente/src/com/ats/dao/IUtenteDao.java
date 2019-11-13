package com.ats.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import com.ats.model.Utente;

public interface IUtenteDao {
	public void addUtente(Utente utente);
	public void updateUtente(Utente utente) throws SQLException;
	public void deleteUtente (String username) throws SQLException;
	public ArrayList<Utente> selectAll() throws SQLException;
	public Utente getUtente(String username) throws SQLException;

}
