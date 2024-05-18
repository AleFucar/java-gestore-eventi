package it.fucarino;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Evento {

	private String titolo;
	private LocalDateTime data; //data odierna
	private LocalDateTime dataEvento;
	private int numPostiTot = 5;
	private int postiPrenotati = 0;



	public Evento() {
	this.data = LocalDateTime.now();
	}
	
	

	
	
	public void controlloData(LocalDateTime dataInput) {
		
		if (dataInput.isBefore(data)) {
			System.out.println("\nLa data inserità è già passata.");
		}
	}
	
	
	public void prenota(int postiPrenotati, LocalDateTime dataInput) {
		
		this.postiPrenotati = postiPrenotati;
		
		if (dataInput.isBefore(data)) {
			System.out.println("La data inserità è già passata.\n");
			
		} else if (postiPrenotati > numPostiTot || numPostiTot == 0) {
			System.out.println("Non ci sono abbastanza posti disponibili, ci dispiace!");
		 }else {
			numPostiTot -= postiPrenotati ;
			System.out.println("Prenotazione avvenuta con successo.");
			System.out.println("Posti prenotati: " + postiPrenotati + "\n" + "Posti rimanenti: " + numPostiTot);
		}
	}
	
	
	
	public void disdici(int postiPrenotati, int postiDisdetti) {
		
		this.postiPrenotati = postiPrenotati;
		
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
	
	////////////////////////////
	/////Getter and setter/////
	//////////////////////////
	public String getDataEvento() {
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
		
		return  getDataEvento() + " - " + titolo;
	}


	
}

