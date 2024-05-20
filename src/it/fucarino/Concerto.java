package it.fucarino;

import java.time.LocalTime;

public class Concerto extends Evento {

	
	LocalTime ora;


	double prezzo;
	
	
	public Concerto(LocalTime ora, double prezzo) {
		this.ora = ora;
		this.prezzo = prezzo;
	}
	
	public LocalTime getOra() {
		return ora;
	}
	
	
	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	
	
	public double getPrezzo() {
		return prezzo;
	}
	
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
}
