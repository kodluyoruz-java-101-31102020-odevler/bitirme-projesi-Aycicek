package com.bookread.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "read_book")
public class ReadBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "book_name")
	private String book_name;

	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "number_of_page")
	private String number_of_page;
	
	@Column(name = "how_many_star")
	private String how_many_star;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Authors author;

}
