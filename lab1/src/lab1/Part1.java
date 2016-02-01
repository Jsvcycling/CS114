package lab1;

class ReadingMaterial {
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

class Article extends ReadingMaterial {
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

class Novel extends ReadingMaterial {
	String[] characters;

	public Novel(String title, String author, int numPages, String[] characters) {
		super(title, author, numPages);
		
		this.characters = characters;
	}

	public void listCharacters() {
		for (String character : characters) {
			System.out.println(character);
		}
	}
}

class GraphicNovel extends Novel {
	String illustrator;

	public GraphicNovel(String title, String author, int numPages, String[] characters, String illustrator) {
		super(title, author, numPages, characters);
		
		this.illustrator = illustrator;
	}

	@Override
	public void summary() {
		System.out.println(this.title + ", written by " + this.author + ", illustrated by " + this.illustrator);
	}
}

public class Part1 {
	public static void main(String[] args) {
		Novel harryPotter = new Novel("Harry Potter", "JK Rowling", 303, new String[]{
			"Harry Potter",
			"Hermione Granger",
			"Ronald Weasley",
			"Voldemort"
		});
		
		GraphicNovel avengers = new GraphicNovel("Avengers", "Stan Lee", 50, new String[]{
			"Iron Man",
			"Captain America",
			"Black Widow",
			"The Hulk",
			"Thor"
		}, "Jack Kirby");
		
		Article pc = new Article("The Social Meaning of the Personal Computer", "Bryan Pfaffenberger", 10, "Anthropological Quarterly");
		
		harryPotter.summary();
		System.out.println(harryPotter.isLong());
		
		avengers.listCharacters();
		avengers.summary();
		
		System.out.println(pc.isLong());
		pc.summary();
	}
}
