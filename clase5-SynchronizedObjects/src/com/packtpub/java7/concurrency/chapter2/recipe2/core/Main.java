package com.packtpub.java7.concurrency.chapter2.recipe2.core;

import com.packtpub.java7.concurrency.chapter2.recipe2.task.Cinema1;

import com.packtpub.java7.concurrency.chapter2.recipe2.task.Cinema1;
import com.packtpub.java7.concurrency.chapter2.recipe2.task.Cinema4;
import com.packtpub.java7.concurrency.chapter2.recipe2.task.Cinema3;
import com.packtpub.java7.concurrency.chapter2.recipe2.task.Cinema5;
import com.packtpub.java7.concurrency.chapter2.recipe2.task.Cinema2;
import com.packtpub.java7.concurrency.chapter2.recipe2.task.CinemaInterfaz;
import com.packtpub.java7.concurrency.chapter2.recipe2.task.TicketOffice1;
import com.packtpub.java7.concurrency.chapter2.recipe2.task.TicketOffice2;

/**
 * Core class of the example. Creates a cinema and two threads for the ticket
 * office. Run the threads to analyze the results obtained
 *
 */
public class Main {

	/**
	 * Main method of the example
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		CinemaInterfaz cinemaarray[] = new CinemaInterfaz[5];
		cinemaarray[0] = new Cinema1();
		cinemaarray[1] = new Cinema4();
		cinemaarray[2] = new Cinema3();
		cinemaarray[3] = new Cinema5();
		cinemaarray[4] = new Cinema2();

		for (int j = 0; j < 5; j++) {

			for (int i = 0; i < 100000; i++) {// Starts the threads

				CinemaInterfaz cinema;
				cinema = cinemaarray[j];// cinemaarray[0]; //arreglo de cinemas
										// para generar un caso de cada uno
				cinema.inicia();
				// Creates a TicketOffice1 and a Thread to run it
				TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
				Thread thread1 = new Thread(ticketOffice1, "TicketOffice1");

				// Creates a TicketOffice2 and a Thread to run it
				TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
				Thread thread2 = new Thread(ticketOffice2, "TicketOffice2");

				thread1.start();
				thread2.start();

				try {
					thread1.join();
					thread2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				 //System.out.printf("Room 1 Vacancies: %d\n",cinema.getVacanciesCinema1());
				 //System.out.printf("Room 2 Vacancies: %d\n",cinema.getVacanciesCinema2());

				if ((cinema.getVacanciesCinema1() != 5) || (cinema.getVacanciesCinema2() != 6)) {
					System.out.printf("\nNO ANDA\n");
				}

			}
			System.out.printf("\n-------------Termino Ejercicio con Cinema %d", (j + 1));

		}

	}
}