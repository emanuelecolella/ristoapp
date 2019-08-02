package model;

public class Conto {
	double prezzo;

	public double getPrezzo() {
		return prezzo;
	}

	public double setPrezzo(double prezzo) {
		return this.prezzo = prezzo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(prezzo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Conto other = (Conto) obj;
		if (Double.doubleToLongBits(prezzo) != Double.doubleToLongBits(other.prezzo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conto [prezzo=" + prezzo + "]";
	}

	public Conto(double prezzo) {
		super();
		this.prezzo = prezzo;
	}

	public Conto() {
		super();
	}
	
}
