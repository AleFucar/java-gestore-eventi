package it.fucarino;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Locale;

public class Evento {

	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	
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
		
		return ANSI_GREEN + getDataEventoToString() +  ANSI_RESET + " - "+ ANSI_CYAN + titolo + ANSI_RESET;
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
			System.out.println(ANSI_RED + " Stai cercando di prenotare più posti di quanti ne siano disponibili" + ANSI_RESET);
			return false;
		}else {
			this.postiPrenotati = postiPrenotati;
			numPostiTot -= postiPrenotati;
			System.out.println(ANSI_GREEN +  " Prenotazione effettuata con successo!" + ANSI_CYAN + "\n Posti prenotati: " + ANSI_YELLOW + getPostiPrenotati() + "\n" + ANSI_CYAN + " Posti rimanenti: " + ANSI_YELLOW + getNumPostiTot() + ANSI_RESET);
			return true;			
		}
	}
	
	
	public void disdici(int postiDisdetti) {
			if (postiPrenotati == 0) {
				System.out.println(ANSI_RED + " Non ci sono prenotazioni registrate a suo nome." + ANSI_RESET);
			}else if (postiPrenotati < postiDisdetti) {
				System.out.println(ANSI_RED + " Stai cercando di disdire più posti di quanti ne hai prenotati. \nI tuoi posti: " + postiPrenotati + ANSI_RESET);
			}else {
				postiPrenotati -= postiDisdetti;
				System.out.println(ANSI_GREEN + " Hai disdetto " + ANSI_YELLOW + postiDisdetti + ANSI_GREEN + " posti." + ANSI_RESET);
				System.out.println(ANSI_GREEN + " Ti rimangono " + ANSI_YELLOW + postiPrenotati + ANSI_GREEN + " posti prenotati." + ANSI_RESET);
			}
		}
	}

