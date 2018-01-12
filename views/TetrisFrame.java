package tetris.views;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
//****************

import java.applet.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.*;//for ImageIO.read
import java.net.*;//for URL
import java.io.*;//for catch (IOException e),File,InputStream, BufferedInputStream,and FileInputStream ect

public class TetrisFrame extends JFrame {
    private JLabel statusBar;
    private TetrisBoard board;
    
    private int boardWidth = 200;//200
    private int boardHeight = 400;//400

    public void setBoard(int n){
        boardWidth *= n;
        boardHeight *= n;
    }

    public TetrisFrame() {
        statusBar = new JLabel(" 0");
        //board = new AnsonView(this);
        //board = new JustinView(this);
        //board = new NeilnView(this);
        board = new EGView(this);
    }
   
    public void img (){
    	 Image image1 = null;
    	 Image image2 = null;
    	 Image image3 = null;
 	    try {
 	       
 	       File sourceimage2 = new File("image/east.jpg");
 	      File sourceimage3 = new File("image/west.jpg");
 	      
 	       image2 = ImageIO.read(sourceimage2);
 	      image3 = ImageIO.read(sourceimage3);
 	       
 	        InputStream is = new BufferedInputStream(new FileInputStream("C:\\Users\\joe85\\Downloads\\3.jpg"));  
 	      
 	    
 	        // Read from a URL
 	        URL url = new URL("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=278194393,1455705492&fm=27&gp=0.jpg");
 	       // image = ImageIO.read(url);
 	    } catch (IOException e) {
 	    	e.printStackTrace();
 	    }
 	    
 	   
 	   JLabel label2 = new JLabel(new ImageIcon(image2));
 	  JLabel label3 = new JLabel(new ImageIcon(image3));
 	  
 	   this.getContentPane().add(label2, BorderLayout.EAST);
 	  this.getContentPane().add(label3, BorderLayout.WEST);
 	    this.pack();
 	    this.setVisible(true); 
 	    
 	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	     }
    
    public void init() {
    	JDialog f = new JDialog();
    	JOptionPane.showMessageDialog(f,"Start.",
                "Welcome to Tetris.", JOptionPane.INFORMATION_MESSAGE);
        setLayout(new BorderLayout());
        add(statusBar, BorderLayout.SOUTH);
        add(board, BorderLayout.CENTER);
        
        img();
        board.start();
        setSize(boardWidth, boardHeight);
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setTitle("Tetris");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setResizable(false);

    }

    JLabel getStatusBar() {
        return statusBar;
    }
    
}
