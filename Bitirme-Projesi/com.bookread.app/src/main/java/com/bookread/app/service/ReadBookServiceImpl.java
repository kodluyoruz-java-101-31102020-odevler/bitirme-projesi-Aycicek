package com.bookread.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookread.app.model.ReadBook;
import com.bookread.app.repository.ReadBookRepository;
import com.bookread.app.aspect.MethodRunningTime;


@Service
public class ReadBookServiceImpl implements ReadBookService{
	
	@Autowired
	private ReadBookRepository readbookRepository;

	
	@Override
	@MethodRunningTime(active = true)
	public List<ReadBook> getSearchBooks(String searchWord) {
		List<ReadBook> foundedBooks = readbookRepository.findBooksByKeyword(searchWord);
		return foundedBooks;

	}
	@Override
	@MethodRunningTime(active = true)
	public int bookCount() {
		int count = readbookRepository.bookCount(); 
		return count;
	}
}
