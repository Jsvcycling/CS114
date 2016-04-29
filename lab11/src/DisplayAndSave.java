import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class DisplayAndSave {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Display and Save");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea textArea = new JTextArea();
		JScrollPane filePanel = new JScrollPane(textArea);
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
		filePanel.setBackground(Color.white);
		filePanel.setPreferredSize(new Dimension(300, 200));
		
		ListPanel3 fileList = new ListPanel3(textArea);
		
		JButton saveButton = new JButton("Save");
		saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String filename = fileList.getFilename();
					
					if (!filename.equals("")) {
						BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)));
						writer.write(textArea.getText());
						writer.close();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		leftPanel.add(fileList);
		leftPanel.add(saveButton);
		
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
		                               leftPanel, filePanel);
		
		sp.setOneTouchExpandable(true);
		
		frame.getContentPane().add(sp);
		frame.pack();
		frame.setVisible(true);
	}
}
