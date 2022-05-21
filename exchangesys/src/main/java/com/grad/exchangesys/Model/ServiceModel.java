package com.grad.exchangesys.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableAutoConfiguration
public class ServiceModel {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "service_name", nullable = false)
	private String serviceName;
	
	@Column(name = "service_description", nullable = false)
	private String description;

	@CreatedDate
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "created_at")
	private Date createdAt;

	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	
	
}
