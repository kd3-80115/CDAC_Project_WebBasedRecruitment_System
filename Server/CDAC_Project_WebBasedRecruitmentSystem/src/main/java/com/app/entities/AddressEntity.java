package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Addresses")
@NoArgsConstructor

@Getter
@Setter
@ToString
public class AddressEntity extends BaseEntity{
	
	@Column(name = "permanent_address")
	private String permanentAddress;
	
	@Column(length = 6)
	private String pincode;
	
	@Column(length = 50)
	private String state;
	
	@Column(length = 30)
	private String country;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserEntity user;

	public AddressEntity(String permanentAddress, String pincode, String state, String country, UserEntity user) {
	
		this.permanentAddress = permanentAddress;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
		this.user = user;
	}
	
	
}
