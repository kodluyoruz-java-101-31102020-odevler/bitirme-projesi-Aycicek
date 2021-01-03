package com.bookread.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "authors")
public class Authors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

@NotEmpty(message = "*Please provide a author name")
	@Column(name = "author_full_name")
	private String author_full_name;

}
