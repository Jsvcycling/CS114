

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListPanel2 extends JPanel
{
   private JLabel label;
   private JList list;

   //-----------------------------------------------------------------
   //  Loads the list of image names into the list.
   //-----------------------------------------------------------------
   public ListPanel2 (JLabel imageLabel)
   {
      label = imageLabel;

      String[] fileNames = { "cactus.jpg",
                             "circuit.gif",
                             "duckkey.jpg",
                             "duke.gif",
                             "hammock.gif",
                             "justin.jpg",
                             "kayak.jpg",
                             "kayla.jpg",
                             "tiger.jpg",
                             "toucan.gif",
                             "worldmap.gif" };

      list = new JList (fileNames);
      list.addListSelectionListener (new ListListener());
      list.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);

      JScrollPane scrollPane = new JScrollPane(list);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

      add (scrollPane);
      setBackground (Color.white);
      setPreferredSize (new Dimension(200, 200));
   }

   //*****************************************************************
   //  Represents the listener for the list of images.
   //*****************************************************************
   private class ListListener implements ListSelectionListener
   {
      public void valueChanged (ListSelectionEvent event)
      {
         if (list.isSelectionEmpty())
            label.setIcon (null);
         else
         {
            String fileName = (String)list.getSelectedValue();
            ImageIcon image = new ImageIcon (fileName);
            label.setIcon (image);
         }
      }
   }
}
