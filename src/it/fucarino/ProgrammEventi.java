package it.fucarino;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi extends Evento{
	
	private String titoloProgramma;
	private List<Evento> listaEventi = new ArrayList<>();
	
	public void addEvento( Evento EventoDaAggiungere) {
		listaEventi.add(EventoDaAggiungere);
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
		
		for (int i = 0; i < listaEventi.size(); i++) {
			if ( listaEventi.get(i).getDataEvento().isEqual(dataInserita)) {
				System.out.println(" EVENTI TROVATI:");
				System.out.println(" Evento " + i + ": " + listaEventi.get(i).getDataEventoToString() + " - " + listaEventi.get(i).getTitolo());
				eventoTrovato = true;
			}
		}
		if (!eventoTrovato) {
			System.err.println("Non è stato trovato nessun Evento con questa data e ora.");
		}
	}
	
	
	public void eventiTotali() {
		System.out.println(" Eventi totali: " + listaEventi.size());
	}
	
	
	public void svuotaLista() {
		listaEventi.clear();
	}
	

	public boolean prenotaEventoSelezionato(int indexEvento) {
		for (int i = 0; i < listaEventi.size(); i++) {
			if (indexEvento >= 0 && indexEvento < listaEventi.size()) {
				System.out.println(" Evento: " + listaEventi.get(indexEvento));
				return true;
			}else {
				System.err.println("Evento non valido");
			}
		}
		return false;	
	}
	
	@Override
	public String toString() {

		return " Lista degli Eventi: " + listaEventi;
	}




}
