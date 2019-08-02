package model;

import java.util.ArrayList;

public class Tavolo {
	
	private int id;
	private int coperti,numeroTavolo;
	private ArrayList<Piatto> piattiScelti;
	private double conto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCoperti() {
		return coperti;
	}
	public void setCoperti(int coperti) {
		this.coperti = coperti;
	}
	public int getNumeroTavolo() {
		return numeroTavolo;
	}
	public void setNumeroTavolo(int numeroTavolo) {
		this.numeroTavolo = numeroTavolo;
	}
	public ArrayList<Piatto> getPiattiScelti() {
		return piattiScelti;
	}
	public void setPiattiScelti(ArrayList<Piatto> piattiScelti) {
		this.piattiScelti = piattiScelti;
	}
	public double getConto() {
		return conto;
	}
	public void setConto(double conto) {
		this.conto = conto;
	}
	public Tavolo() {
		super();
	}
	public Tavolo(int id, int coperti, int numeroTavolo, ArrayList<Piatto> piattiScelti, double conto) {
		super();
		this.id = id;
		this.coperti = coperti;
		this.numeroTavolo = numeroTavolo;
		this.piattiScelti = piattiScelti;
		this.conto = conto;
	}
	@Override
	public String toString() {
		return "Tavolo [id=" + id + ", coperti=" + coperti + ", numeroTavolo=" + numeroTavolo + ", piattiScelti="
				+ piattiScelti + ", conto=" + conto + "]";
	}
	
	
	

}
