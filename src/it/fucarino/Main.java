package it.fucarino;


import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	
	Evento evento1 = new Evento();
	
	Scanner scan = new Scanner(System.in);
	
	

	for (int i=0 ; ; i++) {
		
		System.out.println("Ciao, inserisci il titolo dell'evento");
		String titolo = scan.nextLine();
		evento1.setTitolo(titolo);

		System.out.println("Ciao, inserisci il giorno dell'evento(Numero)");
		int giorno = scan.nextInt();
		
		System.out.println("Ciao, inserisci il mese dell'evento(Numero)");
		int mese = scan.nextInt();
		
		System.out.println("Ciao, inserisci l'anno dell'evento(Numero)");
		int anno = scan.nextInt();
		
		System.out.println("Ciao, inserisci l'ora dell'evento(Numero)");
		int ora = scan.nextInt();
		
		System.out.println("Ciao, inserisci i minuti dell'evento(Numero)");
		int minuti = scan.nextInt();
		scan.nextLine();
		
		LocalDateTime dataInput = LocalDateTime.of(anno, mese, giorno, ora, minuti);
		evento1.setDataEvento(dataInput);

		if (dataInput.isBefore(evento1.getData())) {
			System.out.println("\nLa data inserità è già passata.");
			break;
		} else {
			System.out.println(evento1.toString());
			System.out.println("\nVuole Prenotare i suoi posti?(RISPONDI CON SI O NO)\n");
			String richiestaPrenotazionePostiInput = scan.nextLine();	
			if (richiestaPrenotazionePostiInput.equals("Si") || richiestaPrenotazionePostiInput.equals("sI") || richiestaPrenotazionePostiInput.equals("SI") || richiestaPrenotazionePostiInput.equals("si")) {
				
				System.out.println("Quanti posti vuole prenotare?");
				int numeroPrenotazioni = scan.nextInt();
				scan.nextLine();
				if (numeroPrenotazioni <= evento1.getNumPostiTot()) {
					evento1.prenota(numeroPrenotazioni,  dataInput);
					System.out.println("Prenotazione avvenuta con successo.");
					System.out.println("Posti prenotati: " + numeroPrenotazioni + "\n" + "Posti rimanenti: " + evento1.getNumPostiTot());
					
				} else if (numeroPrenotazioni > evento1.getNumPostiTot() || evento1.getNumPostiTot() == 0) {
					System.out.println("Non ci sono abbastanza posti disponibili, ci dispiace!\n");
					System.out.println("Posti prenotati: " + evento1.getPostiPrenotati() + "\n" + "Posti rimanenti: " + evento1.getNumPostiTot());
					break;
				}else if(numeroPrenotazioni == 0) {
					System.out.println("inserisci un numero maggiore di zero.");
					break;
				}
				
				
				
			}else if (richiestaPrenotazionePostiInput.equals("No") || richiestaPrenotazionePostiInput.equals("nO") || richiestaPrenotazionePostiInput.equals("NO") || richiestaPrenotazionePostiInput.equals("no")) {
				System.out.println("Va bene, a presto!\n");
				break;
			}
			
			System.out.println("Vuole disdire i suoi posti? (RISPONDI CON SI O NO)");
			String richiestaDisdiciPosti = scan.nextLine();
			if (richiestaDisdiciPosti.equals("Si") || richiestaDisdiciPosti.equals("sI") || richiestaDisdiciPosti.equals("SI") || richiestaDisdiciPosti.equals("si")) {
				System.out.println("Quanti posti vuole disdire?");
				int numPostiDisdetti = scan.nextInt();
				evento1.disdici(evento1.getPostiPrenotati(), numPostiDisdetti );
				break;
			}else {
				System.out.println("Va bene, a presto!\n");
				break;
				}
			}
		}
	}
}	

