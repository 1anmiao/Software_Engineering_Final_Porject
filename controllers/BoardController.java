package tetris.controllers;

import tetris.models.Shape;
import tetris.views.TetrisBoard;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;

/**
 * Created by saacsos on 1/12/2559.
 * http://zetcode.com/tutorials/javagamestutorial/tetris/
 */
public class BoardController {
    private TetrisBoard tetrisBoard;
    private int boardWidth;
    private int boardHeight;
    private boolean isFallingFinished = false;
    private boolean isStarted = false;
    private boolean isPaused = false;
    private int numLinesRemoved = 0;
    private int currentX = 0;
    private int currentY = 0;
    private Timer timer;
    private Shape currentPiece;
    private Shape.Tetrominoes[] board;
    ContinuousAudioDataStream BGMsound = null;
    String path1 = "C:\\Users\\user\\Downloads\\audio\\remove.wav";
    String path2 = "C:\\Users\\user\\Downloads\\audio\\GameOver.wav";
    String path3 = "C:\\Users\\user\\Downloads\\audio\\BGM.wav";
    
    //
    AudioStream sound = null;
    public void ImportSound(String path)
    {
    	try{@SuppressWarnings("resource")
		AudioStream importsound = new AudioStream(new FileInputStream(path));
    	sound = importsound;}catch (Exception e) {
    		sound = null;
            e.printStackTrace();
        }
    }
    //

    public BoardController(int boardWidth, int boardHeight, TetrisBoard tetrisBoard) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.tetrisBoard = tetrisBoard;
        currentPiece = new Shape();
        timer = new Timer(400, tetrisBoard);
        timer.start();
        board = new Shape.Tetrominoes[boardWidth * boardHeight];

        clearBoard();
    }

    public void gameAction() {
        if (isFallingFinished) {
            isFallingFinished = false;
            newPiece();
        } else {
            oneLineDown();
        }
    }

    public boolean isStarted() {
        return isStarted;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public boolean isCurrentPieceNoShaped() {
        return currentPiece.getPieceShape() == Shape.Tetrominoes.NoShape;
    }

    public void start() {
    	//
    	try{@SuppressWarnings("resource")
		ContinuousAudioDataStream sound = new ContinuousAudioDataStream(new AudioStream(new FileInputStream(path3)).getData());
    	BGMsound = sound;
    	AudioPlayer.player.start(BGMsound);}catch (Exception e) {
            e.printStackTrace();
        }
    	//
        if (isPaused) return;
        isStarted = true;
        isFallingFinished = false;
        numLinesRemoved = 0;
        clearBoard();
        newPiece();
        timer.start();

    }

    public void pause() {
        if (!isStarted)
            return;

        isPaused = !isPaused;
        if (isPaused) {
            timer.stop();
            tetrisBoard.setStatusText("paused");
        } else {
            timer.start();
            tetrisBoard.setStatusText(String.valueOf(numLinesRemoved));
        }
        tetrisBoard.repaint();
    }

    public void oneLineDown()
    {
        if (!tryMove(currentPiece, currentX, currentY - 1))
            pieceDropped();
    }

    private void clearBoard()
    {
        for (int i = 0; i < boardHeight * boardWidth; ++i)
            board[i] = Shape.Tetrominoes.NoShape;
    }

    public void dropDown()
    {
        int newY = currentY;
        while (newY > 0) {
            if (!tryMove(currentPiece, currentX, newY - 1))
                break;
            --newY;
        }
        pieceDropped();
    }

    private Shape.Tetrominoes shapeAt(int x, int y) {
        return board[(y * boardWidth) + x];
    }

    public void paint(Graphics g, double width, double height) {
        int squareWidth = (int) width / boardWidth;
        int squareHeight = (int) height / boardHeight;
        int boardTop = (int) height - boardHeight * squareHeight;


        for (int i = 0; i < boardHeight; ++i) {
            for (int j = 0; j < boardWidth; ++j) {
                tetris.models.Shape.Tetrominoes shape = shapeAt(j, boardHeight - i - 1);
                if (shape != tetris.models.Shape.Tetrominoes.NoShape)
                    tetrisBoard.drawSquare(g, j * squareWidth,
                            boardTop + i * squareHeight, shape);
            }
        }

        if (currentPiece.getPieceShape() != tetris.models.Shape.Tetrominoes.NoShape) {
            for (int i = 0; i < 4; ++i) {
                int x = currentX + currentPiece.x(i);
                int y = currentY - currentPiece.y(i);
                tetrisBoard.drawSquare(g, x * squareWidth,
                        boardTop + (boardHeight - y - 1) * squareHeight,
                        currentPiece.getPieceShape());
            }
        }
    }

    //@SuppressWarnings("null")
	private void newPiece()
    {
        currentPiece.setRandomShape();
        currentX = boardWidth / 2 + 1;
        currentY = boardHeight - 1 + currentPiece.minY();
        //
        JDialog f = new JDialog();
        //
        if (!tryMove(currentPiece, currentX, currentY)) {
            currentPiece.setPieceShape(Shape.Tetrominoes.NoShape);
            timer.stop();
            isStarted = false;
            //
            AudioPlayer.player.stop(BGMsound);
            ImportSound(path2);
        	if(sound != null)
        	{
        		AudioPlayer.player.start(sound);
        	}
            JOptionPane.showMessageDialog(f,"you've removed "+numLinesRemoved+" lines.",
                    "GameOver.", JOptionPane.INFORMATION_MESSAGE);
            //
            tetrisBoard.setStatusText("game over, you've removed "+numLinesRemoved+" lines.");
        }
    }

    private boolean tryMove(Shape newPiece, int newX, int newY)
    {
        for (int i = 0; i < 4; ++i) {
            int x = newX + newPiece.x(i);
            int y = newY - newPiece.y(i);
            if (x < 0 || x >= boardWidth || y < 0 || y >= boardHeight)
                return false;
            if (shapeAt(x, y) != Shape.Tetrominoes.NoShape)
                return false;
        }
        currentPiece = newPiece;
        currentX = newX;
        currentY = newY;
        tetrisBoard.repaint();
        
        return true;
    }

    private void pieceDropped()
    {
        for (int i = 0; i < 4; ++i) {
            int x = currentX + currentPiece.x(i);
            int y = currentY - currentPiece.y(i);
            board[(y * boardWidth) + x] = currentPiece.getPieceShape();
        }

        removeFullLines();

        if (!isFallingFinished)
            newPiece();
    }

    private void removeFullLines()
    {
        int numFullLines = 0;

        for (int i = boardHeight - 1; i >= 0; --i) {
            boolean lineIsFull = true;

            for (int j = 0; j < boardWidth; ++j) {
                if (shapeAt(j, i) == Shape.Tetrominoes.NoShape) {
                    lineIsFull = false;
                    break;
                }
            }

            if (lineIsFull) {
                ++numFullLines;
                for (int k = i; k < boardHeight - 1; ++k) {
                    for (int j = 0; j < boardWidth; ++j)
                        board[(k * boardWidth) + j] = shapeAt(j, k + 1);
                }
            }
        }

        if (numFullLines > 0) {
        	ImportSound(path1);
        	if(sound != null)
        	{
        		AudioPlayer.player.start(sound);
        	}
        	numLinesRemoved += numFullLines;
            tetrisBoard.setStatusText(String.valueOf(numLinesRemoved));
            isFallingFinished = true;
            currentPiece.setPieceShape(Shape.Tetrominoes.NoShape);
            tetrisBoard.repaint();
        }
    }

	public void moveLeft() {
        tryMove(currentPiece, currentX - 1, currentY);
    }
    public void moveRight() {
        tryMove(currentPiece, currentX + 1, currentY);
    }
    public void rotateLeft() {
        tryMove(currentPiece.rotateLeft(), currentX, currentY);
    }
    public void rotateRight() {
        tryMove(currentPiece.rotateRight(), currentX, currentY);
    }
}