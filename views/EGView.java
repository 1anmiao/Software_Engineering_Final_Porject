package tetris.views;

import tetris.controllers.BoardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//***************************

//**************************
public class EGView extends TetrisBoard {
    private final int BOARD_WIDTH = 5;
    private final int BOARD_HEIGHT = 10;
    private JLabel statusBar;

    private BoardController controller;


    EGView(TetrisFrame parent) {
    	
    	parent.setBoard(1);
        setFocusable(true);
        setOpaque(false);
        parent.getContentPane().setBackground(Color.ORANGE);
        //setBackground(Color.gray);
        controller = new BoardController(BOARD_WIDTH, BOARD_HEIGHT, this);
        statusBar = parent.getStatusBar();
        addKeyListener(new TAdapter());
        
    }
    
   
    
    void start() {
        controller.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.gameAction();
    }

    public void paint(Graphics g) {
        super.paint(g);
        controller.paint(g, getSize().getWidth(), getSize().getHeight());

    }

    private int squareWidth() { return (int) getSize().getWidth() / BOARD_WIDTH; }
    private int squareHeight() { return (int) getSize().getHeight() / BOARD_HEIGHT; }

    public void drawSquare(Graphics g, int x, int y, tetris.models.Shape.Tetrominoes shape)
    {
        Color colors[] = { new Color(255, 200, 171), new Color(100, 255, 171), 
            new Color(255, 255, 171), new Color(255, 100, 171), 
            new Color(255, 255, 171), new Color(255, 255, 171), 
            new Color(255, 255, 171), new Color(255, 255, 55), 
        };


        Color color = colors[shape.ordinal()];

        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + 1);
    }

    public void setStatusText(String text) {
        statusBar.setText(text);
    }

    private class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {

            if (!controller.isStarted() || controller.isCurrentPieceNoShaped()) {
                return;
            }

            int keycode = e.getKeyCode();

            if (keycode == 'p' || keycode == 'P') {
                controller.pause();
                return;
            }

            if (controller.isPaused())
                return;

            switch (keycode) {
                case KeyEvent.VK_LEFT:
                case 'a':
                case 'A':
                    controller.moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                case 'd':
                case 'D':
                    controller.moveRight();
                    break;
                case KeyEvent.VK_DOWN:
                case 's':
                case 'S':
                    controller.rotateRight();
                    break;
                case KeyEvent.VK_UP:
                case 'w':
                case 'W':
                    controller.rotateLeft();
                    break;
                case KeyEvent.VK_SPACE:
                    controller.dropDown();
                    break;
                case 'x':
                    controller.oneLineDown();
                    break;
                case 'X':
                    controller.oneLineDown();
                    break;
            }

        }
    }
    
    
}

