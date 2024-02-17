package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bookStore.entity.Book;
import com.bookStore.service.BookService;
import java.util.*;

@RequestMapping("/book")
@RestController
public class BookController {

	@Autowired
	private BookService service;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/availableBooks")
	public List<Book> getAllBook() {
		List<Book>list=service.getAllBook();
		return list;
	}
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody Book b) {
		try {
			service.save(b);
			return "added book successfully";
		} catch (Exception e) {
		   return "unable to add book";
		}
		 
	}
	
	@PostMapping("/editBook")
	public String updateUser (@RequestBody Book books) {
		try {
			return 	service.updateSer1(books);
		} catch (Exception e) {
		   return "unable to update";
		}
	}
	
	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam("id")int id) {
		try {
			service.deleteById(id);
			return "id deleted";
		} catch (Exception e) {
		   return "unable to delete";
		}
		
	}
	
}

