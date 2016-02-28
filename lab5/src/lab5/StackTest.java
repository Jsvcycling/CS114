///** Source code example for "A Practical Introduction to Data
//    Structures and Algorithm Analysis, 3rd Edition (Java)" 
//    by Clifford A. Shaffer
//    Copyright 2008-2011 by Clifford A. Shaffer
//*/
//
///** A JUnit test class for stacks. */
//
//package lab5;
//
//import java.io.*;
//
//public class StackTest
//    extends junit.framework.TestCase
//{
//  private Stack<Integer> S1;
//  private Stack<Integer> S2;
//
//  /**
//   * This method is automatically called once before each test case method,
//   * so that all the variables are cleanly initialized for each test.
//   */
//  public void setUp()
//  {
//    S1 = new AStack<Integer>();
//    S2 = new AStack<Integer>(15);
//  }
//
//  public void testGeneral() {
//  System.out.println("Initial S2 string "+S2.toString());
//    S2.push(10);
//    S2.push(20);
//    S2.push(15);
//    System.out.println(S2.toString());
//
//    while(S2.length() > 0)
//      S1.push(S2.pop());
//    System.out.println("Push S2 string to S1 string after pop S2 one at a time. The S1 string is "+S1.toString());
//    System.out.println("Final S2 string is "+S2.toString());
//  }
//
//}
//class TestAstack {
//
//public static void main(String arg[])
//
//{
//  
//  StackTest s = new StackTest();
//  s.setUp();
//  s.testGeneral();
// }
//
//}