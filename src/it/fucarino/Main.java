package it.fucarino;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_CYAN = "\u001B[36m";
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_YELLOW = "\u001B[33m";
		
		Scanner scan = new Scanner(System.in);
		
		
		ProgrammEventi listaEventi = new ProgrammEventi();
		
		Evento concerto = new Concerto(20.50, "Angelina Mango", LocalDateTime.of(2025, 6, 12, 22, 30), 1050);
		listaEventi.addEvento( concerto);
		Evento concerto1 = new Concerto(50.00, "Marracash", LocalDateTime.of(2026, 3, 18, 21, 00), 3000);
		listaEventi.addEvento(concerto1);
		Evento concerto2 = new Concerto(35.60, "Annalisa", LocalDateTime.of(2029, 02, 5, 18, 30), 2000);
		listaEventi.addEvento(concerto2);
		Evento concerto3 = new Concerto(70.00, "Jova-Beach-Party", LocalDateTime.of(2024, 8, 16, 15, 00), 9000);
		listaEventi.addEvento(concerto3);
		Evento concerto4 = new Concerto(40.00, "Irama", LocalDateTime.of(2023, 6, 12, 22, 30), 1050);
		listaEventi.addEvento(concerto4);
		Evento concerto5 = new Concerto(16.30, "Mahmood", LocalDateTime.of(2022, 3, 18, 21, 00), 3000);
		listaEventi.addEvento(concerto5);
		Evento concerto6 = new Concerto(25.00, "Calcutta", LocalDateTime.of(2021, 02, 5, 18, 30), 2000);
		listaEventi.addEvento(concerto6);
		Evento concerto7 = new Concerto(27.50, "Alfa", LocalDateTime.of(2020, 8, 16, 15, 00), 9000);
		listaEventi.addEvento(concerto7);
		

		boolean fermaProgramma = false;
		
		for (int i = 0; fermaProgramma == false ;) {
			
			listaEventi.getTitoloProgramma();
			
			System.out.println(ANSI_GREEN + "\nLista dei servizi:\n" + ANSI_RESET + ANSI_CYAN + " [1] Lista Eventi\n [2] Ricerca per data e ora\n [3] Aggiungi Evento\n [4] Prenota Evento\n [5] Disdici Prenotazioni\n [6] Svuota Lista\n [0] Esci dal Programma  " + ANSI_RESET);
			i = scan.nextInt();
			
			switch (i) {
			case 1:
				if (listaEventi.eventiTotali() == true) {
					listaEventi.ordinaDate();
					System.out.println(ANSI_GREEN + " Vuole prenotare dei biglietti?\n" + ANSI_CYAN + " [1] SI\n [2] NO" + ANSI_RESET);
					int prenota = scan.nextInt();		
					
					switch (prenota) {
					case 1:
						System.out.println(ANSI_GREEN + " Quale evento vuole prenotare? (Inserisci il numero Evento.)" + ANSI_RESET);
						listaEventi.stampaTitoliEventi();
						int numeroEvento = scan.nextInt();
						if (listaEventi.selezionaEvento(numeroEvento) == true) {
							System.out.println(ANSI_GREEN + " Quanti posti vuole prenotare?" + ANSI_RESET);
							int postiDaPrenotare = scan.nextInt();
							listaEventi.prenotaEventoSelezionato(postiDaPrenotare, numeroEvento);
							break;
						}
					case 2:
						break;
						
					}
				}
				
				break;

			case 2:
		        System.out.println(ANSI_GREEN + " Inserisci il giorno dell'evento...([0] per uscire dalla ricerca)" + ANSI_RESET);
		        int giorno = scan.nextInt();
		        if (giorno  == 0) {
		        	System.out.println(ANSI_GREEN + "ANNULLATO" + ANSI_RESET);
					break;
				}
		        System.out.println(ANSI_GREEN + " Inserisci il mese dell'evento...([0] per uscire dalla ricerca)" + ANSI_RESET);
		        int mese = scan.nextInt();
		        if (mese == 0) {
		        	System.out.println(ANSI_GREEN + "ANNULLATO" + ANSI_RESET);
					break;
				}
		        System.out.println(ANSI_GREEN + " Inserisci l'anno dell'evento...([0] per uscire dalla ricerca)" + ANSI_RESET);
		        int anno = scan.nextInt();
		        if (anno == 0) {
		        	System.out.println(ANSI_GREEN + "ANNULLATO" + ANSI_RESET);
					break;
				}
		        System.out.println(ANSI_GREEN + " Inserisci l'ora dell'evento (Solo le ore, non i minuti)...([0] per uscire dalla ricerca)" + ANSI_RESET);
		        int ore = scan.nextInt();
		        if (ore == 0) {
		        	System.out.println(ANSI_GREEN + "ANNULLATO" + ANSI_RESET);
					break;
				}
		        System.out.println(ANSI_GREEN + " Inserisci i minuti dell'evento..." + ANSI_RESET);
		        int minuti = scan.nextInt();
		        LocalDateTime dataInserita = LocalDateTime.of(anno, mese, giorno, ore, minuti);
		        listaEventi.ricercaEventData(dataInserita);
				break;
				
			case 3:
				System.out.println(ANSI_GREEN + " Inserisci il Titolo dell'evento...([0] per annullare)" + ANSI_RESET);
				scan.nextLine();
				String titoloInput = scan.nextLine();
				if (titoloInput.equals("0")) {
		        	System.out.println(ANSI_GREEN + "ANNULLATO" + ANSI_RESET);
					break;
				}
		        System.out.println(ANSI_GREEN + " Inserisci il giorno dell'evento...([0] per annullare)" + ANSI_RESET);
		        int giornoInput = scan.nextInt();
		        if (giornoInput == 0) {
		        	System.out.println(ANSI_GREEN + "ANNULLATO" + ANSI_RESET);
					break;
				}
		        System.out.println(ANSI_GREEN + " Inserisci il mese dell'evento...([0] per annullare)" + ANSI_RESET);
		        int meseInput = scan.nextInt();
		        if (meseInput == 0) {
		        	System.out.println(ANSI_GREEN + "ANNULLATO" + ANSI_RESET);
					break;
				}
		        System.out.println(ANSI_GREEN + " Inserisci l'anno dell'evento...([0] per annullare)" + ANSI_RESET);
		        int annoInput = scan.nextInt();
		        if (annoInput == 0) {
		        	System.out.println(ANSI_GREEN + "ANNULLATO" + ANSI_RESET);
					break;
				}
		        System.out.println(ANSI_GREEN + " Inserisci l'ora dell'evento (Solo le ore, non i minuti)..." + ANSI_RESET);
		        int oreInput = scan.nextInt();
		        System.out.println(ANSI_GREEN + " Inserisci i minuti dell'evento..." + ANSI_RESET);
		        int minutiInput = scan.nextInt();
		        LocalDateTime dataInseritaInput = LocalDateTime.of(annoInput, meseInput, giornoInput, oreInput, minutiInput);
		        listaEventi.controlloData(dataInseritaInput);
		        if (listaEventi.controlloData(dataInseritaInput) == true) {
					System.err.println(ANSI_RED + "La data inserita è già passata." + ANSI_RESET);
					break;
				}
		        System.out.println(ANSI_GREEN + " Quanti posti sono disponibili per l'evento? (Solo numero)" + ANSI_RESET);
		        int postiDisponibiliInput = scan.nextInt();
		        if (postiDisponibiliInput < 1) {
		        	System.out.println(ANSI_RED + "Inserisci un numero positivo." + ANSI_RESET);
					break;
				}
		        System.out.println(ANSI_GREEN + " Quanto costerà il prezzo unitario del biglietto?" + ANSI_RESET);
		        double prezzoInput = scan.nextDouble();
		        if (prezzoInput < 1) {
		        	System.out.println(ANSI_RED + "Inserisci un numero positivo." + ANSI_RESET);
					break;
				}
				Evento eventoInput = new Concerto(prezzoInput, titoloInput, dataInseritaInput, postiDisponibiliInput);
				listaEventi.addEvento(eventoInput);
				System.out.println(ANSI_GREEN +" EVENTO AGGIUNTO CON SUCCESSO!" + ANSI_RESET);
				break;
				
			case 4:
				if (listaEventi.eventiTotali() == true) {
					
					System.out.println(ANSI_GREEN + " Quale evento vuole prenotare? (Inserisci il numero Evento.)" + ANSI_RESET);
					listaEventi.stampaTitoliEventi();
					int numeroEvento = scan.nextInt();
					boolean sceltaEvento = listaEventi.selezionaEvento(numeroEvento);
					if (sceltaEvento == true) {
						System.out.println(ANSI_GREEN + " Quanti posti vuole prenotare?([0] per uscire)" + ANSI_RESET);
						int postiDaPrenotare = scan.nextInt();
						if (postiDaPrenotare == 0) {
				        	System.out.println(ANSI_GREEN + "ANNULLATO" + ANSI_RESET);
				        	break;
						}
						listaEventi.prenotaEventoSelezionato(postiDaPrenotare, numeroEvento);
						break;
					}
				}
				break;
				
			case 5:
				if (listaEventi.eventiTotali() == true) {
					
					System.out.println(ANSI_GREEN + " Quale evento vuole disdire? (Inserisci il numero Evento.)" + ANSI_RESET);
					listaEventi.stampaTitoliEventi();
					int numeroEventoDaDisdire = scan.nextInt();
					boolean sceltaEventoDaDisdire = listaEventi.selezionaEvento(numeroEventoDaDisdire);
					if (sceltaEventoDaDisdire == true) {
						System.out.println(ANSI_GREEN + " Quanti posti vuole disdire?([0] per annullare)" + ANSI_RESET);
						int postiDaDisdire = scan.nextInt();
				        if (postiDaDisdire == 0) {
				        	System.out.println(ANSI_GREEN + "ANNULLATO" + ANSI_RESET);
							break;
						}
						listaEventi.disdiciEventoSelezionato(postiDaDisdire, numeroEventoDaDisdire);;
						break;
					}
				}
				break;
			case 6:
				listaEventi.svuotaLista();
				System.out.println(ANSI_GREEN + "Lista svuotata con successo!" + ANSI_RESET);
				break;
				
			case 0:
				fermaProgramma = true;
				System.out.println(ANSI_YELLOW + "Arrivederci!" + ANSI_RESET);
				break;
			}
		}
		
	}
}

