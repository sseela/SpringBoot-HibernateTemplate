package com.example.HibernateTemplate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BookTable")
@Data
public class BookEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookId;
	
	@Column(name="bookName")
	private String bookName;
}
