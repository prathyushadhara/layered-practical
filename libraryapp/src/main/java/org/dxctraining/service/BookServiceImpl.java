package org.dxctraining.service;

import java.util.List;

import org.dxctraining.dao.*;
import org.dxctraining.entities.Book;
import org.dxctraining.exceptions.*;

public class BookServiceImpl implements IBookService {
	private IBookDao dao = new BookDaoImpl();

	public Book findById(String id) {
		checkId(id);
		Book book = dao.findById(id);
		return book;
	}

	private void checkId(String id) {
		if (id == null) {
			throw new InvalidArgumentException("id is null");
		}
	}

	public void add(Book book) {
		checkBook(book);
		dao.add(book);

	}

	private void checkBook(Book book) {
		if (book == null) {
			throw new InvalidArgumentException("book can not be null");
		}
	}

	public void remove(String id) {
		checkId(id);
		dao.remove(id);

	}

	public Book updateCost(String id, double cost) {
		checkId(id);
		checkCost(cost);
		Book book = dao.updateCost(id, cost);
		return book;
	}

	private void checkCost(double cost) {
		if (cost < 0) {
			throw new InvalidBookCostException("cost can not be negative");
		}
	}

	public List<Book> displayAllBooks() {
		List<Book>list=dao.displayAllBooks();
		return list;
	}
}
