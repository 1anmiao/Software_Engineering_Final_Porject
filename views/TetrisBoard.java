package tetris.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;


public abstract class TetrisBoard extends JPanel implements ActionListener {
//    private final int BOARD_WIDTH = 10;
//    private final int BOARD_HEIGHT = 22;
//    private JLabel statusBar;

//    private BoardController controller;



    void start() {
//        controller.start();
    }

    public void actionPerformed1(ActionEvent e) {
//        controller.gameAction();
    }

    public void paint(Graphics g) {
//        super.paint(g);
//        controller.paint(g, getSize().getWidth(), getSize().getHeight());

    }

    private int squareWidth() { return 0; }
    private int squareHeight() { return 0; }

    public void drawSquare(Graphics g, int x, int y, tetris.models.Shape.Tetrominoes shape)
    {
    }

    public void setStatusText(String text) {
//        statusBar.setText(text);
    }

    private class TAdapter extends KeyAdapter {
//        public void keyPressed(KeyEvent e) {
//
//            if (!controller.isStarted() || controller.isCurrentPieceNoShaped()) {
//                return;
//            }
//
//            int keycode = e.getKeyCode();
//
//            if (keycode == 'p' || keycode == 'P') {
//                controller.pause();
//                return;
//            }
//
//            if (controller.isPaused())
//                return;
//
//            switch (keycode) {
//                case KeyEvent.VK_LEFT:
//                    controller.moveLeft();
//                    break;
//                case KeyEvent.VK_RIGHT:
//                    controller.moveRight();
//                    break;
//                case KeyEvent.VK_DOWN:
//                    controller.rotateRight();
//                    break;
//                case KeyEvent.VK_UP:
//                    controller.rotateLeft();
//                    break;
//                case KeyEvent.VK_SPACE:
//                    controller.dropDown();
//                    break;
//                case 'd':
//                    controller.oneLineDown();
//                    break;
//                case 'D':
//                    controller.oneLineDown();
//                    break;
//            }
//
//        }
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
