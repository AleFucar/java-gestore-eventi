package it.fucarino;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
		
		int i = 0;
		
		for (i = 0; ;) {
			
			System.out.println("\nBenvenuto, Ecco i nostri servizi:\n [1] Lista Eventi\n [2] Ricerca per data e ora\n [3] Aggiungi Evento\n [4] Svuota Lista ");
			i = scan.nextInt();
			
			switch (i) {
			case 1:
				listaEventi.stampaTitoliEventi();
				listaEventi.eventiTotali();
				break;

			case 2:
		        System.out.println("Inserisci la data e l'ora dell'evento (es. dd/MM/yyyy HH:mm): ");
		        String dataInserita = scan.nextLine();
		        scan.nextInt();
		        listaEventi.ricercaEventData(dataInserita);
				break;
				
			case 3:
				
				
				break;
			}
			
			}
		}
	}

