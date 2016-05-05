import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class Part2 {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("inventory.txt")));
			ArrayList<String> list = new ArrayList<String>();
			
			while (reader.ready()) {
				list.add(reader.readLine().split(",")[0]);
			}
			
			JFrame frame = new JFrame("Inventory Sort");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel btnPanel = new JPanel();
			btnPanel.setLayout(new FlowLayout());
			
			JButton insertSortBtn = new JButton("Insertion Sort");
			JButton mergeSortBtn = new JButton("Merge Sort");
			JButton quickSortBtn = new JButton("Quick Sort");
			
			JTextArea textArea = new JTextArea();
			textArea.setRows(10);
			
			JScrollPane scrollArea = new JScrollPane(textArea);
			
			insertSortBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String[] array = Arrays.copyOf(list.toArray(), list.size(), String[].class);
					textArea.setText(textArea.getText() + "Performing Insertion Sort...\n");
					long startTime = System.nanoTime();
					InsertionSort.Sort(array, array.length);
					long endTime = System.nanoTime();
					textArea.setText(textArea.getText() + "Insertion Sort completed in " + (endTime - startTime) + " nanoseconds\n\n");
				}
			});
			
			mergeSortBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String[] array = Arrays.copyOf(list.toArray(), list.size(), String[].class);
					textArea.setText(textArea.getText() + "Performing Merge Sort...\n");
					long startTime = System.nanoTime();
					MergeSort.Sort(array);
					long endTime = System.nanoTime();
					textArea.setText(textArea.getText() + "Merge Sort completed in " + (endTime - startTime) + " nanoseconds\n\n");
				}
			});
			
			quickSortBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String[] array = Arrays.copyOf(list.toArray(), list.size(), String[].class);
					textArea.setText(textArea.getText() + "Performing Quick Sort...\n");
					long startTime = System.nanoTime();
					QuickSort.Sort(array);
					long endTime = System.nanoTime();
					textArea.setText(textArea.getText() + "Quick Sort completed in " + (endTime - startTime) + " nanoseconds\n\n");
				}
			});
			
			btnPanel.add(insertSortBtn);
			btnPanel.add(mergeSortBtn);
			btnPanel.add(quickSortBtn);
			
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.add(btnPanel);
			panel.add(scrollArea);
			
			frame.getContentPane().add(panel);
			frame.pack();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
