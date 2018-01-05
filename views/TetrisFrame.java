package tetris.views;
import javax.swing.*;
import java.awt.*;

public class TetrisFrame extends JFrame {
    private JLabel statusBar;
    private TetrisBoard board;
    
    private int boardWidth = 200;
    private int boardHeight = 400;

    public void setBoard(int n){
        boardWidth *= n;
        boardHeight *= n;
    }

    public TetrisFrame() {
        statusBar = new JLabel(" 0");
        board = new AnsonView(this);
        //board = new JustinView(this);
        //board = new NeilnView(this);
        //board = new EGView(this);
    }

    public void init() {
        setLayout(new BorderLayout());
        add(statusBar, BorderLayout.SOUTH);
        add(board, BorderLayout.CENTER);
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
