package books;


import java.util.ArrayList;

import interfaces.*;
import librarymembers.LibraryMember;


public class Printed extends Book implements ReadInLibrary,Borrow{
	
	public int deadLine;
	boolean isExtended;
	
	
	
/*
	
	public boolean isTaken;
	
	LibraryMember whoHas;
	
	
	*/
	public Printed(int bookID){
		super(bookID,"P"); // Bu gerekli mi?? Yoksa otomatik �a�r�l�yor muydu?
		
	}
	
	 // implementing Read in Lib
	public void borrowBook(LibraryMember member, int tick) {
		
		ArrayList<Book> history=member.getTheHistory();
		history.add(this); // b�yle olur mu?
		deadLine=member.getTimeLimit()+tick;
		this.isTaken=true;
		this.whoHas=member;
		member.reduceCapacity();
		
		
	}
	
	//implement for R�N
	public void extend(LibraryMember member, int tick) {
		
		deadLine+=member.getTimeLimit();
		isExtended=true;
		
		//do checks in Library class
		
		
		
	}
	
	
	
	
	
	
	
	
	// for Borrow
	public void readBook(LibraryMember member) {
		
		ArrayList<Book> history=member.getTheHistory();
		history.add(this); // b�yle olur mu?
		this.isTaken=true;
		this.whoHas=member;
		member.reduceCapacity(); // Bu olacak m�? max s�n�r�ndaysa okuyabilir mi?
		
		
		
		
		
	}

	
	
	
	
	
	
	@Override
	public void returnBook(LibraryMember member) {
		// TODO Auto-generated method stub
		
		deadLine=0;
		this.isTaken=false;
		this.whoHas=null;
		member.increaseCapacity();
		
		
		
	}
	
}