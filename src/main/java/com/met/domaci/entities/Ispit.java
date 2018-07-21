package com.met.domaci.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ispit")
public class Ispit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ispit_id")
	private int id;
	
	@Column(name = "naziv")
	@NotEmpty
	private String naziv;
	
	@Column(name = "termin")
	@NotEmpty
	private String termin;
	
	@Column(name = "nastavnik")
	@NotEmpty
	private String nastavnik;
	
	@ManyToMany(mappedBy = "ispiti")    
	private Set<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getTermin() {
		return termin;
	}

	public void setTermin(String termin) {
		this.termin = termin;
	}

	public String getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(String nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Ispit [id=" + id + ", naziv=" + naziv + ", termin=" + termin + ", nastavnik=" + nastavnik + ", users="
				+ users + "]";
	}  	
	
}
