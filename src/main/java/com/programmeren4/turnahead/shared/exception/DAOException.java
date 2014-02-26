package com.programmeren4.turnahead.shared.exception;

public class DAOException extends Exception {
	private static final long serialVersionUID = 1L;

	public DAOException() {
		super("Problem accessing datastore");

	}

	public DAOException(String message) {
		super(message);
	}
}