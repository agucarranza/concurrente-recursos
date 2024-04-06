//SYNCHRONIZADO CON ARREGLO VACANCIES - ANDA
package com.packtpub.java7.concurrency.chapter2.recipe2.task;

public class Cinema3 implements CinemaInterfaz {
	
	private Integer vacancies[]; // long vacanciesCinema1;
	
	public Cinema3(){
		
		
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
		// TODO Auto-generated method stub
		synchronized (vacancies) {
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
		synchronized (vacancies) {
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
		synchronized (vacancies) {
			vacancies[0]+=number;
			return true;
		}
	}

	@Override
	public boolean returnTickets2(int number) {
		synchronized (vacancies) {
			vacancies[1]+=number;
			return true;
		}
	}

	@Override
	public long getVacanciesCinema1() {
		// TODO Auto-generated method stub
		return vacancies[0];
		}

	@Override
	public long getVacanciesCinema2() {
		// TODO Auto-generated method stub
		return vacancies[1];
	}

}
