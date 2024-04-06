//SYNCHRONIZADO CON ELEMENTOS DEL ARREGLO - NO ANDA
package com.packtpub.java7.concurrency.chapter2.recipe2.task;

public class Cinema4 implements CinemaInterfaz {
	
	private Integer vacancies[]; // long vacanciesCinema1;
	
	public Cinema4(){
		
		
		vacancies=new Integer[2];
		vacancies[0]=20;
		vacancies[1]=20;
		}
	
	public void inicia(){
		vacancies[0]=20;
		vacancies[1]=20;
		
	}

	@Override
	public boolean sellTickets1(int number) {
		synchronized (vacancies[0]) {
			if (number<vacancies[0]) {
				vacancies[0]-=number;
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public boolean sellTickets2(int number) {
		synchronized (vacancies[1]) {
			if (number<vacancies[1]) {
				vacancies[1]-=number;
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public boolean returnTickets1(int number) {
		synchronized (vacancies[0]) {
			vacancies[0]+=number;
			return true;
		}
	}

	@Override
	public boolean returnTickets2(int number) {
		synchronized (vacancies[1]) {
			vacancies[1]+=number;
			return true;
		}
	}

	@Override
	public long getVacanciesCinema1() {
		return vacancies[0];
		}

	@Override
	public long getVacanciesCinema2() {
		return vacancies[1];
	}

}
