package com.eguru.website.tesing;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class tester {
	@Id
	private int idno;
	private int naming;
	public int getIdno() {
		return idno;
	}
	public void setIdno(int idno) {
		this.idno = idno;
	}
	public int getNaming() {
		return naming;
	}
	public void setNaming(int naming) {
		this.naming = naming;
	}
	
	
}
