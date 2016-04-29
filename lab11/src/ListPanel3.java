import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.*;
import javax.swing.event.*;

public class ListPanel3 extends JPanel {
	private JTextArea textArea;
	private String filename;
	private JList list;
	
	public ListPanel3(JTextArea text) {
		textArea = text;
		
		String[] fileNames = {
			"njit_lab.txt",
			"test_file1.txt",
			"test_file2.txt",
			"hello_world.txt"
		};
		
		list = new JList(fileNames);
		list.addListSelectionListener(new ListListener());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		add(scrollPane);
		setBackground(Color.white);
		setPreferredSize(new Dimension(200, 100));
	}
	
	public String getFilename() {
		return filename;
	}
	
	private class ListListener implements ListSelectionListener {
		public void valueChanged(javax.swing.event.ListSelectionEvent e) {
			if (list.isSelectionEmpty()) {
				textArea.setText(null);
				filename = "";
			} else {
				try {
					String fileName = (String)list.getSelectedValue();
					byte[] byteText;
					byteText = Files.readAllBytes(Paths.get(fileName));
					textArea.setText(new String(byteText));
					filename = fileName;
				} catch (Exception e1) {
					textArea.setText("");
					filename = "";
				}
			}
		};
	}
}
