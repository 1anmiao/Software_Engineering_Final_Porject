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

    void start() {
    }

    public void actionPerformed1(ActionEvent e) {
    }

    public void paint(Graphics g) {
    }

    private int squareWidth() { return 0; }
    private int squareHeight() { return 0; }

    public void drawSquare(Graphics g, int x, int y, tetris.models.Shape.Tetrominoes shape)
    {
    }

    public void setStatusText(String text) {
    }

    private class TAdapter extends KeyAdapter {
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
}
