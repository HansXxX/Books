package com.spring;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends CrudRepository<Book, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Book b SET b.genere =:newgenere WHERE b.id=:id")
	void updateGenereById(@Param("id") int i, @Param("newgenere") String newGenere);

}
