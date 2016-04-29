

import java.awt.*;
import javax.swing.*;

public class PickImage2
{
   //-----------------------------------------------------------------
   //  Creates and displays a frame containing a split pane. The
   //  user selects an image name from the list to be displayed.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Pick Image 2");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      JLabel imageLabel = new JLabel();
      JScrollPane imagePanel = new JScrollPane(imageLabel);
      imagePanel.setBackground (Color.white);
      imagePanel.setPreferredSize (new Dimension(300, 200));

      ListPanel2 imageList = new ListPanel2 (imageLabel);

      JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                     imageList, imagePanel);

      sp.setOneTouchExpandable (true);

      frame.getContentPane().add (sp);
      frame.pack();
      frame.setVisible(true);
   }
}
