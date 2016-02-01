package lab1;

import java.util.Scanner;

interface Speaker {
	public void speak();
	public void announce(String str);
}

class SpeakerOfTheHouse implements Speaker {
	@Override
	public void speak() {
		System.out.println("I am Speaker of the House.");
	}

	@Override
	public void announce(String str) {
		System.out.println("The " + str + " has passed!");
	}
}

class SportsAnnouncer implements Speaker {
	@Override
	public void speak() {
		System.out.println("Goal!");
	}

	@Override
	public void announce(String str) {
		System.out.println("The " + str + " have scored a goal!");
	}
}

class Actor implements Speaker {
	@Override
	public void speak() {
		System.out.println("I've been nominated for three Academy Awards.");
	}

	@Override
	public void announce(String str) {
		System.out.println("I'm currently staring in " + str);
	}
}

public class Part2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter the name of a bill: ");
		String nameOfBill = scanner.next();
		
		System.out.print("Please enter the name of a sports team: ");
		String nameOfTeam = scanner.next();
		
		System.out.print("Please enter the name of a movie: ");
		String nameOfMovie = scanner.next();
		
		SpeakerOfTheHouse speakerOfTheHouse = new SpeakerOfTheHouse();
		SportsAnnouncer sportsAnnouncer = new SportsAnnouncer();
		Actor actor = new Actor();
		
		speakerOfTheHouse.speak();
		speakerOfTheHouse.announce(nameOfBill);
		
		sportsAnnouncer.speak();
		sportsAnnouncer.announce(nameOfTeam);
		
		actor.speak();
		actor.announce(nameOfMovie);
	}
}
