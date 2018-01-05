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
//        Color colors[] = { new Color(0, 0, 0), new Color(204, 102, 102),
//                new Color(102, 204, 102), new Color(102, 102, 204),
//                new Color(204, 204, 102), new Color(204, 102, 204),
//                new Color(102, 204, 204), new Color(218, 170, 0)
//        };
//
//
//        Color color = colors[shape.ordinal()];
//
//        g.setColor(color);
//        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
//
//        g.setColor(color.brighter());
//        g.drawLine(x, y + squareHeight() - 1, x, y);
//        g.drawLine(x, y, x + squareWidth() - 1, y);
//
//        g.setColor(color.darker());
//        g.drawLine(x + 1, y + squareHeight() - 1,
//                x + squareWidth() - 1, y + squareHeight() - 1);
//        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
//                x + squareWidth() - 1, y + 1);
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