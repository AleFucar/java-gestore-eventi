package it.fucarino;



import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammEventi extends Concerto{
	

	public ProgrammEventi() {
		
	}
	
	public ProgrammEventi( double prezzo, String titolo, LocalDateTime dataEvento, int postiDisponibili) {
		super(prezzo, titolo, dataEvento, postiDisponibili);
		
	}



	private String titoloProgramma;
	private List<Evento> listaEventi = new ArrayList<>();
	private List<Evento> listaOrdinata = new ArrayList<>();
	
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
		
        System.out.println("Eventi in ordine cronologico:");
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
			System.out.println(" Evento " + i + ": " + listaEventi.get(i).getDataEventoToString() + " - " + listaEventi.get(i).getTitolo());
		}
	}
	

	public void ricercaEventData(LocalDateTime dataInserita) {
		
		boolean eventoTrovato = false;
		
		for (int j = 0; j < listaEventi.size(); j++) {
			if ( listaEventi.get(j).getDataEvento().isEqual(dataInserita)) {
				System.out.println(" EVENTI TROVATI:");
				System.out.println(" Evento " + j + ": " + listaEventi.get(j).getDataEventoToString() + " - " + listaEventi.get(j).getTitolo());
				eventoTrovato = true;
			}
		}
		if (!eventoTrovato) {
			System.err.println( "Non è stato trovato nessun Evento con questa data e ora.");
		}
	}
	
	
	public boolean eventiTotali() {
		if (listaEventi.size() > 0) {
			System.out.println(" Eventi totali: " + listaEventi.size());
			return true;
		}else {
			System.out.println(" Non ci sono eventi.");
			return false;
		}
	}
	
	
	public void svuotaLista() {
		listaEventi.clear();
	}
	

	public boolean selezionaEvento(int indexEvento) {
		for (int i = 0; i < listaEventi.size();) {
			if (indexEvento >= 0 && indexEvento < listaEventi.size()) {
				System.out.println(" Evento: " + listaEventi.get(indexEvento));
				return true;
			}else {
				System.err.println(" Evento non valido");
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
				System.out.println(" La data è già passata.");
			}else if (eventoSelezionato.prenota(posti) == true) {
				double prezzoEvento = ((Concerto) eventoSelezionato).getPrezzo();
				double prezzoTotale = prezzoEvento * posti;
				System.out.println(" Prezzo totale per " + posti + " posti: " +(String.format("%.2f", prezzoTotale)) + "€");
			}
		}else {
			System.err.println(" Inserisci un numero positivo.");
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
			}
		}else {
			System.err.println(" Inserisci un numero positivo.");
		}
	}
	
	
	
	@Override
	public String toString() {

		return " Lista degli Eventi: " + listaEventi;
	}




}
