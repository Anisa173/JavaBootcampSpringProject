package com.project.demo.sushiCo.domain.exception;

public class StorageException extends RuntimeException {
	private static final long serialVersionUID = 8139828183302891542L;

	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}

}
