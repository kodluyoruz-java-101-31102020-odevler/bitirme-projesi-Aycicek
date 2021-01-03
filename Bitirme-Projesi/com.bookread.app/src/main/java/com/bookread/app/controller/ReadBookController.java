
package com.bookread.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookread.app.model.Authors;
import com.bookread.app.model.ReadBook;
import com.bookread.app.repository.AuthorsRepository;
import com.bookread.app.repository.ReadBookRepository;
import com.bookread.app.service.ReadBookService;

@Controller
public class ReadBookController {

	@Autowired
	private ReadBookRepository readBookRepository;

	@Autowired
	private ReadBookService readbookService;

	@Autowired
	private AuthorsRepository authorsRepository;

	@GetMapping("/read_books/new")
	public String showNewReadBookForm(Model model) {
		List<Authors> listAuthors = authorsRepository.findAll();

		model.addAttribute("read_book", new ReadBook());
		model.addAttribute("listAuthors", listAuthors);

		return "read_book_form";
	}

	@PostMapping("/read_books/save")
	public String saveReadBook(@Valid ReadBook readbook, Errors errors) {
		readBookRepository.save(readbook);
		return "redirect:/read_books";

	}

	@GetMapping("/read_books")
	public String listReadBook(Model model) {
		List<ReadBook> listReadBooks = readBookRepository.findAll();
		int count = readbookService.bookCount();
		model.addAttribute("count", count);
		model.addAttribute("listReadBooks", listReadBooks);
		return "read_books";
	}

	@GetMapping("read_books/edit/{id}")
	public String showEditReadBookForm(@PathVariable("id") Integer id, Model model) {
		ReadBook read_book = readBookRepository.findById(id).get();
		model.addAttribute("read_book", read_book);

		List<Authors> listAuthors = authorsRepository.findAll();
		model.addAttribute("listAuthors", listAuthors);
		return "read_book_form";

	}

	@GetMapping("read_books/delete/{id}")
	public String deleteReadBook(@PathVariable("id") Integer id, Model model) {
		readBookRepository.deleteById(id);

		return "redirect:/read_books";

	}

	@PostMapping("/showSearchResult")
	public String showSearchResult(@ModelAttribute("searchWord") String searchWord, Model model) {
		List<ReadBook> foundedBooks = readbookService.getSearchBooks(searchWord);
		model.addAttribute("foundedBooks", foundedBooks);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("foundedBooksSize", foundedBooks.size());
		return "search_result";
	}

}
