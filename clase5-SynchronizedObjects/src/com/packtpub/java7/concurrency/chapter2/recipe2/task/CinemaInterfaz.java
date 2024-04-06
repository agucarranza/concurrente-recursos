package com.packtpub.java7.concurrency.chapter2.recipe2.task;

public interface CinemaInterfaz {
	
	public boolean sellTickets1 (int number);
	public boolean sellTickets2 (int number);
	public boolean returnTickets1 (int number);
	public boolean returnTickets2 (int number);
	public long getVacanciesCinema1();
	public long getVacanciesCinema2();
	public void inicia();
	
	
	
	

}
