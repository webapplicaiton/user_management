package com.sahu.um.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@NoArgsConstructor
@ToString
public class Permission extends Auditable<Long> implements Serializable {
	
	@Id
	private Long id;
	
	private String name;
	
	private String description;
	
	private boolean active;
	
}
