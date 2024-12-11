/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameboard;

import com.mycompany.javacheckers.Game;
import com.mycompany.javacheckers.Player;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author Palmer
 */
public class GameBoard extends JPanel {

    private static int BOARD_COLUMNS = 8;
    private static int BOARD_ROWS = 8;

    public void addMouseListener(GameboardMouseListener mouseAction, Game aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * 
     */
    void highlightPossibleJumps(Piece gamePiece) {
        int selectedX = gamePiece.getxCol();
        int selectedY = gamePiece.getyRow();
        
    }

    /**
     *
     */
    public void pauseGame() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        CardLayout cl = (CardLayout) parentPanel.getLayout();
        cl.next(parentPanel);
    }
    private JPanel parentPanel;

    /**
     * Get the value of parentPanel
     *
     * @return the value of parentPanel
     */
    public JPanel getParentPanel() {
        return parentPanel;
    }

    /**
     * Set the value of parentPanel
     *
     * @param parentPanel new value of parentPanel
     */
    public void setParentPanel(JPanel parentPanel) {
        this.parentPanel = parentPanel;
    }

    /**
     * @return the BOARD_COLUMNS
     */
    public static int getBOARD_COLUMNS() {
        return BOARD_COLUMNS;
    }

    /**
     * @param aBOARD_COLUMNS the BOARD_COLUMNS to set
     */
    public static void setBOARD_COLUMNS(int aBOARD_COLUMNS) {
        BOARD_COLUMNS = aBOARD_COLUMNS;
    }

    /**
     * @return the BOARD_ROWS
     */
    public static int getBOARD_ROWS() {
        return BOARD_ROWS;
    }

    /**
     * @param aBOARD_ROWS the BOARD_ROWS to set
     */
    public static void setBOARD_ROWS(int aBOARD_ROWS) {
        BOARD_ROWS = aBOARD_ROWS;
    }

    private int rows;
    private int columns;
    private int squareWidth;
    /*
     * private Graphics panelG; private Square boardSquare1; private Square
     * boardSquare2;
     */
    private Gameboard.BoardSquare[][] gameDataBoard;
    private Gameboard.GameboardResizeListener resizer;
    private Gameboard.GameboardMouseListener mouseAction;
    private int selectedPiece;
    // private JPanel checkerBoard;
    private Piece[] pieces;
    private GameboardKeyBoardListener kbAction;
    private Player userPlayer;

    /**
     * Empty Constructor
     */
    public GameBoard() {
        initComponents();
        this.setFocusable(true);
    }

    /**
     * Initializes the components of the Gameboard object
     */
    private void initComponents() {
        // this.setBackground(Color.red);
        resizer = new GameboardResizeListener();
//      mouseAction = new GameboardMouseListener(this);
        kbAction = new GameboardKeyBoardListener(this);
        //mouseAction.setBoard(this);
        //this.addMouseListener(mouseAction);
        //this.addMouseMotionListener(mouseAction);
        this.addComponentListener(resizer);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                e.getComponent().requestFocus();
            }

        });
        //this.addKeyListener(kbAction);
//        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), new AbstractAction(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                   CardLayout cl = (CardLayout) parentPanel.getLayout();
//                    cl.next(parentPanel);
//            }
//            
//        });

        rows = getBOARD_ROWS();
        columns = getBOARD_COLUMNS();

    }

    /**
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g);

        updateSquare();
        drawBoard(g);
        drawPieces(g);

        /*
         * g2.setColor(Color.DARK_GRAY); piece1.movePiece(2*squareWidth,
         * squareWidth); piece1.drawPiece(g2); //g2.fillArc(0, 0, 100, 100, 0,
         * 360);
         *
         */
    }

//    @Override
//    public void mouseClicked(MouseEvent e) {
////        int squareX = 0;
////        int squareY = 0;
////        MouseEvent eMouseEvent = e;
////
////        // update the square width
////        updateSquare();
////
////        // we only want to move the piece if the piece has been selected
////        // if the mouse is on top of the piece, the piece should change color
////        // if the mouse is to the right of top left corner, but to the left of the
////        // top right corner
////        // if (eMouseEvent.getX() > piece1.getxPos()
////        // && eMouseEvent.getX() < (piece1.getxPos() + squareWidth)
////        // && eMouseEvent.getY() > piece1.getyPos()
////        // && eMouseEvent.getY() < (piece1.getyPos() + squareWidth)) {
////        for (int i = 0; i < pieces.length; i++) {
////            if (e.getX() > pieces[i].getxPos()
////                    && e.getX() < (pieces[i].getxPos() + getSquareWidth())
////                    && e.getY() > pieces[i].getyPos()
////                    && e.getY() < (pieces[i].getyPos() + getSquareWidth())) {
////
////                // if the piece has not been selected
////                if (!pieces[i].isSelected) {
////                    // set isSelected to true
////                    pieces[i].isSelected = true; // the square the mouse is over
////                    selectedPiece = i;
////                } // end if
////                else {
////                    pieces[i].isSelected = false;
////                } // end else
////
////            } // end if
////            else if (pieces[selectedPiece] != null) {
////                squareX = e.getX() / getSquareWidth();
////                squareY = e.getY() / getSquareWidth();
////
////                // move the piece coordinates to the appropriate square
////                pieces[selectedPiece].movePiece(squareX, squareY);
////
////            } // end if
////
////        } // end for
////
////        // redraw the screen
////        repaint();
////        // throw new UnsupportedOperationException("Not supported yet.");
//    }
    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * @return the pieces
     */
    public Piece[] getPieces() {
        return pieces;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

//    @Override
//    public void mousePressed(MouseEvent e) {
//        // user clicks on the piece
//        // we want the piece to move with the mouse
//        // set the piece coordinates to that of the mouse coordinates
//        /*
//         * updateSquare();
//         * piece1.setxPos(e.getX()- (squareWidth / 2));
//         * piece1.setyPos(e.getY()- (squareWidth / 2));
//         * repaint();
//         * 
//         */
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//        int squareX = 0;
//        int squareY = 0;
//
//        // update the square width
//        updateSquare();/*
//                        * //when the user releases the mouse
//                        * //we want the piece to be drawn in the square the mouse is over
//                        * //the square the mouse is over
//                        * squareX = e.getX() / squareWidth;
//                        * squareY = e.getY() / squareWidth;
//                        * piece1.setxPos((squareX * squareWidth));
//                        * piece1.setyPos(squareY * squareWidth);
//         */
//        repaint();
//
//        // throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//        // throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//    }
//
//    @Override
//    public void mouseDragged(MouseEvent e) {/*
//                                             * // throw new UnsupportedOperationException("Not supported yet.");
//                                             * piece1.setxPos(e.getX()- (squareWidth / 2));
//                                             * piece1.setyPos(e.getY()- (squareWidth / 2));
//         */
//        repaint();
//    }
//
//    @Override
//    public void mouseMoved(MouseEvent e) {
//        // throw new UnsupportedOperationException("Not supported yet.");
//    }
    /**
     * updateSquare - updates the width of the squares on the board.
     */
    public void updateSquare() {
        setSquareWidth(this.getWidth() / 8);
    }

    /**
     * setPieces - takes a given set of pieces and sets the variable
     *
     * @param pieces
     */
    public void setPieces(Piece[] pieces) {
        this.pieces = pieces;
    }

    /**
     * @param g
     */
    private void drawBoard(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        if (Objects.nonNull(this.gameDataBoard)) {
            for (int board_row = 0; board_row < 8; board_row++) {
                for (int board_col = 0; board_col < 8; board_col++) {
                    BoardSquare currentSquare = gameDataBoard[board_row][board_col];
                    Color boardColor = currentSquare.getColor();
                    int squareWidth1 = getSquareWidth();
                    Square boardSquare = new Square(board_row, board_col, squareWidth1, squareWidth1,
                            boardColor);

                    this.drawBoardSquare(g2, boardSquare);
                }
            }
//            boardSquare1 = new Square(0, 0, getSquareWidth(), getSquareWidth(), Color.BLUE);
//            boardSquare2 = new Square(0, 0, getSquareWidth(), getSquareWidth(), Color.BLACK);

            int swap = 1;

//            for (int k = 0; k <= this.getHeight(); k += (getSquareWidth())) {
//                if (swap % 2 == 1) {
//                    drawBoardRow(g2, k, false);
//                    swap++;
//                } // end if
//                else {
//                    drawBoardRow(g2, k, true);
//                    swap++;
//                } // end else
//                if (swap > 2) {
//                    swap = 1;
//                }
//            } // end for loop
        }
    }

    /**
     * @param g2
     * @param k
     * @param swapColor
     */
//    private void drawBoardRow(Graphics2D g2, int k, Boolean swapColor) {
//        if (!swapColor) {
//            for (int i = 0; i <= getSquareWidth() * 8; i += (2 * getSquareWidth())) {
//
//                drawBoardSquare(g2, k, i, boardSquare1);
//
//            }
//            for (int j = getSquareWidth(); j <= getSquareWidth() * 8; j += (2 * getSquareWidth())) {
//                drawBoardSquare(g2, k, j, boardSquare2);
//            }
//        } else {
//            for (int i = 0; i <= getSquareWidth() * 8; i += (2 * getSquareWidth())) {
//
//                drawBoardSquare(g2, k, i, boardSquare2);
//
//            }
//            for (int j = getSquareWidth(); j <= getSquareWidth() * 8; j += (2 * getSquareWidth())) {
//                drawBoardSquare(g2, k, j, boardSquare1);
//            }
//        }
//    }
    /**
     * @param g2
     * @param k
     * @param i
     * @param square
     */
    private void drawBoardSquare(Graphics2D g2, int k, int i, Square square) {
        g2.setColor(square.getSquareColor());
        g2.fillRect(i, k,
                square.getWidth(), square.getHeight());
    }

    /**
     *
     * @param g
     */
    private void drawPieces(Graphics g) {
        int pieceX;
        int pieceY;
        int squareWidth1 = this.getSquareWidth();
        if (!Objects.isNull(pieces)) {
            for (Piece piece : getPieces()) {
                pieceX = piece.getxCol();
                pieceY = piece.getyRow();

//                adjustX = pieceX / this.getSquareWidth();
//                adjustY = pieceY / this.getSquareWidth();
                if (!piece.isSelected) {
                    piece.setxPos(squareWidth1 * pieceX);
                    piece.setyPos(squareWidth1 * pieceY);
                }
                piece.setWidth(squareWidth);
                piece.setHeight(squareWidth);
                piece.drawPiece(g);
            }
        }
    }

    /**
     * @return the squareWidth
     */
    public int getSquareWidth() {
        return squareWidth;
    }

    /**
     * @param squareWidth the squareWidth to set
     */
    public void setSquareWidth(int squareWidth) {
        this.squareWidth = squareWidth;
    }

    /**
     *
     * @param gameBoard
     */
    public void setGameBoard(BoardSquare[][] gameBoard) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this.gameDataBoard = gameBoard;
    }

    /*
     * @param g2 @param boardSquare
     */
    private void drawBoardSquare(Graphics2D g2, Square boardSquare) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //(2 * getSquareWidth())
//        getSquareWidth()
        g2.setColor(boardSquare.getSquareColor());
        int squareX = boardSquare.getBoardColumn() * getSquareWidth();
        int squareY = boardSquare.getBoardRow() * this.getSquareWidth();
        g2.fillRect(squareX, squareY,
                boardSquare.getWidth(), boardSquare.getHeight());
    }

    /**
     *
     * @param squareX
     * @param squareY
     *
     * @return
     */
    public BoardSquare getBoardSquare(int squareX, int squareY) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        BoardSquare clickSqure;
        System.out.println(String.format("%d, %d", squareX, squareY));
        clickSqure = gameDataBoard[squareX][squareY];

        return clickSqure;
    }

    /*
     * @param squareX - the X location of the square @param squareY - the Y
     * location of the square @param squareToAdd - the square to be added
     */
    /**
     *
     * @param squareX
     * @param squareY
     * @param squareToAdd
     */
    public void setBoardSquare(int squareX, int squareY, BoardSquare squareToAdd) {
        gameDataBoard[squareX][squareY] = squareToAdd;
    }

    /**
     *
     * @param newState the piece in the new position
     * @param oldState the piece in the current position
     * @param squareX  the x pos of the piece in the new position
     * @param squareY  the y pos of the piece in the new position
     */
    public void movePiece(Piece newState, Piece oldState, int squareX, int squareY) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        //set the piece to the new position
        newState.setxPos(squareWidth * squareX);
        newState.setyPos(squareWidth * squareY);
        newState.setxCol(squareY);
        newState.setyRow(squareX);
        newState.isSelected = !newState.isSelected;

        //update the new square to indicate that the piece is there
        BoardSquare newStateSqr = getBoardSquare(squareX, squareY);
        newStateSqr.setHasPiece(true);
        newStateSqr.setCurrentPiece(newState);

        //update the old square to indicate that the piece is no longer there
        BoardSquare oldStateSqr = getBoardSquare(oldState.getyRow(), oldState.getxCol());
        oldStateSqr.setHasPiece(false);
        oldStateSqr.setCurrentPiece(null);

        this.repaint();
        //newState.setHasMoved(false);
    }

    /**
     *
     * @param newState
     * @param oldState
     */
    public void resetPiece(Piece newState, Piece oldState) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//       newState = oldState;
        newState.setxPos(oldState.getxPos());
        newState.setyPos(oldState.getyPos());
        newState.setxCol(oldState.getxCol());
        newState.setyRow(oldState.getyRow());

        if (newState.isSelected) {
            newState.isSelected = !newState.isSelected;
        }

    }

    /**
     *
     * @param squareX
     * @param squareY
     *
     * @return
     */
    public Piece checkForGamePiece(int squareX, int squareY) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        BoardSquare selectedSquare = getBoardSquare(squareX, squareY);
        if (selectedSquare.isHasPiece()) {
            return selectedSquare.getCurrentPiece();
        } else {
            return null;
        }
    }

    /**
     * Determines if the given piece can move forward
     *
     * @param pieceToMove
     *
     * @return
     */
    public boolean isBlocked(Piece pieceToMove) {
        boolean isPieceBlocked = false;
        Piece movingPiece = pieceToMove;
        movingPiece.setPieceDirection("NEGATIVE");
        int pieceCol = movingPiece.getxCol();
        int pieceRow = movingPiece.getyRow();
        String pieceDirection = movingPiece.getPieceDirection();
        BoardSquare fwdLeft;
        BoardSquare fwdRight;
        switch (pieceDirection) {
            //the piece is moving towards the bottom 
            case "POSITIVE" -> {
                fwdLeft = gameDataBoard[pieceCol - 1][pieceRow + 1];
                fwdRight = gameDataBoard[pieceCol + 1][pieceRow + 1];

            }

            //the piece is moving towards the top
            case "NEGATIVE" -> {
                fwdLeft = squareLookUp(pieceRow - 1, pieceCol - 1);
                fwdRight = squareLookUp(pieceRow - 1, pieceCol + 1);
                if (fwdLeft != null && fwdRight != null) {
                    if (!fwdLeft.isHasPiece() && !fwdRight.isHasPiece()) {
                        isPieceBlocked = false;
                    } else {
                        if (!fwdLeft.isHasPiece()) {
                            isPieceBlocked = false;
                        } else {
                            isPieceBlocked = false;
                        }
                    }
                } else {
                    if (fwdLeft != null) {
                        if (fwdLeft.isHasPiece()) {
                            isPieceBlocked = true;
                        }
                    } else {
                        if (fwdRight.isHasPiece()) {
                            isPieceBlocked = true;
                        }
                    }

                }
            }

            default -> {

            }
        }

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return isPieceBlocked;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     *
     */
    private BoardSquare squareLookUp(int pieceRow, int pieceCol) {
        if (pieceRow >= this.rows || pieceCol >= this.columns) {
            return null;
        }
        return gameDataBoard[pieceRow][pieceCol];
    }

    /**
     *
     * @param pieceToMove the piece that has been selected for movement
     *
     * @return the java.util.List{@literal <java.awt.Point>}
     *
     */
    public List<Point> moveOptions(Piece pieceToMove) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<Point> optionList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<BoardSquare> optionSqr = new ArrayList<>();
        Piece movingPiece = pieceToMove;
        movingPiece.setPieceDirection("NEGATIVE");
        int pieceCol = movingPiece.getxCol();
        int pieceRow = movingPiece.getyRow();
        String pieceDirection = movingPiece.getPieceDirection();
        BoardSquare fwdLeft;
        BoardSquare fwdRight;
        int col_neg_id = pieceCol - 1;
        int row_id = pieceRow - 1;
        int col_pos_id = pieceCol + 1;
        switch (pieceDirection) {
            //the piece is moving towards the bottom 
            case "POSITIVE" -> {
                fwdLeft = gameDataBoard[col_neg_id][row_id];
                fwdRight = gameDataBoard[col_pos_id][row_id];

            }

            //the piece is moving towards the top
            case "NEGATIVE" -> {
                int row_neg_id = pieceRow;
                fwdLeft = squareLookUp(row_id, col_neg_id);
                fwdRight = squareLookUp(row_id, col_pos_id);
                if (fwdLeft != null && fwdRight != null) {
                    if (!fwdLeft.isHasPiece() && !fwdRight.isHasPiece()) {
//                        map.put(col_neg_id, row_id);
//                        map.put(col_pos_id, row_id);
//                        optionSqr.add(fwdLeft);
//                        optionSqr.add(fwdRight);
                        optionList.add(new Point(row_id, col_neg_id));
                        optionList.add(new Point(row_id, col_pos_id));
                    } else {
                        if (!fwdLeft.isHasPiece()) {
//                            map.put(col_neg_id, row_id);
//                            optionSqr.add(fwdLeft);
                            optionList.add(new Point(row_id, col_neg_id));
                        } else {
//                            optionSqr.add(fwdRight);
//                            map.put(col_pos_id, row_id);
                            optionList.add(new Point(row_id, col_pos_id));
                        }
                    }
                } else {
                    if (fwdLeft != null) {
                        if (!fwdLeft.isHasPiece()) {
                            //map.put(row_id, row_id);
//                            optionSqr.add(fwdLeft);
                            optionList.add(new Point(row_id, col_neg_id));
                        }
                    } else if (fwdRight != null) {
                        if (!fwdRight.isHasPiece()) {
//                            optionSqr.add(fwdRight);
                            optionList.add(new Point(row_id, col_pos_id));
//                            destCell.setLocation(col_pos_id, row_id);
//                            map.put(col_pos_id, row_id);
                        }
                    }

                }
            }

            default -> {
                throw new RuntimeException("Scenario not considered");
            }
        }

        return optionList;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    /**
     *
     * @param pieceToMove
     * @param destination
     */
    public void movePieceToSquare(Piece pieceToMove, Point destination) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Piece newState = new Piece();
        int ptmXCol = pieceToMove.getyRow();
        int ptmYRow = pieceToMove.getxCol();
        BoardSquare oldStateSqr = getBoardSquare(ptmXCol, ptmYRow);
        int pieceIndex = ArrayUtils.indexOf(this.getPieces(), oldStateSqr.getCurrentPiece());
        //decouple the piece from its current square
        //update the old square to indicate that the piece is no longer there

        oldStateSqr.setHasPiece(false);
        oldStateSqr.setCurrentPiece(null);

        //set the piece to the new position
        pieceToMove = this.getPiece(pieceIndex);
        pieceToMove.setxPos(squareWidth * destination.y - 1);
        pieceToMove.setyPos(squareWidth * destination.x - 1);
        pieceToMove.setxCol(destination.y);
        pieceToMove.setyRow(destination.x);
        //pieceToMove.isSelected = !newState.isSelected;

        //decouple the piece from its current square
        //update the old square to indicate that the piece is no longer there
        oldStateSqr.setHasPiece(false);
        oldStateSqr.setCurrentPiece(null);

        //update the new square to indicate that the piece is there
        BoardSquare newStateSqr = getBoardSquare(destination.x, destination.y);
        newStateSqr.setHasPiece(true);
        newStateSqr.setCurrentPiece(pieceToMove);

    }

    /**
     *
     * @param pieceIndex
     *
     * @return
     */
    public Piece getPiece(int pieceIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            return this.pieces[pieceIndex];
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            System.out.println("Alert: Index " + pieceIndex + " is out of bounds!");
        }
        return this.pieces[0];
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param userPlayer
     */
    public void setUserPlayer(Player userPlayer) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Get the value of userPlayer
     *
     * @return {@link Player}the value of userPlayer
     */
    public Player getUserPlayer() {
        return userPlayer;
    }

    /**
     * Determines if the piece can move forward or not
     *
     * @param gamePiece
     *
     * @return
     */
    //<editor-fold defaultstate="collapsed" desc="setPlayerPieces">
    /**
     *
     * @return
     */
//    public Piece[] setPlayerPieces() {
//        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        Piece[] playerPieces = null;
//        
//        return playerPieces;
//    }
//</editor-fold>
}
