package book.library.service;

import java.util.List;

import book.library.json.BookLibraryRequest;

public interface BooksLibraryService {

	/** Load all the book library details
	 * @return
	 */
	List<BookLibraryRequest> loadAllBooksfromLibrary();

	/** update book details based on the book ref number
	 * @param request
	 * @param bookRefId
	 * @return
	 */
	Integer updateBook(BookLibraryRequest request, String bookRefId);

}
