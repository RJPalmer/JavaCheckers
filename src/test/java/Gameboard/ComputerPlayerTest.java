/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

/**
 *
 * @author robertpalmer
 */
import com.mycompany.javacheckers.ComputerPlayer;
import java.awt.Point;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ComputerPlayerTest {
    
 
    @Test
void testMakeMoveSelectsAndMovesEligiblePiece() {

    // Arrange
    Piece blockedPiece = mock(Piece.class);
    Piece movablePiece = mock(Piece.class);

    
    List<Piece> pieces = List.of(blockedPiece, movablePiece);
    
    Random random = new Random();

    ComputerPlayer player =
            new ComputerPlayer(random, 2, pieces, "Yellow");

    GameBoard gameBoard = mock(GameBoard.class);

    Point destination = new Point(3, 4);

    when(gameBoard.isBlocked(blockedPiece)).thenReturn(true);
    when(gameBoard.isBlocked(movablePiece)).thenReturn(false);

    when(gameBoard.moveOptions(movablePiece))
            .thenReturn(List.of(destination));

    // Act
    player.makeMove(gameBoard);

    // Assert
    verify(gameBoard).movePieceToSquare(movablePiece, destination);
}
}
