package com.example.HibernateTemplate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
	
	// we dont need this sessionFactory if we use HibernateTemplate becoz HibernateTemplate will take care of handling the session.
	
	/*@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory sessionFactory;*/
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void save(BookEntity entity) {
		hibernateTemplate.save(entity);
		
	}
	
	/*@Transactional
	public void fetchAllRecords() {
		List<BookEntity> list = hibernateTemplate.loadAll(BookEntity.class);
		System.out.println(list.size());
	}*/


}
