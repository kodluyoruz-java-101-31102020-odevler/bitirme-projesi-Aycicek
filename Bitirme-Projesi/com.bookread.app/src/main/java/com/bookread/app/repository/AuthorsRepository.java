package com.bookread.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookread.app.model.Authors;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Integer> {

}
