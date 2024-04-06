//ORIGINAL DEL LIBRO
package com.packtpub.java7.concurrency.chapter2.recipe2.task;

public class Cinema1 implements CinemaInterfaz {
	
	private long vacanciesCinema1;
	private long vacanciesCinema2;
	private final Object controlCinema1, controlCinema2;
	
	public Cinema1(){
		controlCinema1=new Object();
		controlCinema2=new Object();
		vacanciesCinema1=20;
		vacanciesCinema2=20;
		}
	
	public void inicia(){
		vacanciesCinema1=20;
		vacanciesCinema2=20;
		
	}
	
	public boolean sellTickets1(int number) {
			synchronized (controlCinema1) {
			if (number<vacanciesCinema1) {
				vacanciesCinema1-=number;
				return true;
				
			} 
			else 
			{
			return false;
			}
		}
	}

//	@Override
	public boolean sellTickets2(int number) {
		synchronized (controlCinema2) {
			if (number<vacanciesCinema2) {
				vacanciesCinema2-=number;
				return true;
			} 
			else 
			{
			return false;
			}
		}
	}

//	@Override
	public boolean returnTickets1(int number) {
			synchronized (controlCinema1) {
				vacanciesCinema1+=number;
				return true;
			}
		
		}

//	@Override
	public boolean returnTickets2(int number) 
	   {
		synchronized (controlCinema2) {
			vacanciesCinema2+=number;
			return true;
		}
	  }

//	@Override
	public long getVacanciesCinema1() {
		return vacanciesCinema1;
		
	}

//	@Override
	public long getVacanciesCinema2() {
		return vacanciesCinema2;
	}

}
