import java.awt.Graphics;  
import java.awt.Graphics2D;  
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;  
import java.awt.image.BufferedImage;  
import java.io.File;  
import javax.imageio.ImageIO;  
import javax.swing.JFrame;  
  
public class GUI extends JFrame {  
 private int num;  
 private final int WIDTH  = 480;  
 private final int HEIGHT = 320;  
   
 public GUI(int num){  
  this.num = num;  
  this.addWindowListener(new WindowAdapter(){  
   public void windowClosing(WindowEvent e){  
    System.exit(0);  
   }  
  });  
  
  this.setBounds(0, 0, WIDTH, HEIGHT);  
  this.setLocation(num/3*WIDTH, num%3*HEIGHT);  
  this.setVisible(true);  
 }  
  
 public void paint(Graphics g){  
  Graphics2D g2 = (Graphics2D)g;  
  BufferedImage readImage = null;  
  try {  
   readImage = ImageIO.read(new File(num + ".jpg"));  
  } catch (Exception e) {  
   e.printStackTrace();  
   readImage = null;  
  }  
  if (readImage != null){  
   g2.drawImage(readImage, 0, 0, WIDTH, HEIGHT, this);  
  }  
 }  
}  