package com.project.demo.sushiCo.domain.exception;

public class StorageFileNotFoundException extends StorageException {
	private static final long serialVersionUID = -966873167195368960L;

	public StorageFileNotFoundException(String message) {
		super(message);
	}

	public StorageFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
