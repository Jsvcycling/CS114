package lab7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DomainChecker
{
	public static void main(String[] args) throws FileNotFoundException
	{
		DomainBlocker blocker = new DomainBlocker();
		Scanner scan = new Scanner(System.in);

		String domain;

		do
		{
			System.out.print("Enter a domain (DONE to quit): ");
			domain = scan.nextLine();

			if (!domain.equalsIgnoreCase("DONE"))
			{
				if (blocker.domainIsBlocked(domain))
					System.out.println("The employee was found.");
				else
					System.out.println("The exployee does not exist.");
			}
		} while (!domain.equalsIgnoreCase("DONE"));
	}
}
