package com.example;

import org.springframework.stereotype.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>{
	
@Query("select b from Books b where b.title like '%(:titleName)%'")
List<Books> findByTitle(@Param("titleName") String titleName);

}