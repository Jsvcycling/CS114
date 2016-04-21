//********************************************************************
//  EmailGUI.java    
//
//********************************************************************

package lab10;

import java.util.HashMap;

import javax.swing.JFrame;

public class EmailGUI
{
   //-----------------------------------------------------------------
   //  Creates and displays the GUI.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
	  HashMap map = new HashMap();
	  
	  EmailGUIPanel panel = new EmailGUIPanel(map);
      JFrame frame = new JFrame ("Prototype Email GUI");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(panel);
      frame.pack();
      frame.setVisible(true);
   }
}
