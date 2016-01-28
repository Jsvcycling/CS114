package lab1.part1;

public class GraphicNovel extends Novel {
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
