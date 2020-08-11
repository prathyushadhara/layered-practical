package org.dxctraining.entities;

public class Book {
	private String id;
	private String name;
	private double cost;
	private Author author;
	public Book(String id,String name,double cost,Author author) {
		this.id=id;
		this.name=name;
		this.cost=cost;
		this.author=author;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int hashCode(){
		int hash=id.hashCode();
		return hash;
		}
	
	public boolean equals(Object arg) {
		if(this==arg) {
			return true;
		}

	   if(arg==null || !(arg instanceof Book) ) {
			return false;
	   }

	    Book that=(Book)arg;	
		boolean isequal=this.id.equals(that.id);
		return isequal;
	}


}
