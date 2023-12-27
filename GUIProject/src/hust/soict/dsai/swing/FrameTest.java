package hust.soict.dsai.swing;

import java.awt.*;
public class FrameTest extends Frame {
public FrameTest() {
           add (new Button("First"));
           add (new Button("Second"));
           add (new Button("Third"));
           pack(); 
           setVisible(true);
     }
public static void main(String args []) 
          { new FrameTest(); }
       }