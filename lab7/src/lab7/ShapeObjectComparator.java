package lab7;

import java.util.Comparator;

public class ShapeObjectComparator  
     implements Comparator<Shape>, java.io.Serializable 
{ 
  public int compare(Shape o1, Shape o2) 
 {    double area1 = o1.computePerimeter();   
       double area2 = o2.computePerimeter();   
       if (area1 < area2)      
         return -1;    
       else
         if (area1 == area2)      
     return 0;    
else      
 return 1;  }
 
 }
