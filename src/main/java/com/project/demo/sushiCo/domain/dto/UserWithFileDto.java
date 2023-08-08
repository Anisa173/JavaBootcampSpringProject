package com.project.demo.sushiCo.domain.dto;

import org.springframework.web.multipart.MultipartFile;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserWithFileDto {

	private Integer id;

	private String first_name;

	private String last_name;

	private String address;

	private Integer age;

	private MultipartFile file;

	public UserWithFileDto() {

	}

	public UserWithFileDto(Integer id, String first_name, String last_name, String address, Integer age,
			MultipartFile file) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.age = age;
		this.file = file;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String toString() {
		return "UserWithFileDto[id = " + id + ",first_name = " + first_name + ",last_name = " + last_name
				+ ",address = " + address + ",file = " + file + ",age = " + age + "]";
	}

}
