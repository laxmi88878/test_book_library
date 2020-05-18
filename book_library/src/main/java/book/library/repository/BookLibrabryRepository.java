package book.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import book.library.entity.BookLibrabry;
 
@Repository
public interface BookLibrabryRepository extends JpaRepository<BookLibrabry, Long>{
	
	
	@Modifying
	@Transactional
	@Query(value = "SELECT BOOK_NAME, BOOK_TYPE, BOOK_AUTHOR FROM BOOK_LIBRARY_DETAILS ", nativeQuery = true)
	List<Object[]> loadBookDetails();
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE BOOK_LIBRARY_DETAILS SET BOOK_NAME=:bname,BOOK_TYPE=:btype,BOOK_AUTHOR=:bauthor WHERE BOOK_REF_ID=:brefid ", nativeQuery = true)
	Integer updateBookDetails(@Param("bname") String bname, @Param("btype") String btype,@Param("bauthor") String bauthor,@Param("brefid") String brefid);

}
