package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b) {
		bRepo.save(b);
	}
	
	public List<Book> getAllBook(){
		return bRepo.findAll();
	}
	public Book getBookById(int id){
		return bRepo.findById(id).get();
	}
	
	public String updateSer1(Book books)  {
    try {
    	Book getId=bRepo.findById(books.getId()).get();
    	if(books.getName()!=null && !books.getName().isBlank()) {
    		getId.setName(books.getName());
    	}
    	if(books.getAuthor()!=null && !books.getAuthor().isBlank()) {
    		getId.setAuthor(books.getAuthor());
    	}
    	if(books.getPrice()!=null && ! books.getPrice().isBlank()) {
    		getId.setPrice(books.getPrice());
    	}
    	bRepo.save(getId);
    	return "updated successfully";
    }catch(Exception e) {
    	throw e;
    }
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}

	
