package lab1.part1;

public class ReadingMaterial {
	String title;	//< The title of the reading material
	String author;	//< The author of the reading material
	int numPages;	//< The number of pages in the reading material
	
	public ReadingMaterial(String title, String author, int numPages) {
		this.title = title;
		this.author = author;
		this.numPages = numPages;
	}
	
	public boolean isLong() {
		return numPages > 250;
	}
	
	public void summary() {
		System.out.println(this.title + ", written by " + this.author);
	}
}