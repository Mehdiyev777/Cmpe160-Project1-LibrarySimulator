package books;


import java.util.ArrayList;

import interfaces.*;
import librarymembers.LibraryMember;


public class Printed extends Book implements ReadInLibrary,Borrow{
	
	 int deadLine;
	boolean isExtended=false;
	
	
	
	public int getDeadline() {
		return deadLine;
	}
	
	public boolean getIsExtended() {
		
		return this.isExtended;
	}
	
	
/*
	
	public boolean isTaken;
	
	LibraryMember whoHas;
	
	
	*/
	public Printed(int bookID){
		super(bookID,"P"); // Bu gerekli mi?? Yoksa otomatik �a�r�l�yor muydu?
		
	}
	
	 // implementing Read in Lib
	public void borrowBook(LibraryMember member, int tick) {
//		System.out.println("hello");
		ArrayList<Book> history=member.getTheHistory();
		
		if (!history.contains(this))
			history.add(this);
		
		
		ArrayList<Book> curr=member.getCurrentBooks();
		curr.add(this); // b�yle olur mu?
		
		deadLine=member.getTimeLimit()+tick;
//		System.out.println("deadline�     "+deadLine);
		this.isTaken=true;
		this.whoHas=member;
		member.reduceCapacity();
//		System.out.println("azald�"+member.getMaxNumberOfBooks()+"\n");
		
		
	}
	
	//implement for R�N
	public void extend(LibraryMember member, int tick) {
		
		deadLine+=member.getTimeLimit();
		isExtended=true;
		
		//do checks in Library class
		
		
		
	}
	
	
	
	
	
	
	
	
	// for Borrow
	public void readBook(LibraryMember member) {
		ArrayList<Book> curr=member.getCurrentBooks();
		ArrayList<Book> history=member.getTheHistory();

		if (!history.contains(this))
			history.add(this); // b�yle olur mu? // buraya �eyi ekle !!!!! e�siz olsun historydeki kitaplar,
								// her kitap bir kere ge�meli

		this.isTaken=true;
		this.whoHas=member;
	//	member.reduceCapacity(); // Bu olacak m�? max s�n�r�ndaysa okuyabilir mi?
		deadLine=9999999; // b�y�k bir say�
		
		this.inReadingLibrary=true; 
		
		curr.add(this);
	}

	
	
	
	
	
	
	@Override
	public void returnBook(LibraryMember member) {
		// TODO Auto-generated method stub
		
//		System.out.println("SAY��� 111");
		
		ArrayList<Book> curr=member.getCurrentBooks();
//		int deleteIndex=-1;
//		for(int i=0;i<curr.size();i++) {
//			if(curr.get(i).bookID==this.bookID) {
//				deleteIndex=i;
//			}
//			
//		}
//		if(deleteIndex!=-1)
		curr.remove(this); // remove �n obje alan y�ntemi de mi var???
//		curr.
		deadLine=0;
		this.isTaken=false;
		this.whoHas=null;
		this.inReadingLibrary=false; 
		if(!this.inReadingLibrary)	member.increaseCapacity();
		
		
		
	}
	
}