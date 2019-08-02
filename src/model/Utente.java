package model;

public class Utente {
private int id;
private String nome;
private String cognome;
private String username;
private String password;
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
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Utente(int id, String nome, String cognome, String username, String password) {
	super();
	this.id = id;
	this.nome = nome;
	this.cognome = cognome;
	this.username = username;
	this.password = password;
}
public Utente() {
	super();
}
@Override
public String toString() {
	return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", password="
			+ password + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
	result = prime * result + id;
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Utente other = (Utente) obj;
	if (cognome == null) {
		if (other.cognome != null)
			return false;
	} else if (!cognome.equals(other.cognome))
		return false;
	if (id != other.id)
		return false;
	if (nome == null) {
		if (other.nome != null)
			return false;
	} else if (!nome.equals(other.nome))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}


}