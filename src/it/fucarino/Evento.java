package it.fucarino;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Locale;

public class Evento {

	private String titolo;
	private LocalDateTime data = LocalDateTime.now(); //data odierna
	private LocalDateTime dataEvento;
	private int numPostiTot;
	private int postiPrenotati;
	
	
	public Evento() {
		
	}
	
	public Evento(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
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
	

	public boolean controlloData(LocalDateTime dataEvento) {
		if (data.isAfter(dataEvento)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean prenota(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
		
		if (postiPrenotati > numPostiTot) {
			System.out.println(" Stai cercando di prenotare più posti di quanti ne siano disponibili");
			return false;
		}else {
			this.postiPrenotati = postiPrenotati;
			numPostiTot -= postiPrenotati;
			System.out.println( "Prenotazione effettuata con successo!" + "\nPosti prenotati: " + getPostiPrenotati() + "\n" + "Posti rimanenti: " + getNumPostiTot());
			return true;			
		}
	}
	
	
	public void disdici(int postiDisdetti) {
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

