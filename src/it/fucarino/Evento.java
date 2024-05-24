package it.fucarino;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Locale;

public class Evento {

	private String titolo;
	private LocalDateTime data = LocalDateTime.now(); //data odierna
	private LocalDateTime dataEvento;
	private int numPostiTot = 5;
	private int postiPrenotati = 0;
	
	
	public Evento() {
		
	}
	
	
	public Evento(String titolo, LocalDateTime dataEvento, int numPostiTot) {
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.numPostiTot = numPostiTot;
		
	}
	
	////////////////////////////
	/////Getter and setter/////
	//////////////////////////
	
	public LocalDateTime getData() {
		return data;
	}
	
	
	
	public LocalDateTime getDataEvento() {
		return dataEvento;
	}

	public String getDataEventoToString() {
		return dataEvento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale.ITALY));
	}
	
	public void setDataEvento(LocalDateTime dataEvento) {
		this.dataEvento = dataEvento;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public int getNumPostiTot() {
		return numPostiTot;
	}
	
	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	@Override
	public String toString() {
		
		return  getDataEventoToString() + " - " + titolo;
	}
	


	
	
	public boolean prenota(int postiPrenotati) {
		
		if (data.isAfter(getDataEvento())) {
			System.out.println("La data di questo evento è passata.");
			return true;
		} else {
			this.postiPrenotati = postiPrenotati;
			numPostiTot -= postiPrenotati;
			System.out.println( "Prenotazione effettuata con successo!" + "\nPosti prenotati: " + getPostiPrenotati() + "\n" + "Posti rimanenti: " + getNumPostiTot());
			return false;
		}
	}
	
	
	public void disdici(int postiPrenotati, int postiDisdetti) {
		
		this.postiPrenotati = postiPrenotati;
		
		
		if (prenota(postiPrenotati) == true) {
			System.out.println("Non puoi prenotare una data già avvenuta.");
		} else {
			if (postiPrenotati == 0) {
				System.out.println("Non ci sono prenotazioni registrate a suo nome.");
			}else if (postiPrenotati < postiDisdetti) {
				System.out.println("Stai cercando di disdire più posti di quanti ne hai prenotati. \nI tuoi posti: " + postiPrenotati);
			}else {
				postiPrenotati -= postiDisdetti;
				System.out.println("Hai disdetto " + postiDisdetti + " posti.");
				System.out.println("Ti rimangono " + postiPrenotati + " posti prenotati.");
				
			}
		}
	}
}

