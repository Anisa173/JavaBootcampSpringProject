package com.project.demo.sushiCo.entity;

import java.util.Arrays;

public enum ShippersStatus {
	BUSY("Busy"), TRANSIT("IN-ProgressTransit"), ARRIVED("Arrived");

	private String value;

	ShippersStatus() {
		setValue("Busy");
	}

	ShippersStatus(String value) {
		this.setValue(value);
	}

	public static ShippersStatus fromValue(ShippersStatus shippersStatus) {
		return Arrays.asList(ShippersStatus.values()).stream().filter(st -> st.getValue().equals(shippersStatus)).findFirst()
				.orElseThrow(() -> new RuntimeException(String.format("Shippers could not be available", shippersStatus)));
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
