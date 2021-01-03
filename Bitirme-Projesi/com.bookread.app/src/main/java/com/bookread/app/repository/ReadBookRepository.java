package com.bookread.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookread.app.model.ReadBook;

@Repository
public interface ReadBookRepository extends JpaRepository<ReadBook, Integer> {
	@Query(value = "SELECT * FROM read_book rb INNER JOIN authors a ON rb.author_id = a.id WHERE rb.book_name LIKE %:keyword% OR a.author_full_name LIKE %:keyword% OR rb.publisher LIKE %:keyword%", nativeQuery = true)
	List<ReadBook> findBooksByKeyword(@Param("keyword") String keyword);
	
	@Query(value = "SELECT count(*) FROM read_book", nativeQuery = true)
	public int bookCount();
	

}
