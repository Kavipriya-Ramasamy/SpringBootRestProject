package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKS")
public class Books {
@Id
private int bookID;
@Column
private String title;
@Column
private String authors;
@Column
private float average_rating;
@Column
private int isbn;
@Column
private String language_code;
@Column
private int ratings_count;
@Column
private int price;
public int getBookID() {
	return bookID;
}
public void setBookID(int bookID) {
	this.bookID = bookID;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthors() {
	return authors;
}
public void setAuthors(String authors) {
	this.authors = authors;
}
public float getAverage_rating() {
	return average_rating;
}
public void setAverage_rating(float average_rating) {
	this.average_rating = average_rating;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public String getLanguage_code() {
	return language_code;
}
public void setLanguage_code(String language_code) {
	this.language_code = language_code;
}
public int getRatings_count() {
	return ratings_count;
}
public void setRatings_count(int ratings_count) {
	this.ratings_count = ratings_count;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

}
