package com.bookread.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookread.app.model.Authors;
import com.bookread.app.repository.AuthorsRepository;

@Controller
public class AuthorsController {

	@Autowired
	private AuthorsRepository authorsRepository;

	@GetMapping("/authors")
	public String listAuthors(Model model) {
		List<Authors> listAuthors = authorsRepository.findAll();
		model.addAttribute("listAuthors", listAuthors);
		return "authors";
	}

	@GetMapping("/authors/new")
	public String showAuthorNewForm(Model model) {
		model.addAttribute("author", new Authors());
		return "author_form";
	}

	@PostMapping("/authors/save")
	public String saveAuthors(Authors authors) {
		authorsRepository.save(authors);
		return "redirect:/authors";
	}
	
	
	
	
}
