package it.fucarino;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi extends Evento{
	
	private String titoloProgramma;
	private String titolo;
	private List<Evento> listaEventi = new ArrayList<>();
	private List<String> titoliEvento = new ArrayList<>();
	
	
	public void addEvento( Evento EventoDaAggiungere) {
		titoliEvento.add(titolo);
		listaEventi.add(EventoDaAggiungere);
	}
	
	
	public void stampaTitoliEventi() {
		for (int i = 0; i < titoliEvento.size(); i++) {
			System.out.println(" Evento " + i + ": " + listaEventi.get(i).getDataEventoToString() + " - " + listaEventi.get(i).getTitolo());
		}
	}
	

	public void ricercaEventData(String dataInserita) {
		
		for (int i = 0; i < listaEventi.size(); i++) {
			if ( listaEventi.get(i).getDataEvento().equals(dataInserita)) {
				System.out.println(" Evento [" + i + "] " + listaEventi.get(i).getDataEventoToString());
			}
		}
	}
	
	
	public void eventiTotali() {
		System.out.println(" Eventi totali: " + listaEventi.size());
	}
	
	
	public void svuotaLista() {
		listaEventi.clear();
		titoliEvento.clear();
	}
	
	
	@Override
	public String toString() {

		return " Lista degli Eventi: " + listaEventi;
	}




}
