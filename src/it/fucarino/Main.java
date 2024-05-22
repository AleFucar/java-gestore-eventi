package it.fucarino;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		
		ProgrammEventi listaEventi = new ProgrammEventi();
		
		Evento concerto = new Concerto(20.50, "Angelina Mango", LocalDateTime.of(2025, 6, 12, 22, 30), 1050);
		listaEventi.addEvento("Angelina Mango", concerto);
		Evento concerto1 = new Concerto(50.00, "Marracash", LocalDateTime.of(2026, 3, 18, 21, 00), 3000);
		listaEventi.addEvento("Marracash" , concerto1);
		Evento concerto2 = new Concerto(35.60, "Annalisa", LocalDateTime.of(2029, 02, 5, 18, 30), 2000);
		listaEventi.addEvento("Annalisa", concerto2);
		Evento concerto3 = new Concerto(70.00, "Jova-Beach-Party", LocalDateTime.of(2024, 8, 16, 15, 00), 9000);
		listaEventi.addEvento("Jova-Beach-Party", concerto3);
		Evento concerto4 = new Concerto(40.00, "Irama", LocalDateTime.of(2023, 6, 12, 22, 30), 1050);
		listaEventi.addEvento("Irama", concerto4);
		Evento concerto5 = new Concerto(16.30, "Mahmood", LocalDateTime.of(2022, 3, 18, 21, 00), 3000);
		listaEventi.addEvento("Mahmood", concerto5);
		Evento concerto6 = new Concerto(25.00, "Calcutta", LocalDateTime.of(2021, 02, 5, 18, 30), 2000);
		listaEventi.addEvento("Calcutta", concerto6);
		Evento concerto7 = new Concerto(27.50, "Alfa", LocalDateTime.of(2020, 8, 16, 15, 00), 9000);
		listaEventi.addEvento("Alfa", concerto7);
		
		
		for (int i = 0;; i++) {
			
			System.out.println("Benvenuto, vuole vedere la nostra lista eventi?");
			String inizio = scan.nextLine();
			
			if (inizio.equals("Si") || inizio.equals("SI") || inizio.equals("si")) {
				
				listaEventi.stampaTitoliEventi();
				
			} else {

			}
			
		}
		
		
		
		}
	}

