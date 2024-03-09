package com.project.demo.sushiCo.entity;

import java.util.Arrays;

public enum StatusOrderSession {
	PENDING("Pending"), IN_PROGRESS("In_Progress"), PROCESSED("Processed");

	StatusOrderSession() {
		value = "Pending";
	}

	StatusOrderSession(String value) {
		this.value = value;
	}

	private String value;

	public static StatusOrderSession fromValue(String value) {
		return Arrays.asList(StatusOrderSession.values()).stream().filter(st -> st.getValue().equals(value)).findFirst()
				.orElseThrow(() -> new RuntimeException(String.format("Package_Order does not exists", value)));
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
