package com.krishna.Library_App.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long bookId ;

  private String bookName;

  private String category;

  private String author;

  private String publisher;

  private String edition;



}
