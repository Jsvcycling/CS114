package lab1.part2;

import java.util.Scanner;

public class Driver {
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
