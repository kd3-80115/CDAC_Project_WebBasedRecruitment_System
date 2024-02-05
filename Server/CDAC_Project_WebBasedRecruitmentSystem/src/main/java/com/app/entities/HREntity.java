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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hr_table")
public class HREntity extends BaseEntity{

	@Column(length = 60,nullable = false)
	private String qualification;
	
	@Column(length = 60,nullable = false)
	private String officeLocation;
	
	@Column(nullable = false)
	private boolean activeStatus;
	
	@Column(length = 60,nullable = false)
	private String department;
	
	private String imageURL;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserEntity user;
}
