package com.bookread.app.service;

import java.util.List;

import com.bookread.app.model.ReadBook;

public interface ReadBookService {

	List<ReadBook> getSearchBooks(String searchWord);
	int bookCount();
}
