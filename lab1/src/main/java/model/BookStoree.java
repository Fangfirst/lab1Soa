package model;

public class BookStoree {
   private  String Isbn;
   private  String title ;
   private String author;
   private String catagory;
   private int year ;
   private Byte edition = null;
   private Double price ;
   private int index =0;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	
	this.author = author;
}
public String getCatagory() {
	return catagory;
}
public void setCatagory(String catagory) {
	this.catagory = catagory;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public Byte getEdition() {
	return edition;
}
public void setEdition(Byte edition) {
	this.edition = edition;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public String getIsbn() {
	return Isbn;
}
public void setIsbn(String isbn) {
	Isbn = isbn;
}
}
