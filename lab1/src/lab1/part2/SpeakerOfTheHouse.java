package lab1.part2;

public class SpeakerOfTheHouse implements Speaker {
	@Override
	public void speak() {
		System.out.println("I am Speaker of the House.");
	}

	@Override
	public void announce(String str) {
		System.out.println("The " + str + " has passed!");
	}
}
