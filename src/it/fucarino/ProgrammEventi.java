package it.fucarino;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi extends Evento{
	
	private String titolo;
	private List<Evento> listaEventi = new ArrayList<>();
	private List<String> titoliEvento = new ArrayList<>();
	
	public void addEvento(String titolo, Evento EventoDaAggiungere) {
		this.titolo = titolo;
		titoliEvento.add(titolo);
		listaEventi.add(EventoDaAggiungere);
	}
	
	
	public void stampaTitoliEventi() {
		for (int i = 0; i < titoliEvento.size(); i++) {
			System.out.println("Evento [" + i + "] " + titoliEvento.get(i));
		}
	}
	
	
	
	public void stampaTuttiEventi() {
		for (int i = 0; i < listaEventi.size(); i++) {
			System.out.println("Evento [" + i + "] " + listaEventi.get(i));
		}
	}
	

	public void ricercaEventData(LocalDateTime data) {
		
		if (getDataEvento().isEqual(data)) {
			
		} else {

		}
	}
	
	
	
	@Override
	public String toString() {

		return "Lista degli Eventi: " + listaEventi;
	}
}
