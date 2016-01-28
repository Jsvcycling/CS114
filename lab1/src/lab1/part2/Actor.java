package lab1.part2;

public class Actor implements Speaker {
	@Override
	public void speak() {
		System.out.println("I've been nominated for three Academy Awards.");
	}

	@Override
	public void announce(String str) {
		System.out.println("I'm currently staring in " + str);
	}
}
