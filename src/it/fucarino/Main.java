package it.fucarino;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

public class Main {
	public static void main(String[] args) {

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
			
			System.out.println("\nLista dei servizi:\n [1] Lista Eventi\n [2] Ricerca per data e ora\n [3] Aggiungi Evento\n [4] Prenota Evento\n [5] Disdici Prenotazioni\n [6] Svuota Lista\n [0] Esci dal Programma  ");
			i = scan.nextInt();
			
			switch (i) {
			case 1:
				if (listaEventi.eventiTotali() == true) {
					listaEventi.ordinaDate();
					System.out.println(" Vuole prenotare dei biglietti?\n [1] SI\n [2] NO");
					int prenota = scan.nextInt();		
					
					switch (prenota) {
					case 1:
						System.out.println(" Quale evento vuole prenotare? (Inserisci il numero Evento.)");
						listaEventi.stampaTitoliEventi();
						int numeroEvento = scan.nextInt();
						if (listaEventi.selezionaEvento(numeroEvento) == true) {
							System.out.println(" Quanti posti vuole prenotare?");
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
		        System.out.println(" Inserisci il giorno dell'evento...");
		        int giorno = scan.nextInt();
		        System.out.println(" Inserisci il mese dell'evento...");
		        int mese = scan.nextInt();
		        System.out.println(" Inserisci l'anno dell'evento...");
		        int anno = scan.nextInt();
		        System.out.println(" Inserisci l'ora dell'evento (Solo le ore, non i minuti)..");
		        int ore = scan.nextInt();
		        System.out.println(" Inserisci i minuti dell'evento...");
		        int minuti = scan.nextInt();
		        LocalDateTime dataInserita = LocalDateTime.of(anno, mese, giorno, ore, minuti);
		        listaEventi.ricercaEventData(dataInserita);
				break;
				
			case 3:
				System.out.println(" Inserisci il Titolo dell'evento...");
				scan.nextLine();
				String titoloInput = scan.nextLine();
		        System.out.println(" Inserisci il giorno dell'evento...");
		        int giornoInput = scan.nextInt();
		        System.out.println(" Inserisci il mese dell'evento...");
		        int meseInput = scan.nextInt();
		        System.out.println(" Inserisci l'anno dell'evento...");
		        int annoInput = scan.nextInt();
		        System.out.println(" Inserisci l'ora dell'evento (Solo le ore, non i minuti)..");
		        int oreInput = scan.nextInt();
		        System.out.println(" Inserisci i minuti dell'evento...");
		        int minutiInput = scan.nextInt();
		        LocalDateTime dataInseritaInput = LocalDateTime.of(annoInput, meseInput, giornoInput, oreInput, minutiInput);
		        listaEventi.controlloData(dataInseritaInput);
		        if (listaEventi.controlloData(dataInseritaInput) == true) {
					System.err.println("La data inserita è già passata.");
					break;
				}
		        System.out.println(" Quanti posti sono disponibili per l'evento? (Solo numero)");
		        int postiDisponibiliInput = scan.nextInt();
		        if (postiDisponibiliInput < 1) {
		        	System.err.println("Inserisci un numero positivo.");
					break;
				}
		        System.out.println(" Quanto costerà il prezzo unitario del biglietto?");
		        double prezzoInput = scan.nextDouble();
		        if (prezzoInput < 1) {
		        	System.err.println("Inserisci un numero positivo.");
					break;
				}
				Evento eventoInput = new Concerto(prezzoInput, titoloInput, dataInseritaInput, postiDisponibiliInput);
				listaEventi.addEvento(eventoInput);
				System.out.println(" EVENTO AGGIUNTO CON SUCCESSO!");
				break;
				
			case 4:
				if (listaEventi.eventiTotali() == true) {
					
					System.out.println(" Quale evento vuole prenotare? (Inserisci il numero Evento.)");
					listaEventi.stampaTitoliEventi();
					int numeroEvento = scan.nextInt();
					boolean sceltaEvento = listaEventi.selezionaEvento(numeroEvento);
					if (sceltaEvento == true) {
						System.out.println(" Quanti posti vuole prenotare?");
						int postiDaPrenotare = scan.nextInt();
						listaEventi.prenotaEventoSelezionato(postiDaPrenotare, numeroEvento);
						break;
					}
				}
				break;
				
			case 5:
				if (listaEventi.eventiTotali() == true) {
					
					System.out.println(" Quale evento vuole disdire? (Inserisci il numero Evento.)");
					listaEventi.stampaTitoliEventi();
					int numeroEventoDaDisdire = scan.nextInt();
					boolean sceltaEventoDaDisdire = listaEventi.selezionaEvento(numeroEventoDaDisdire);
					if (sceltaEventoDaDisdire == true) {
						System.out.println(" Quanti posti vuole disdire?");
						int postiDaDisdire = scan.nextInt();
						listaEventi.disdiciEventoSelezionato(postiDaDisdire, numeroEventoDaDisdire);;
						break;
					}
				}
				break;
			case 6:
				listaEventi.svuotaLista();
				System.out.println("Lista svuotata con successo!");
				break;
				
			case 0:
				fermaProgramma = true;
				System.out.println("Arrivederci!");
				break;
			}
		}
		
	}
}

