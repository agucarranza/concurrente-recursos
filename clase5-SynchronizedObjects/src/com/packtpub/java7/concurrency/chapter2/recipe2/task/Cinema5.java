//SYNCHRONIZADO CON OBJETO TOTAL, DONDE SE HACEN LAS OPERACIONES - ANDA
package com.packtpub.java7.concurrency.chapter2.recipe2.task;

public class Cinema5 implements CinemaInterfaz {


	private Total controlCinema1, controlCinema2;

	public Cinema5() {
		controlCinema1 = new Total(20);
		controlCinema2 = new Total(20);

	}
	
	public void inicia(){
		controlCinema1.set(20);
		controlCinema2.set(20);
		
	}

	public boolean sellTickets1(int number) {
		synchronized (controlCinema1) {
			if (number < controlCinema1.get()) {
				controlCinema1.incrementar(-number);
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean sellTickets2(int number) {
		synchronized (controlCinema2) {
			if (number < controlCinema2.get()) {
				controlCinema2.incrementar(-number);

				return true;
			} else {
				return false;
			}
		}
	}

	public boolean returnTickets1(int number) {
		synchronized (controlCinema1) {
			controlCinema1.incrementar(number);
			return true;
		}
	}

	public boolean returnTickets2(int number) {
		synchronized (controlCinema2) {
			controlCinema2.incrementar(number);

			return true;
		}
	}

	public long getVacanciesCinema1() {
		return controlCinema1.get();
	}

	public long getVacanciesCinema2() {
		return controlCinema2.get();
	}

}