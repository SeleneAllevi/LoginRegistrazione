package com.ats.dao;

import java.sql.SQLException;
import java.time.LocalDate;

import com.ats.model.Utente;
import com.ats.dao.UtenteDao;

public class test {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Utente u3= new Utente();
		u3.setUsername("u3");
		u3.setPsw("psw3");
		u3.setNome("n3");
		u3.setCognome("cognome3");
		u3.setIndirizzo("i3");
		u3.setCitta("citt3");
		LocalDate data3=LocalDate.of(2013, 01, 01);
		u3.setDataNascita(data3);
		
		UtenteDao dao=new UtenteDao();
		//dao.addUtente(u1);
		
		dao.deleteUtente("asia");

//			try {
//				dao.updateUtente(u3);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		System.out.println(dao.selectAll());	
	}

}
