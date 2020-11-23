package com.example.HibernateTemplate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
	
	@Autowired
	private BookRepository bookRepo;
	
	
	public void saveBook(BookVm book) {
		BookEntity entity = new BookEntity();
		entity.setBookId(book.getBookId());
		entity.setBookName(book.getBookName());
		this.bookRepo.save(entity);
	}
	
	
	
}