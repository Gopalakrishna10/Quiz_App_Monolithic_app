package com.example.demo.Model;

import java.util.Objects;

public class Responce {

	private Integer id;
	private String responce;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResponce() {
		return responce;
	}
	public void setResponce(String responce) {
		this.responce = responce;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, responce);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Responce other = (Responce) obj;
		return Objects.equals(id, other.id) && Objects.equals(responce, other.responce);
	}
	@Override
	public String toString() {
		return "Responce [id=" + id + ", responce=" + responce + "]";
	}
	public Responce(Integer id, String responce) {
		super();
		this.id = id;
		this.responce = responce;
	}
	public Responce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}