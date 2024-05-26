package it.fucarino;



import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammEventi extends Concerto{
	
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";

	public ProgrammEventi() {
		
	}
	
	public ProgrammEventi( double prezzo, String titolo, LocalDateTime dataEvento, int postiDisponibili) {
		super(prezzo, titolo, dataEvento, postiDisponibili);
		
	}



	private String titoloProgramma;
	private List<Evento> listaEventi = new ArrayList<>();
	private List<Evento> listaOrdinata = new ArrayList<>();
	
	
	
	public void getTitoloProgramma() {
		System.out.println(ANSI_CYAN + "\r\n"
				+ " .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------. \r\n"
				+ "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\r\n"
				+ "| |  _________   | || |     _____    | || |     ______   | || |  ___  ____   | || |  _________   | || |  _________   | || |   ______     | || |     ____     | || |     ____     | || |   _____      | |\r\n"
				+ "| | |  _   _  |  | || |    |_   _|   | || |   .' ___  |  | || | |_  ||_  _|  | || | |_   ___  |  | || | |  _   _  |  | || |  |_   _ \\    | || |   .'    `.   | || |   .'    `.   | || |  |_   _|     | |\r\n"
				+ "| | |_/ | | \\_|  | || |      | |     | || |  / .'   \\_|  | || |   | |_/ /    | || |   | |_  \\_|  | || | |_/ | | \\_|  | || |    | |_) |   | || |  /  .--.  \\  | || |  /  .--.  \\  | || |    | |       | |\r\n"
				+ "| |     | |      | || |      | |     | || |  | |         | || |   |  __'.    | || |   |  _|  _   | || |     | |      | || |    |  __'.   | || |  | |    | |  | || |  | |    | |  | || |    | |   _   | |\r\n"
				+ "| |    _| |_     | || |     _| |_    | || |  \\ `.___.'\\  | || |  _| |  \\ \\_  | || |  _| |___/ |  | || |    _| |_     | || |   _| |__) |  | || |  \\  `--'  /  | || |  \\  `--'  /  | || |   _| |__/ |  | |\r\n"
				+ "| |   |_____|    | || |    |_____|   | || |   `._____.'  | || | |____||____| | || | |_________|  | || |   |_____|    | || |  |_______/   | || |   `.____.'   | || |   `.____.'   | || |  |________|  | |\r\n"
				+ "| |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |\r\n"
				+ "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\r\n"
				+ " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \r\n"
				+ "" + ANSI_RESET);
	}
	
	
	
	
	public void addEvento( Evento EventoDaAggiungere) {
		listaEventi.add(EventoDaAggiungere);
	}
	
	public void ordinaDate() {

		Collections.sort(listaEventi, new Comparator<Evento>() {

			@Override
			public int compare(Evento evento1, Evento evento2) {
				return evento1.getDataEvento().compareTo(evento2.getDataEvento());
			}
		});
		
        for (Evento evento : listaEventi) {
            System.out.println(evento.toString());
        }
	}
	
	public void stampaEventi() {
		for (int i = 0; i < listaEventi.size(); i++) {
			System.out.println(" Evento " + i + ": " + listaEventi.get(i));
		}
	}
	
	public void stampaTitoliEventi() {
		for (int i = 0; i < listaEventi.size(); i++) {
			System.out.println(ANSI_YELLOW + " Evento " + i + ": " + ANSI_GREEN + listaEventi.get(i).getDataEventoToString() + " - " + ANSI_CYAN + listaEventi.get(i).getTitolo() + ANSI_RESET);
		}
	}
	

	public void ricercaEventData(LocalDateTime dataInserita) {
		
		boolean eventoTrovato = false;
		
		for (int j = 0; j < listaEventi.size(); j++) {
			if ( listaEventi.get(j).getDataEvento().isEqual(dataInserita)) {
				System.out.println(ANSI_GREEN +" EVENTI TROVATI:" + ANSI_RESET);
				System.out.println(ANSI_YELLOW +" Evento " + j + ": " + ANSI_GREEN + listaEventi.get(j).getDataEventoToString() + ANSI_RESET + " - " + ANSI_CYAN + listaEventi.get(j).getTitolo() + ANSI_RESET);
				eventoTrovato = true;
			}
		}
		if (!eventoTrovato) {
			System.out.println(ANSI_RED + "Non è stato trovato nessun Evento con questa data e ora." + ANSI_RESET);
		}
	}
	
	
	public boolean eventiTotali() {
		if (listaEventi.size() > 0) {
			System.out.println( ANSI_GREEN + " Eventi totali: " + ANSI_YELLOW + listaEventi.size() + ANSI_RESET);
			return true;
		}else {
			System.out.println(ANSI_RED +  " Non ci sono eventi." + ANSI_RESET);
			return false;
		}
	}
	
	
	public void svuotaLista() {
		listaEventi.clear();
	}
	

	public boolean selezionaEvento(int indexEvento) {
		for (int i = 0; i < listaEventi.size();) {
			if (indexEvento >= 0 && indexEvento < listaEventi.size()) {
				System.out.println(ANSI_YELLOW + " Evento scelto: " + listaEventi.get(indexEvento));
				return true;
			}else {
				System.out.println(ANSI_RED +" Evento non valido" + ANSI_RESET);
				return false;
			}
		}
		return false;
	}
	
	
	@Override
	public double getPrezzo() {
		return super.prezzo;
	}
	
	public void prenotaEventoSelezionato(int posti, int indexEvento) {
		
		if (posti >= 1) {
			Evento eventoSelezionato = listaEventi.get(indexEvento);
			if (eventoSelezionato.getDataEvento().isBefore(getData())) {
				System.out.println(ANSI_RED + " La data è già passata." + ANSI_RESET);
			}else if (eventoSelezionato.prenota(posti) == true) {
				double prezzoEvento = ((Concerto) eventoSelezionato).getPrezzo();
				double prezzoTotale = prezzoEvento * posti;
				System.out.println(ANSI_CYAN + " Prezzo totale per " + ANSI_YELLOW + posti + ANSI_CYAN + " posti: "+ ANSI_GREEN +(String.format("%.2f", prezzoTotale)) + "€");
			}
		}else {
			System.err.println(ANSI_RED + " Inserisci un numero positivo." + ANSI_RESET);
		}
	}
	
	public void disdiciEventoSelezionato(int postiDisdetti , int indexEvento) {
		int postiPrenotati = listaEventi.get(indexEvento).getPostiPrenotati();
		if (postiPrenotati >= 1) {
			Evento eventoSelezionato = listaEventi.get(indexEvento);
			if (eventoSelezionato.getDataEvento().isBefore(getData())) {
				System.out.println(" La data è già passata.");
			}else if (postiDisdetti <= eventoSelezionato.getPostiPrenotati()) {
				eventoSelezionato.disdici(postiDisdetti);
				double prezzoEvento = ((Concerto) eventoSelezionato).getPrezzo();
				double prezzoTotale = prezzoEvento * eventoSelezionato.getPostiPrenotati();
				System.out.println(" Nuovo totale per " + (postiPrenotati - postiDisdetti) + " posti: " +(String.format("%.2f", prezzoTotale)) + "€");
			}else {
				System.out.println((ANSI_RED + " Stai cercando di disdire più posti di quanti ne hai prenotati." + ANSI_RESET));
			}
		}else {
			System.err.println((ANSI_RED + " Non ci sono prenotazioni registrate a suo nome." + ANSI_RESET));
		}
	}
	
	
	
	@Override
	public String toString() {

		return " Lista degli Eventi: " + listaEventi;
	}




}
