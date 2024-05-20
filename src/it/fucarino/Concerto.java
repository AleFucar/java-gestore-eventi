package it.fucarino;

import java.time.LocalDateTime;

public class Concerto extends Evento {
	
	double prezzo;
	
	
	public Concerto(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public Concerto( double prezzo, String titolo, LocalDateTime data, LocalDateTime dataEvento, int postiPrenotati) {
		super(titolo, data, dataEvento, postiPrenotati);
		this.prezzo = prezzo;
		
	}
		
	public String getPrezzo() {
		return prezzo + "€";
	}
	
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + " - " + getPrezzo();
	}
}
