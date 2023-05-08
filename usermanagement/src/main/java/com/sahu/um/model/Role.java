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
@ToString
@Entity
@NoArgsConstructor
public class Role extends Auditable<Long> implements Serializable {
	@Id
	private Long id;
	
	private String name;
	
	private boolean active;
}
