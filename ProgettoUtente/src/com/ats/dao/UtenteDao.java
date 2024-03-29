package com.ats.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

import com.ats.exception.DaoException;
import com.ats.model.Utente;
import com.ats.utility.SingletonConnection;

public class UtenteDao implements IUtenteDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	private Connection getConnection() {
		Connection con = null;
		try {
			con = SingletonConnection.getInstance().getConnection() ;
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public void addUtente(Utente utente) throws DaoException {
		String query="Insert into utente values (?,?,?,?,?,?,?)";
		
		conn=getConnection();
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1, utente.getUsername());
			ps.setString(2,  utente.getPsw());
			ps.setString(3,  utente.getNome());
			ps.setString(4,  utente.getCognome());
			ps.setString(5,  utente.getIndirizzo());
			ps.setString(6,  utente.getCitta());
			ps.setDate(7, Date.valueOf(utente.getDataNascita()) );
			
			int righeImplicate=ps.executeUpdate();
			System.out.println("Numero stringhe aggiunte:"+ righeImplicate);
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			throw new DaoException();
		}
		
		
		
	}

	@Override
	public void updateUtente(Utente utente) throws DaoException {
		String query="Update utente set psw=?, nome=?,cognome=?, indirizzo=?, citta=?, dataNascita=? where username=?";
		
		conn=getConnection();
		try {
			ps=conn.prepareStatement(query);
			ps.setString(7, utente.getUsername());
			ps.setString(1,  utente.getPsw());
			ps.setString(2,  utente.getNome());
			ps.setString(3,  utente.getCognome());
			ps.setString(4,  utente.getIndirizzo());
			ps.setString(5,  utente.getCitta());
			ps.setDate(6, Date.valueOf(utente.getDataNascita()) );
			
			int righeImplicate=ps.executeUpdate();
			System.out.println("Numero stringhe modificate:"+ righeImplicate);
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			throw new DaoException();
		}

		
	}

	@Override
	public void deleteUtente(String username) throws DaoException{
		String query="delete from utente where username=?";
		
		conn=getConnection();
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1, username);
			int righeImplicate=ps.executeUpdate();
			System.out.println("Numero righe cancellate: "+ righeImplicate);
		}
		catch (SQLException e) {
			throw new DaoException();
		}
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new DaoException();
			
		}
		
		
	}

	@Override
	public ArrayList<Utente> selectAll() throws DaoException{
		// TODO Auto-generated method stub
		String query="Select* from utente";
		conn=getConnection();
		ArrayList <Utente> listaL= new ArrayList <Utente>();
		try {
			ps=conn.prepareStatement(query);
		
		rs=ps.executeQuery();
		while(rs.next()) {
			Utente tmp=new Utente();
			tmp.setUsername(rs.getString("username"));
			tmp.setPsw(rs.getString("psw"));
			tmp.setNome(rs.getString("nome"));
			tmp.setCognome(rs.getString("cognome"));
			tmp.setIndirizzo(rs.getString("indirizzo"));
			tmp.setCitta(rs.getString("citta"));
			
			LocalDate tmpData=null;
			if (rs.getDate("dataNascita")!=null) {
			 tmpData=rs.getDate("dataNascita").toLocalDate();
				tmp.setDataNascita(tmpData);}
			else
				tmp.setDataNascita(null);
			
			listaL.add(tmp);
		}
		} catch (SQLException e) {
			throw new DaoException();
		
		}
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new DaoException();
			
		}
		return listaL;
	}

	@Override
	public Utente getUtente(String username) throws DaoException {
		String query="Select* from utente where username=?";
		conn=getConnection();
		Utente tmp=new Utente();
	
		try {
			ps=conn.prepareStatement(query);
	
		ps.setString(1, username);
		rs=ps.executeQuery();
		while(rs.next()) {
			
			tmp.setUsername(rs.getString("username"));
			tmp.setPsw(rs.getString("psw"));
			tmp.setNome(rs.getString("nome"));
			tmp.setCognome(rs.getString("cognome"));
			tmp.setIndirizzo(rs.getString("indirizzo"));
			tmp.setCitta(rs.getString("citta"));
			
			LocalDate tmpData=null;
			if (rs.getDate("dataNascita")!=null) {
			 tmpData=rs.getDate("dataNascita").toLocalDate();
				tmp.setDataNascita(tmpData);}
			else
				tmp.setDataNascita(null);
		
		}
		} catch (SQLException e) {
			throw new DaoException();
		}
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new DaoException();
			
		}
		return tmp;	
	}
}
