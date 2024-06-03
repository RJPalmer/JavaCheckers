package checkers;

import gameboard.Piece;



public class Player {
    private int piecesCount;
    private Piece playerPieces;    
    private String playerColor;
    
    /**
     * 
     */
    public Player() {
    }

    /**
     * 
     * @param piecesCount
     * @param playerPieces
     * @param playerColor 
     */
    public Player(int piecesCount, Piece playerPieces, String playerColor) {
        this.piecesCount = piecesCount;
        this.playerPieces = playerPieces;
        this.playerColor = playerColor;
    }

    
    

     
    public void movePiece (Piece piece) {
    }

    
    public void kingPiece () {
    }

    /**
     * @return the playerColor
     */
    public String getPlayerColor() {
        return playerColor;
    }

    /**
     * @param playerColor the playerColor to set
     */
    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }

    /**
     * @return the piecesCount
     */
    public int getPiecesCount() {
        return piecesCount;
    }

    /**
     * @param piecesCount the piecesCount to set
     */
    public void setPiecesCount(int piecesCount) {
        this.piecesCount = piecesCount;
    }


}

