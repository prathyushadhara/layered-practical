package org.dxctraining.dao;

import java.util.List;
import org.dxctraining.entities.Book;

public interface IBookDao {
	Book findById(String id);

	List<Book> displayAllBooks();

	void add(Book book);

	Book updateCost(String id, double cost);

	void remove(String id);

}
