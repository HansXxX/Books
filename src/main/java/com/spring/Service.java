package com.spring;

import java.util.List;

/* interfaccia per nascondere le repository al client e offrire metodi
 * per operare sia sui libri che sugli autori */
public interface Service {

	// metodi sui Book

	Book findBookById(Integer id);

	List<Book> findAllBooks();

	void addBook(Book b);

	void updateGenereById(Integer id, String newGenere);

	void deleteBookbyId(Integer id);

	// metodi sugli Author

	Author findAuthById(Integer id);

	List<Author> findAllAuthors();

	void addAuthor(Author a);

	void deleteAuthorById(Integer id);

}
