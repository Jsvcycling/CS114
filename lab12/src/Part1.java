import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Part1 {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("inventory.txt")));
			ArrayList<String> list = new ArrayList<String>();
			
			while (reader.ready()) {
				list.add(reader.readLine().split(",")[0]);
			}
			
			// Do insertion sort
			String[] insertionSortArray = Arrays.copyOf(list.toArray(), list.size(), String[].class);
			System.out.println("Performing Insertion Sort...");
			long startTime = System.nanoTime();
			InsertionSort.Sort(insertionSortArray, insertionSortArray.length);
			long endTime = System.nanoTime();
			
			System.out.println("Insertion Sort completed in " + (endTime - startTime) + " nanoseconds");
			
			System.out.println();
			
			// Do merge sort
			String[] mergeSortArray = Arrays.copyOf(list.toArray(), list.size(), String[].class);
			System.out.println("Performing Merge Sort...");
			startTime = System.nanoTime();
			MergeSort.Sort(mergeSortArray);
			endTime = System.nanoTime();

			System.out.println("Merge Sort completed in " + (endTime - startTime) + " nanoseconds");
			
			System.out.println();
			
			// Do quick sort
			String[] quickSortArray = Arrays.copyOf(list.toArray(), list.size(), String[].class);
			System.out.println("Performing Quick Sort...");
			startTime = System.nanoTime();
			QuickSort.Sort(quickSortArray);
			endTime = System.nanoTime();
			
			System.out.println("Quick Sort completed in " + (endTime - startTime) + " nanoseconds");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
