package com.apibank.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;



@Data
@Entity
public class Person implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="name", nullable=false, length=512)
	private String name;
	
	
	@Column(name="email", nullable=false, unique=true, length=512)
	private String email;
	
	
	@Column(name="cpf", nullable=false,unique=true, length=512)
	private String cpf;
	
	
	
	
	@Column(name="data_nascimento", nullable=false, length=512)
	@Temporal(TemporalType.DATE) // yyyy-MM-dd
	private Date data_nascimento;
	
	public Person() {
		
	}
	 
	
	
	



	public Person(Long id, String name, String email, String cpf, Date data_nascimento) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
	}







	public Date getData_nascimento() {
		return data_nascimento;
	}







	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}







	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}






	
	
	

}
