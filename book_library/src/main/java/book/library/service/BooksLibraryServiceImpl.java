package book.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import book.library.json.BookLibraryRequest;
import book.library.repository.BookLibrabryRepository;

/**
 * @author laxmi
 *
 */
@Service
@Transactional
public class BooksLibraryServiceImpl{
	
	
	@Autowired
	private BookLibrabryRepository bookRepository;
	
	/** This method will load all book details
	 * @return BookLibraryRequest list
	 */
	public List<BookLibraryRequest> loadAllBooksfromLibrary(){
		List<BookLibraryRequest> booksLists =new ArrayList<BookLibraryRequest>();
			try{
			List<Object[]> booksList= bookRepository.loadBookDetails();
			if(!CollectionUtils.isEmpty(booksList)){
			for (Object[] book : booksList) {
				BookLibraryRequest request=new BookLibraryRequest();
				request.setbName(book[0].toString());
				request.setbType(book[1].toString());
				request.setbAuth(book[2].toString());
				booksLists.add(request);
			}
			}
			
		}catch (Exception e) {
				
		}
		return booksLists;
	}
	
	/** This method will update the book details based on the book ref number
	 * @param request
	 * @param bookId
	 * @return
	 */
	public Integer updateBook(BookLibraryRequest request,String bookId){
		Integer result=0;
		try{
		 result=bookRepository.updateBookDetails(request.getbName(), request.getbType(), request.getbAuth(), bookId);
		}catch (Exception e) {
			System.out.println("Update due to "+e);
		}
		return result;
	}

}
