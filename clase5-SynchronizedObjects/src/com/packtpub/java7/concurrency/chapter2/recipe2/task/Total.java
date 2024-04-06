package com.packtpub.java7.concurrency.chapter2.recipe2.task;


public class Total {
	
	private Integer i;
	
	public Total(Integer i) {
		super();
		this.i = i;
	}

	
	public void incrementar(Integer h){
		i=i+h;
	}
	
	public void set(Integer k){
		i=k;
	}
	public Integer get(){
		return i;
	}

}
