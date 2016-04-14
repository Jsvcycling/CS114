package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class DomainBlocker
{
	private TreeSet<String> blockedSet;
	
	public DomainBlocker() throws FileNotFoundException
	{
		blockedSet = new TreeSet<String>();
		
		File inputFile = new File("test.txt");
		Scanner scan = new Scanner(inputFile);
		
		while (scan.hasNextLine())
		{
			blockedSet.add(scan.nextLine().split(",")[0]);
		}
	}
	
	public boolean domainIsBlocked(String domain)
	{
		return blockedSet.contains(domain);
	}
}
