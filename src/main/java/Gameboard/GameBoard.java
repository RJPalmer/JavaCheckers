/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameboard;

import com.mycompany.javacheckers.Player;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JPanel;

/**
 *
 * @author Palmer
 */
public class GameBoard extends JPanel {

    private static int BOARD_COLUMNS = 8;
    private static int BOARD_ROWS = 8;

    private static final int MARGIN_SIZE = 20;

    /**
     * Get the value of MARGIN_SIZE
     *
     * @return the value of MARGIN_SIZE
     */
    public static int getMARGIN_SIZE() {
        return MARGIN_SIZE;
    }
    /*
     *
     */


    public void clearSquare(BoardSquare currentSqr) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        currentSqr.setCurrentPiece(null);
        currentSqr.setHasPiece(false);
    }

    public void setPieceAtSquare(Piece currentSqr) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        BoardSquare sqr;

        sqr = this.getBoardSquare(currentSqr.getxCol(), currentSqr.getyRow());
        sqr.setCurrentPiece(currentSqr);
        sqr.setHasPiece(true);

        currentSqr.setxPos(currentSqr.getyRow() * getSquareWidth());
        currentSqr.setyPos(currentSqr.getxCol() * getSquareWidth());

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
    // private JPanel checkerBoard;
    private List<Piece> pieces;
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
        setRows(BOARD_ROWS);
        setColumns(BOARD_COLUMNS);
        this.addComponentListener(resizer);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                e.getComponent().requestFocus();
                updateSquare();
                repaint();
            }

        });

        rows = getBOARD_ROWS();
        columns = getBOARD_COLUMNS();
        pieces = new ArrayList<Piece>();
    }

    /**
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g);

        updateSquare();

        // Validate board size before rendering
        if (!isValidBoardSize()) {
            // Could log warning or handle gracefully
            return;
        }
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
    public List<Piece> getPieces() {
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
     * updateSquare - updates the width of the squares on the board. Calculates
     * square width based on the available panel width (accounting for any
     * margin). Ensures the board maintains its square aspect ratio.
     */
    public void updateSquare() {
        // Calculate the usable width for the board (after margins handled by parent container)
        int usableWidth = this.getWidth();

        // Divide by number of columns to get the square width
        int calculatedSquareWidth = usableWidth / BOARD_COLUMNS;

        // Also calculate based on height to maintain square aspect ratio
        int usableHeight = this.getHeight();
        int heightBasedSquareWidth = usableHeight / BOARD_ROWS;

        // Use the smaller value to ensure board fits within bounds
        int finalSquareWidth = Math.min(calculatedSquareWidth, heightBasedSquareWidth);

        setSquareWidth(finalSquareWidth);
    }

    /**
     * Validates that the board dimensions are sufficient for rendering. Ensures
     * minimum square size for playability.
     *
     * @return true if dimensions are valid, false otherwise
     */
    private boolean isValidBoardSize() {
        final int MINIMUM_SQUARE_SIZE = 20;  // Minimum playable square size
        return squareWidth >= MINIMUM_SQUARE_SIZE;
    }

    /**
     * setPieces - takes a given set of pieces and sets the variable
     *
     * @param pieces
     */
    public void setPieces(List<Piece> pieces) {
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
//            boardSquare1 = new Square(0, 0, getSquareWidth(), getSquareWidth(), Color.BLUE);
//            boardSquare2 = new Square(0, 0, getSquareWidth(), getSquareWidth(), Color.BLACK);
        }
    }
    /**
     * @param g2
     * @param k
     * @param i
     * @param square
     */

    /**
     *
     * @param g
     */
    private void drawPieces(Graphics g) {
        int pieceX;
        int pieceY;
        int squareWidth1 = this.getSquareWidth();
        if (pieces != null) {
            List<Piece> gamePieces = getPieces();
            for (Piece piece : gamePieces) {
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
     * @param col_index
     * @param row_index
     *
     * @return the Gameboard.BoardSquare
     */
    public BoardSquare getBoardSquare(int col_index, int row_index) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        BoardSquare clickSqure;
        System.out.println(String.format("Retreiving Square %d, %d", col_index, row_index));
        clickSqure = gameDataBoard[row_index][col_index];

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
        gameDataBoard[squareY][squareX] = squareToAdd;
    }

    /**
     *
     * @param newState the piece in the new position
     * @param oldState the piece in the current position
     * @param squareX the x pos of the piece in the new position
     * @param squareY the y pos of the piece in the new position
     */
    public void movePiece(Piece newState, Piece oldState, int squareX, int squareY) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        //set the piece to the new position
        newState.setxPos(squareWidth * squareX);
        newState.setyPos(squareWidth * squareY);
        newState.setxCol(squareX);
        newState.setyRow(squareY);
        newState.isSelected = !newState.isSelected;

        //update the new square to indicate that the piece is there
        BoardSquare newStateSqr = getBoardSquare(squareX, squareY);
        newStateSqr.setHasPiece(true);
        newStateSqr.setCurrentPiece(newState);

        //update the old square to indicate that the piece is no longer there
        BoardSquare oldStateSqr = getBoardSquare(oldState.getxCol(), oldState.getyRow());
        oldStateSqr.setHasPiece(false);
        oldStateSqr.setCurrentPiece(null);

        this.repaint();
        //newState.setHasMoved(false);
    }

    /**
     * Resets the state of a given piece to match the state of another piece.
     * <p>
     * <p>
     * This method copies the positional attributes (xPos, yPos, xCol, yRow)
     * from the {@code oldState} piece to the {@code newState} piece. If the
     * {@code newState} piece is currently selected, its selection state will be
     * toggled off.</p>
     *
     * @param newState the piece whose state will be updated
     * @param oldState the piece whose state will be copied
     *
     * @throws IllegalArgumentException if {@code newState} or {@code oldState}
     * is {@code null}
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
     * @param rowNum
     * @param colNum
     *
     * @return
     */
    public Piece checkForGamePiece(int colNum, int rowNum) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        BoardSquare selectedSquare = getBoardSquare(colNum, rowNum);
        if (selectedSquare.isHasPiece()) {
            Piece currentPiece = selectedSquare.getCurrentPiece();
            return currentPiece;
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
//        movingPiece.setPieceDirection("NEGATIVE");
        int pieceCol = movingPiece.getxCol();
        int pieceRow = movingPiece.getyRow();
        String pieceDirection = movingPiece.getPieceDirection();
        BoardSquare fwdLeft;
        BoardSquare fwdRight;
        switch (pieceDirection) {
            //the piece is moving towards the bottom 
            case POSITIVE -> {

                fwdLeft = squareLookUp(pieceCol - 1, pieceRow + 1);
                fwdRight = squareLookUp(pieceCol + 1, pieceRow + 1);

                if (fwdLeft != null && fwdRight != null) {
                    if (!fwdLeft.isHasPiece() && !fwdRight.isHasPiece()) {
                        isPieceBlocked = false;
                    } else if (fwdLeft.isHasPiece() && fwdRight.isHasPiece()) {
                        isPieceBlocked = true;
                    } else {
                        if (!fwdLeft.isHasPiece() || !fwdRight.isHasPiece()) {
                            isPieceBlocked = false;
                        }
                    }
                } else {
                    if (fwdLeft != null) {
                        if (fwdLeft.isHasPiece()) {
                            isPieceBlocked = true;
                        }
                    } else {
                        if (!Objects.isNull(fwdRight)) {
                            if (fwdRight.isHasPiece()) {
                                isPieceBlocked = true;
                            }
                        }
                    }

                }
            }

            //the piece is moving towards the top
            case "NEGATIVE" -> {
                System.out.printf(
                        "Checking piece (%d,%d)%n",
                        pieceToMove.getxCol(),
                        pieceToMove.getyRow()
                );

                fwdLeft = squareLookUp(pieceCol - 1, pieceRow - 1);
                fwdRight = squareLookUp(pieceCol + 1, pieceRow - 1);

                if (fwdLeft != null) {
                    System.out.printf(
                            "Left diagonal (%d,%d) - occupied=%b%n",
                            pieceCol - 1,
                            pieceRow - 1,
                            fwdLeft.isHasPiece()
                    );
                } else {
                    System.out.printf(
                            "Left diagonal (%d,%d) - OUT OF BOUNDS%n",
                            pieceCol - 1,
                            pieceRow - 1
                    );
                }
                if (fwdRight != null) {
                    System.out.printf(
                            "Right diagonal (%d,%d) - occupied=%b%n",
                            pieceCol + 1,
                            pieceRow - 1,
                            fwdRight.isHasPiece()
                    );
                } else {
                    System.out.printf(
                            "Right diagonal (%d,%d) - OUT OF BOUNDS%n",
                            pieceCol + 1,
                            pieceRow - 1
                    );
                }
                if (fwdLeft != null && fwdRight != null) {
                    if (!fwdLeft.isHasPiece() && !fwdRight.isHasPiece()) {
                        isPieceBlocked = false;
                    } else if (fwdLeft.isHasPiece() && fwdRight.isHasPiece()) {
                        isPieceBlocked = true;
                    } else {
                        if (!fwdLeft.isHasPiece() || !fwdRight.isHasPiece()) {
                            isPieceBlocked = false;
                        }
                    }
                } else {
                    if (fwdLeft != null) {
                        if (fwdLeft.isHasPiece()) {
                            isPieceBlocked = true;
                        }
                    } else {
                        if (!Objects.isNull(fwdRight)) {
                            if (fwdRight.isHasPiece()) {
                                isPieceBlocked = true;
                            }
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
    private BoardSquare squareLookUp(int pieceCol, int pieceRow) {
        if (withinBounds(pieceCol, pieceRow)) {
            return null;
        }
        return gameDataBoard[pieceRow][pieceCol];
    }

    private boolean withinBounds(int pieceRow, int pieceCol) {
        return pieceRow < 0 || pieceRow >= this.rows || pieceCol < 0 || pieceCol >= this.columns;
    }

    /**
     *
     * Return a list of positions that the given piece can move to
     *
     * @param pieceToMove the piece that has been selected for movement
     *
     * @return the java.util.List{@literal <java.awt.Point>}
     *
     */
    public List<Point> moveOptions(Piece pieceToMove) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<Point> optionList = new ArrayList<>();
        Piece movingPiece = pieceToMove;
        //movingPiece.setPieceDirection(NEGATIVE);
        int pieceCol = movingPiece.getxCol();
        int pieceRow = movingPiece.getyRow();
        String pieceDirection = movingPiece.getPieceDirection();
        int col_neg_id = pieceCol - 1;
        int row_id = pieceRow - 1;
        int col_pos_id = pieceCol + 1;
        switch (pieceDirection) {
            //the piece is moving towards the bottom 
            case POSITIVE -> {
                checkNearbySquares(row_id, col_neg_id, col_pos_id, optionList);
            }

            //the piece is moving towards the top
            case NEGATIVE -> {
                checkNearbySquares(row_id, col_neg_id, col_pos_id, optionList);
            }

            default -> {
                throw new RuntimeException("Scenario not considered");
            }
        }

        return optionList;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    private void checkNearbySquares(int row_id, int col_neg_id, int col_pos_id, List<Point> optionList) {
        //<editor-fold defaultstate="collapsed" desc="(old) - code for checking squares for possible moves">
//        BoardSquare fwdLeft;
//        BoardSquare fwdRight;
//        fwdLeft = squareLookUp(col_neg_id, row_id);
//        fwdRight = squareLookUp(col_pos_id, row_id);
//        if (fwdLeft != null && fwdRight != null) {
//            if (!fwdLeft.isHasPiece() && !fwdRight.isHasPiece()) {
//                optionList.add(new Point(col_neg_id,row_id));
//                optionList.add(new Point(col_pos_id, row_id));
//            } else {
//                if (!fwdLeft.isHasPiece()) {
//                    optionList.add(new Point(col_neg_id, row_id));
//                } else {
//                    optionList.add(new Point(col_pos_id, row_id));
//                }
//            }
//        } else {
//            if (fwdLeft != null) {
//                if (!fwdLeft.isHasPiece()) {
//                    optionList.add(new Point(col_neg_id, row_id));
//                }
//            } else if (fwdRight != null) {
//                if (!fwdRight.isHasPiece()) {
//                    optionList.add(new Point(col_pos_id, row_id));
        ////                            destCell.setLocation(col_pos_id, row_id);
////                            map.put(col_pos_id, row_id);
//                }
//            }
//            
//        }
//</editor-fold>

        BoardSquare fwdLeft = squareLookUp(col_neg_id, row_id);
        BoardSquare fwdRight = squareLookUp(col_pos_id, row_id);

        if (fwdLeft != null && !fwdLeft.isHasPiece()) {
            optionList.add(new Point(col_neg_id, row_id));
        }
        if (fwdRight != null && !fwdRight.isHasPiece()) {
            optionList.add(new Point(col_pos_id, row_id));
        }

    }
    private static final String POSITIVE = "POSITIVE";
    private static final String NEGATIVE = "NEGATIVE";

    /**
     *
     * @param pieceToMove
     * @param destination
     */
    public void movePieceToSquare(Piece pieceToMove, Point destination) {
        int ptmXCol = pieceToMove.getxCol();
        int ptmYRow = pieceToMove.getyRow();

        BoardSquare oldStateSqr = getBoardSquare(ptmXCol, ptmYRow);
        //decouple the piece from its current square
        //update the old square to indicate that the piece is no longer there
        clearSquare(oldStateSqr);
        this.gameDataBoard[ptmYRow][ptmXCol] = oldStateSqr;

        //set the piece to the new position
        //pieceToMove = this.getPiece(pieceIndex);
        pieceToMove.setxPos(squareWidth * (destination.x));
        pieceToMove.setyPos(squareWidth * (destination.y));
        pieceToMove.setxCol(destination.x);
        pieceToMove.setyRow(destination.y);
        /*updatePieces_deprecated(pieceToMove);*/
        updatePieces(pieceToMove);

        //decouple the piece from its current square
        //update the old square to indicate that the piece is no longer there
//        oldStateSqr.setHasPiece(false);
//        oldStateSqr.setCurrentPiece(null);
        //setBoardSquare(ptmXCol, ptmYRow, oldStateSqr);
        //update the new square to indicate that the piece is there
        BoardSquare newStateSqr = getBoardSquare(destination.x, destination.y);
        newStateSqr.setHasPiece(true);
        newStateSqr.setCurrentPiece(pieceToMove);
        setBoardSquare(destination.x, destination.y, newStateSqr);

    }

    /**
     * Updates the stored reference for a game piece.
     *
     * @param pieceToMove The piece whose state has changed.
     */
    public void updatePieces(Piece pieceToMove) {

        if (pieceToMove == null) {
            return;
        }

        List<Piece> currentPieces = getPieces();

        int index = currentPieces.indexOf(pieceToMove);

        if (index >= 0) {
            currentPieces.set(index, pieceToMove);
            setPieces(currentPieces);
        }
    }

    /**
     * Retrieves a piece from the array based on the specified index.
     *
     * @param pieceIndex the index of the piece to retrieve.
     *
     * @return the piece at the specified index.
     *
     * @throws IllegalArgumentException if the index is out of bounds.
     */
    public Piece getPiece(int pieceIndex) {
        if (pieceIndex < 0 || pieceIndex >= pieces.size()) {
            throw new IllegalArgumentException("Invalid piece index: " + pieceIndex);
        }
        return this.getPieces().get(pieceIndex);
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
