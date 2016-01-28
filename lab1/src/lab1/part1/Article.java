package lab1.part1;

public class Article extends ReadingMaterial {
	String publication;

	public Article(String title, String author, int numPages, String publication) {
		super(title, author, numPages);
		
		this.publication = publication;
	}
	
	@Override
	public void summary() {
		System.out.println(this.title + ", written by " + this.author + ", published in " + this.publication);
	}
}
