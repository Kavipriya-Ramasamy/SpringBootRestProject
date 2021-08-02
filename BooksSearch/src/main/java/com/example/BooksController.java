package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BooksController {
	@Autowired
	private BooksRepository booksRepository;

	@GetMapping("/")
	public String getBooks() {
		List<Books> bookList = new ArrayList<Books>();
		String inline = new String();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			 bookList =
			 objectMapper.readValue("https://s3-ap-southeast-1.amazonaws.com/he-public-data/books8f8fe52.json",
			 new TypeReference<List<Books>>(){});
//			bookList = objectMapper.readValue(new File("src/main/resources/books.json"),
//					new TypeReference<List<Books>>() {
//					});
			if (bookList != null) {
				for (Books books : bookList)
					booksRepository.save(books);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return inline;
	}

	@GetMapping("/getBooks")
	public List<Books> getBooksfromDB() {
		List<Books> bookList = new ArrayList<Books>();
		bookList = booksRepository.findAll();
		return bookList;
	}

	@GetMapping("/getBooksbyId/{bookID}")
	public Optional<Books> getBooksfromDB(@PathVariable int bookID) {
		Optional<Books> books = booksRepository.findById(bookID);
		return books;
	}

	@GetMapping("/search/{title}")
	public List<Books> searchByTitleTerm(@PathVariable String title) {
		List<Books> books = booksRepository.findByTitle(title);
		return books;
	}
}
