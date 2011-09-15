import java.io.*;  
import java.net.*;  
  
public class Main {
 private static final int PORT = 4321;  
  
 public static void main(String argv[]) {  
  System.out.println("start server");  
  int num = 0;  
  ServerSocket serverSocket = null;  

  try {
      InetAddress addr = InetAddress.getLocalHost();
      InetAddress addr2 = InetAddress.getLocalHost();
      System.out.println("Local Host Name: " + addr.getHostName());
      System.out.println("IP Address     : " + addr.getHostAddress());
  } catch (UnknownHostException e) {
      e.printStackTrace();
  }

  while(true){  
   try {  
    if(serverSocket == null) serverSocket = new ServerSocket(PORT);  
    Socket socket = serverSocket.accept();  
    BufferedOutputStream out = new BufferedOutputStream(  
       new FileOutputStream(new File(num + ".jpg")));  
    BufferedInputStream in = new BufferedInputStream(socket.getInputStream());  
    byte[] buf = new byte[1024];  
    int len;  
    while((len=in.read(buf))!=-1){  
     out.write(buf, 0, len);  
    }  
    new GUIExe(num);  
    out.flush();  
    out.close();  
    in.close();  
    System.out.println("done");  
    socket.close();  
    num++;  
   } catch(Exception e) {  
    e.printStackTrace();  
   }  
  }  
 }  
}  
  
class GUIExe extends Thread {  
 private int num;  
   
 public GUIExe(int num) {  
  this.num = num;  
  this.start();  
 }  

 public void run() {  
  new GUI(num);  
 }  
}  