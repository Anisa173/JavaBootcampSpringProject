package com.project.demo.sushiCo.entity;

import java.util.Arrays;

public enum OrderStatus {
	CANCELLED("Cancelled"), PENDING("Pending"), IN_PROGRESS("In-progress"), PROCESSED("Processed");

	private String value;

	OrderStatus() {
		value = "Pending";
	}

	OrderStatus(String value) {
		this.value = value;
	}

	public static OrderStatus fromValue(String value) {
		return Arrays.asList(OrderStatus.values()).stream().filter(o -> o.getValue().equals(value)).findFirst()
				.orElseThrow(() -> new RuntimeException(String.format("Order not exists!", value)));
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
