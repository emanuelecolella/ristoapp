package model;

public class Piatto {
	private String nome;
	private double prezzo;
	private int id;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public Piatto() {
	}
	public Piatto(String nome, double prezzo) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
	}
	@Override
	public String toString() {
		return nome + " " + "(" + prezzo + "&euro;" + ")";
	}
	
	

}
