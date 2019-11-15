package com.ats.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.ats.exception.DaoException;
import com.ats.model.Utente;

public interface IUtenteDao {
	public void addUtente(Utente utente) throws DaoException;
	public void updateUtente(Utente utente) throws DaoException;
	public void deleteUtente (String username) throws DaoException;
	public ArrayList<Utente> selectAll() throws DaoException;
	public Utente getUtente(String username) throws DaoException;

}
