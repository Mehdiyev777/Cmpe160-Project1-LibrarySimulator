package library;

import java.util.*;

import librarymembers.Academic;
import librarymembers.LibraryMember;
import librarymembers.Student;
import books.Book;
import books.Printed;
import books.Handwritten;
public class Library{
	
	LibraryMember[] members;
	Book[] books;
	
	int firstBook=1;
	int lastBook=0; // index of last book , 0 means no book
	int firstMember=1;
	int lastMember=0;
	Scanner FileScanner;
	
	private int totalFee;
	
	private LibraryMember getMemberByID(int id) {
		return members[id-1];
	}
	
	private Book getBookByID(int id) {
		return books[id-1];
	}
	
	public Library(Scanner input) {
		
		 FileScanner=input;
		members=new LibraryMember[999999]; // 10**6 m� olacak hocaya sor, anlat�mda eksik var
		books=new Book[999999];
	
	}
	
	
	public void addBook() {
		String BookType=  FileScanner.next();
		
		
		if(BookType.equals("P")) {
			lastBook++;
			books[lastBook-1]=new Printed(lastBook);
		}
			
		
		if(BookType.equals("H")) {
			lastBook++;
			books[lastBook-1]=new Handwritten(lastBook);
		}
			
		for(int i =0;i<10;i++) System.out.print(books[i]);		
		System.out.println();
		FileScanner.nextLine();
	}
	
	public void addMember() {
		String MemberType=  FileScanner.next();
		
		
		if(MemberType.equals("A")) {
			lastMember++;
			members[lastMember-1]=new Academic(lastMember);
		}
			
		
		if(MemberType.equals("S")) {
			lastMember++;
			members[lastMember-1]=new Student(lastMember);
		}
			
		for(int i =0;i<10;i++) System.out.print(members[i]);		
		System.out.println();
		FileScanner.nextLine();
	}
	
	 public void borrowBook(int Tick) { // sadece printedlar borrowlanabilir 
		// !!! checkleri ekle, �uan hi� check yokk WP grubundakileri dikkate al
			 
		int borrowedBookID=FileScanner.nextInt();
		int borrowerID=FileScanner.nextInt();
		// casting yapmay� unutma !!!!
	if(borrowedBookID<=lastBook && borrowerID<=lastMember)	if(getBookByID(borrowedBookID) instanceof Printed){
			
			Printed choosenBook= (Printed)  books[borrowedBookID] ;
			
			LibraryMember who=getMemberByID(borrowerID);
			
			if( choosenBook.getIsTaken()==false ) {
				
				int debt=0; //bor�
				for(int i =0;i<who.getTheHistory().size();i++) {
					who.getTheHistory().get(i).
					
					
				}
				
				
				
				
				choosenBook.borrowBook(members[borrowerID],Tick);
			}
		}
		
		FileScanner.nextLine();
	}
	
	
	
	
	public void returnBook(int Tick) {
		int borrowedBookID=FileScanner.nextInt();
		int borrowerID=FileScanner.nextInt();
		// casting yapmay� unutma !!!!
		Printed choosenBook= (Printed)  books[borrowedBookID] ;
		
		if(choosenBook.deadLine<Tick) {
			this.totalFee+=Tick-choosenBook.deadLine;
		}
		choosenBook.returnBook(members[borrowerID]);
		
		
		FileScanner.nextLine();
	}
	
	
	public void extendBook(int Tick) {
		int borrowedBookID=FileScanner.nextInt();
		int borrowerID=FileScanner.nextInt();
		// casting yapmay� unutma !!!!
		Printed choosenBook= (Printed)  books[borrowedBookID] ;
		
		if(choosenBook.deadLine<Tick) {
			choosenBook.extend(members[borrowerID], Tick);
		}
		
		
		
	}
	
	public void readInLibrary() {
		int borrowedBookID=FileScanner.nextInt();
		int borrowerID=FileScanner.nextInt();
		// casting yapmay� unutma !!!!    BUNU IKISI DE OKUYABILIR
		Printed choosenBook= (Printed)  books[borrowedBookID] ;
		LibraryMember theMember=members[borrowerID];
		
		choosenBook.readBook(theMember);
	}
	
	
	
	
	
	
	
	public Book[] getBooks() {
		return books;
		
	}
	
	public LibraryMember[] getMembers() {
		return members;
	}
	
	public int getTotalFee() {
		return totalFee;
		
	}
	
}