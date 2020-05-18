package book.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import book.library.json.BookLibraryRequest;
import book.library.json.BookLibraryResponse;
import book.library.service.BooksLibraryServiceImpl;

@RestController
public class BookController {
	
	@Autowired
	private BooksLibraryServiceImpl booksLibraryServiceImpl;
	
	
	
	@GetMapping("/getAllBooks")
	public List<BookLibraryRequest> getAllBooks() {
		List<BookLibraryRequest> booksLists =new ArrayList<BookLibraryRequest>();
		try{
		 booksLists=booksLibraryServiceImpl.loadAllBooksfromLibrary();
		 
		}catch(Exception e){
			
		}
		return booksLists;
	}
	
	
	@PostMapping("/updateBook/{bookRefId}")
	public void updateBookDetails(@PathVariable("bookRefId")String bookRefId,
			@RequestBody BookLibraryRequest request) {
		try {
			BookLibraryResponse response=new BookLibraryResponse();
			Integer result =booksLibraryServiceImpl.updateBook(request, bookRefId);
			if(result==1){
				response.setStatus("Success");
			}else{
				response.setStatus("Failed");
			}
		    }catch (Exception e) {
			
		    }
	}
	
	
}
