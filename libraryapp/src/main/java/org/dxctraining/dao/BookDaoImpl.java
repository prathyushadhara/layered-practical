package org.dxctraining.dao;

import org.dxctraining.entities.*;
import java.util.*;
import org.dxctraining.exceptions.BookNotFoundException;

public class BookDaoImpl implements IBookDao {
	private Map<String, Book> store = new HashMap<>();
	private int id;

	private String generateId() {
		id++;
		String generatedId = "" + id;
		return generatedId;
	}

	public Book findById(String id) {
		Book book = store.get(id);
		if (book == null) {
			throw new BookNotFoundException("book not found");
		}
		return book;
	}

	public List<Book> displayAllBooks() {
		Collection<Book> values = store.values();
		List<Book> list = new ArrayList();
		for (Book books : values) {
			list.add(books);
		}
		return list;
	}

	public void add(Book book) {
		String id = generateId();
		store.put(id, book);
		book.setId(id);
	}

	public void remove(String id) {
		store.remove(id);
	}

	public Book updateCost(String id, double cost) {
		Book book = findById(id);
		book.setCost(cost);
		return book;
	}
}