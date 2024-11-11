package com.krishna.Library_App.repo;

import com.krishna.Library_App.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface BookRepo extends JpaRepository<Book, Long> {
    @Transactional
    @Modifying
    @Query("update Book u set u.bookName=?2 where u.bookId=?1")
    int updateAddress(long id, String name);
}