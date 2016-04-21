//********************************************************************
//  EmailGUIPanel.java       
//
//********************************************************************

package lab10;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;

public class EmailGUIPanel extends JPanel
{
   private EmailFieldPanel toPanel, ccPanel, bccPanel, subjectPanel, searchPanel;
   private EmailFieldPanel messagePanel;
   private JLabel resultLabel, searchLabel;
   private JButton sendButton, searchButton;
   
   private HashMap map;

   //-----------------------------------------------------------------
   //  Constructor: Sets up the main GUI components.
   //-----------------------------------------------------------------
   public EmailGUIPanel(HashMap map)
   {
      toPanel = new EmailFieldPanel("To:", 30);
      ccPanel = new EmailFieldPanel("CC:", 30);
      bccPanel = new EmailFieldPanel("BCC:", 30);
      subjectPanel = new EmailFieldPanel("Subject:", 30);
      messagePanel = new EmailFieldPanel("Message:", 30);
      resultLabel = new JLabel ("Messages saved: " + map.size());
      
      sendButton = new JButton("Save");
      sendButton.addActionListener(new SaveListener());
      
      searchPanel = new EmailFieldPanel("Search by Subject:", 30);
      searchLabel = new JLabel("------");
      
      searchButton = new JButton("Search");
      searchButton.addActionListener(new SearchListener());

      add(toPanel);
      add(ccPanel);
      add(bccPanel);
      add(subjectPanel);
      add(messagePanel);
      add(sendButton);
      add(resultLabel);
      add(searchPanel);
      add(searchButton);
      add(searchLabel);

      setPreferredSize (new Dimension(500, 400));
      setBackground (Color.yellow);
      
      this.map = map;
   }
   
   private class EmailItem
   {
	  public String to;
	  public String cc;
	  public String bcc;
	  public String subject;
	  public String message;
   }

   //*****************************************************************
   //  Represents an action listener for the send button.
   //*****************************************************************
   private class SaveListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Prints the field information to standard output.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
    	 if (map.size() >= 4) {
    		 resultLabel.setText("Too many messages.");
    	 } else {
	         System.out.println("To: " + toPanel.getFieldText());
	         System.out.println("CC: " + ccPanel.getFieldText());
	         System.out.println("BCC: " + bccPanel.getFieldText());
	         System.out.println("Subject: " + subjectPanel.getFieldText());
	         System.out.println("Message: " + messagePanel.getFieldText());
	         
	         EmailItem item = new EmailItem();
	         
	         item.to = toPanel.getFieldText();
	         item.cc = ccPanel.getFieldText();
	         item.bcc = bccPanel.getFieldText();
	         item.subject = subjectPanel.getFieldText();
	         item.message = messagePanel.getFieldText();
	         
	         map.put(subjectPanel.getFieldText(), item);
	         
	         resultLabel.setText("Messages saved: " + map.size());
    	 }
      }
   }
   
   private class SearchListener implements ActionListener
   {
	  public void actionPerformed(ActionEvent event)
	  {
		 EmailItem item = (EmailItem) map.get(searchPanel.getFieldText());
		 if (item == null) {
			 searchLabel.setText("Message not found");
		 } else {
			 searchLabel.setText("Messsage found");
		 }
	  }
   }
}
