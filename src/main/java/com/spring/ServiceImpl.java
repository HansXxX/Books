package com.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ServiceImpl implements Service {

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private AuthorRepository authRepo;

	@Override
	public Book findBookById(Integer id) {
		return bookRepo.findById(id).get();
	}

	@Override
	public List<Book> findAllBooks() {
		return (List<Book>) bookRepo.findAll();
	}

	@Override
	public void addBook(Book b) {
		bookRepo.save(b);
	}

	@Override
	public void updateGenereById(Integer id, String newGenere) {
		bookRepo.updateGenereById(id, newGenere);
	}

	@Override
	public void deleteBookbyId(Integer id) {
		bookRepo.deleteById(id);
	}

	@Override
	public Author findAuthById(Integer id) {
		return authRepo.findById(id).get();
	}

	@Override
	public List<Author> findAllAuthors() {
		return (List<Author>) authRepo.findAll();
	}

	@Override
	public void addAuthor(Author a) {
		authRepo.save(a);
	}

	@Override
	public void deleteAuthorById(Integer id) {
		authRepo.deleteById(id);
	}

}
