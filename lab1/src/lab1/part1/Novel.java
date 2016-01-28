package lab1.part1;

public class Novel extends ReadingMaterial {
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
