package model;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Piatto;
import model.Tavolo;
import model.iCrud;

public class Crud implements iCrud{

	public final static String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://localhost:3306/ristorante1";
	public final static String DB_USERNAME = "root";
	public final static String DB_PASSWORD = "";
	private static Connection conn = null;
	//Caricamento del Driver con il metodo forName() dell’oggetto Class
	
	Piatto p=new Piatto();
	

	static{
		try {
			Class.forName(DB_DRIVER_CLASS);
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static Crud instanza = null;

	public static Crud getInstanza() {

		if(instanza==null) {
			instanza=new Crud();
		}
		return instanza;
	}

	
	
	public void inserimento(Piatto p)  {
		String sql = "INSERT INTO menu(nome,prezzo) VALUES (?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setDouble(2, p.getPrezzo());		
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void inserimentoTavolo(Tavolo t)  {
		String sql = "INSERT INTO tavoli(coperti) VALUES (?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getCoperti());		
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<Piatto> visualizza() {
		
		ArrayList<Piatto> piatti=new ArrayList<Piatto>();
		
		String query = "SELECT * FROM menu";
		PreparedStatement ps;

		try {			
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// Read values using column name
				Piatto p=new Piatto();
				p.setId(rs.getInt("ID"));
				p.setNome(rs.getString("nome"));
				p.setPrezzo(rs.getDouble("prezzo"));
				piatti.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	

		return piatti;
	}
	
		public ArrayList<Tavolo> visualizzaTavoli() {
		
		ArrayList<Tavolo> tavoli=new ArrayList<Tavolo>();
		
		String query = "SELECT * FROM tavoli";
		PreparedStatement ps;

		try {			
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// Read values using column name
				Tavolo t=new Tavolo();
				t.setId(rs.getInt("id"));
				tavoli.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	

		return tavoli;
	}
	
	public void inserimentoComanda(Piatto p, Tavolo t)  {
		String sql = "INSERT INTO ordini(id_tavolo,id_piatto) VALUES (?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getNumeroTavolo());
			ps.setInt(2, p.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public double stampaConto(int idtavolo) {								
		String sql = "SELECT SUM(prezzo) FROM ordini INNER JOIN menu ON ordini.id_piatto = menu.id WHERE id_tavolo = ?";
		Conto ct=new Conto();
		double sum = 0 ;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, idtavolo);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {	
				sum = sum + ct.setPrezzo(rs.getDouble("SUM(prezzo)"));
				System.out.println(sum);
			}
			
		} catch (SQLException e) {
			System.out.println("SONO NELL ECCEZIONEE");		
		}
		return sum;
	}
	    
		
//		PreparedStatement ps;
//
//		try {			
//			ps = conn.prepareStatement(query);
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				// Read values using column name
//				Conto ct=new Conto();
//				ct.setidtavolo(rs.getInt("idtavolo"));
//				conto.add(ct);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}	
//
//		return conto;
//	}
		
	
//	public boolean accesso (Utente u) {
//
//		String query = "SELECT * FROM utenti WHERE user=? and password=?";
//		PreparedStatement ps;
//		int i=0;
//
//		try {			
//			ps = conn.prepareStatement(query);
//			ps.setString(1, u.getUser());
//			ps.setString(2, u.getPassword());			
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {				
//				i++;			
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		if (i==0) {
//			return false;
//		} else return true;
//	}

	
	

	public void eliminaMenu(String piatto) {

		//ArrayList<Utente> trovati=new ArrayList<Utente> ();
		String sql = "DELETE FROM menu WHERE nome=?";
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, piatto);
			ps.executeUpdate();				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


}

