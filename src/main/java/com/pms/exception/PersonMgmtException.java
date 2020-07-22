package com.pms.exception;


public class PersonMgmtException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PersonMgmtException(String msg) {
		super("PersonMgmtException due to "+msg);
	}

}
