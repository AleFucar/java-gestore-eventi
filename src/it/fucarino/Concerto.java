
package it.fucarino;

import java.time.LocalDateTime;

public class Concerto extends Evento {
	
	double prezzo;
	
	
	public Concerto(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public Concerto( double prezzo, String titolo, LocalDateTime dataEvento, int postiDisponibili) {
		super(titolo, dataEvento, postiDisponibili);
		super.getDataEvento();
		this.prezzo = prezzo;
		
	}
	
	public String getTitoloString() {
		return super.getTitolo();
	}

	public String getPrezzo() {
		return prezzo + "€";
	}
	
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + " - " + "Posti disponibili: " + getNumPostiTot() + " - " + " Prezzo del biglietto unitario: " + getPrezzo() ;
	}
}
