package com.sahu.um.model;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(value = { AuditingEntityListener.class })
//entity listeners helps to specify the call back listener, here the callback listener is 
//AuditingEntityListener
public abstract class Auditable<User> {
	
	@CreatedBy
	protected User createdBy;
	
	@CreatedDate
	protected Date createdAt;
	
	@LastModifiedBy
	protected User updatedBy;
	
	@LastModifiedDate
	protected Date updatedAt;
	
	
}
