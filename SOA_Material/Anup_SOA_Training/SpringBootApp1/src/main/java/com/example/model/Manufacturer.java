package com.example.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

//192.168.1.29
@Document(collection="sgmfrs")
public class Manufacturer {
	private int id;
	private String name;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-mm-dd")
	private Date foundedDate;
	private Boolean active;

	public Manufacturer() {
	}

	public Manufacturer(int id, String name, Date foundedDate, Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.foundedDate = foundedDate;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getFoundedDate() {
		return foundedDate;
	}

	public void setFoundedDate(Date foundedDate) {
		this.foundedDate = foundedDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
