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
import book.library.service.BooksLibraryService;

/**
 * @author laxmi
 *
 */
@RestController
public class BookController {
	
	@Autowired
	private BooksLibraryService booksLibraryService;
	
	
	
	/** This method will call to service and load the all the book details and it will return the list of book details
	 * @return
	 */
	@GetMapping("/getAllBooks")
	public List<BookLibraryRequest> getAllBooks() {
		List<BookLibraryRequest> booksLists =new ArrayList<BookLibraryRequest>();
		try{
		 booksLists=booksLibraryService.loadAllBooksfromLibrary();
		}catch(Exception e){
		}
		return booksLists;
	}
	
	
	/** This method will update the book details based on the boo ref number and return 1 or 0.If 1 then it Success other then update fail
	 * @param bookRefId
	 * @param request
	 */
	@PostMapping("/updateBook/{bookRefId}")
	public void updateBookDetails(@PathVariable("bookRefId")String bookRefId,
			@RequestBody BookLibraryRequest request) {
		try {
			BookLibraryResponse response=new BookLibraryResponse();
			Integer result =booksLibraryService.updateBook(request, bookRefId);
			if(result==1){
				response.setStatus("Success");
                System.out.println("Book details updated Successfully.");
			}else{
				response.setStatus("Failed");
				System.out.println("Book details not updated.");
			}
		    }catch (Exception e) {
			
		    }
	}
	
	
}
