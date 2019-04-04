package books;

import java.util.ArrayList;

import interfaces.ReadInLibrary;
import librarymembers.LibraryMember;

public class Handwritten extends Book implements ReadInLibrary{
	
	/*
	 * 
	int bookID;
	String bookType;
	
	public boolean isTaken;
	
	LibraryMember whoHas;

	 * 
	 */
	
	
	public Handwritten(int bookID){
		super(bookID,"H");
		
	}

	@Override
	public void readBook(LibraryMember member) {
		// TODO Auto-generated method stub
	
		ArrayList<Book> history=member.getTheHistory();
		if (!history.contains(this)) {
			history.add(this);}
		
		this.inReadingLibrary=true; // inLib mi?
		this.isTaken=true;
		this.whoHas=member;
	//	member.reduceCapacity(); // Bu olacak m�? max s�n�r�ndaysa okuyabilir mi?
		ArrayList<Book> curr=member.getCurrentBooks();
		curr.add(this);
		

	}

	@Override
	public void returnBook(LibraryMember member) {
		// TODO Auto-generated method stub
		ArrayList<Book> curr=member.getCurrentBooks();
		
		curr.remove(this);
		
		
		this.isTaken=false;
		this.whoHas=null;
		this.inReadingLibrary=false; 
		if(!this.inReadingLibrary) member.increaseCapacity();
		

		
	}
	
	
	
}