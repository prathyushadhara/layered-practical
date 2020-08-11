package org.dxctraining.service;
import java.util.*;

import org.dxctraining.entities.Book;

public interface IBookService {
	Book findById(String id);

	List<Book> displayAllBooks();

	void add(Book book);

	Book updateCost(String id,double cost);

	void remove(String id);

}


