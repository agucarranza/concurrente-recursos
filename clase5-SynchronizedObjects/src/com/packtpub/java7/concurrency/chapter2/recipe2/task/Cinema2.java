//VERSION DEL ALUMNO - SINCRONIZA CON UNA PRIMITIVA INTEGER Y ES REUTILIZADO - NO ANDA
package com.packtpub.java7.concurrency.chapter2.recipe2.task;

public class Cinema2 implements CinemaInterfaz {
	
	private Integer vacanciesCinema1;
	private Integer vacanciesCinema2;
	int hash1;
	int hash2;
	
	public Cinema2(){
	
		vacanciesCinema1=20;
		vacanciesCinema2=20;
		}
	
	public void inicia(){
		vacanciesCinema1=20;
		vacanciesCinema2=20;
		hash1=vacanciesCinema1.hashCode();
		hash2=vacanciesCinema2.hashCode();
	}
	
	public boolean sellTickets1(int number) {
			synchronized (vacanciesCinema1) {
			if (number<vacanciesCinema1) {
				vacanciesCinema1-=number;
				if(vacanciesCinema1.hashCode()!=hash1){
//					System.out.printf("\nCambio el HASH\n");
//					hash1=vacanciesCinema1.hashCode();
				}
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
		// TODO Auto-generated method stub
		synchronized (vacanciesCinema2) {
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
			synchronized (vacanciesCinema1) {
				vacanciesCinema1+=number;
				return true;
			}
		
		}

//	@Override
	public boolean returnTickets2(int number) 
	   {
		synchronized (vacanciesCinema2) {
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
