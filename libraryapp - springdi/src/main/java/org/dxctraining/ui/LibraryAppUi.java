package org.dxctraining.ui;

import java.util.List;

import javax.annotation.PostConstruct;

import org.dxctraining.entities.Author;
import org.dxctraining.entities.Book;
import org.dxctraining.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryAppUi {
	@Autowired
	private IBookService bookService;

	@PostConstruct
	public void run() {
		Author author1 = new Author("1", "prathyusha");
		Author author2 = new Author("4", "priya");
		Author author3 = new Author("3", "chinni");
		Book book1 = new Book("PR", "five stars", 543.34, author1);
		Book book2 = new Book("SR", "The moon", 593.34, author2);
		Book book3 = new Book("DS", "mieko", 893.34, author3);
		bookService.add(book1);
		bookService.add(book2);
		bookService.add(book3);
		displayAllBooks();
		boolean isEquals = book1.equals(book2);
		boolean isEquals1 = book2.equals(book3);
		System.out.println("is equal=" + isEquals);
		System.out.println("is equal=" + isEquals1);
	}

	public void displayAllBooks() {
		List<Book> list = bookService.displayAllBooks();
		System.out.println("the total books in the library:");
		for (Book book : list) {
			display(book);
		}
	}

	public void display(Book book) {
		// System.out.println("the total books in the library:");
		Author author = book.getAuthor();
		System.out.println("author id is::" + author.getId() + "The author is ::" + author.getName()
				+ " Name of the book:: " + book.getName() + " cost is::" + book.getCost());
	}
}
