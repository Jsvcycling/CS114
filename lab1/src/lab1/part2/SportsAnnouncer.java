package lab1.part2;

public class SportsAnnouncer implements Speaker {
	@Override
	public void speak() {
		System.out.println("Goal!");
	}

	@Override
	public void announce(String str) {
		System.out.println("The " + str + " have scored a goal!");
	}
}
