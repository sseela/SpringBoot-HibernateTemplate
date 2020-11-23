package com.example.HibernateTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	private CommonService service;
	
	@PostMapping(value="/saveBook")
	public void saveBook(@RequestBody BookVm book) {
		this.service.saveBook(book);
	}
}
