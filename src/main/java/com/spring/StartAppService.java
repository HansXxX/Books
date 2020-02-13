package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StartAppService {

	@Autowired
	private Service service;

	private void retrieveBooks() {
		System.out.println("\n--------------Opere: --------------");
		service.findAllBooks().forEach(b -> {
			System.out.print("Nome: " + b.getNome() + "\tGenere: " + b.getGenere() + "\tAutore: "
					+ b.getAuthor().getNome() + " " + b.getAuthor().getCognome() + "\n");

		});

	}

	private void retrieveAuthors() {
		System.out.println("\n----------------Autori:------------------");
		service.findAllAuthors().forEach(a -> {
			System.out.print(
					"Nome: " + a.getNome() + "\tCognome: " + a.getCognome() + "\tLista opere: " + a.getLibri() + "\n");
		});

	}

	public static void main(String[] args) {
		SpringApplication.run(StartAppService.class, args);
	}

	@Bean
	public CommandLineRunner testService() {
		return (args) -> {

			/*
			 * Book dc = new Book("Divina Commedia", "poema"); Book vn = new
			 * Book("La Vita Nuova", "prosimetro"); List<Book> lst = new ArrayList<Book>();
			 * Author dante = new Author("Dante", "Alighieri"); dc.setAuthor(dante);
			 * vn.setAuthor(dante); lst.add(dc); lst.add(vn); dante.setLibri(lst);
			 * service.addAuthor(dante); service.addBook(dc); service.addBook(vn);
			 * 
			 * Book ps = new Book("Promessi Sposi", "romanzo storico"); Book cm = new
			 * Book("il 5 Maggio", "poesia"); List<Book> l = new ArrayList<Book>(); Author
			 * manzoni = new Author("Alessandro", "Manzoni"); ps.setAuthor(manzoni);
			 * cm.setAuthor(manzoni); lst.add(ps); lst.add(cm); manzoni.setLibri(l);
			 * service.addAuthor(manzoni); service.addBook(ps); service.addBook(cm);
			 */

			// retrieve di tutti i libri presenti nel database
			retrieveBooks();

			// retrieve di tutti gli autori presenti nel database
			retrieveAuthors();

			// retrieve di un'opera e di un autore dall'id
			System.out.println("\n" + service.findAuthById(29));
			System.out.println(service.findBookById(2));

			// update del genere di un libro a partire dal suo id
			service.updateGenereById(3, "romanzo");
			retrieveBooks();

			// delete di un libro dall'id
			service.deleteBookbyId(3);
			retrieveBooks();
			retrieveAuthors();

			System.out.println("");

		};

	}

}
