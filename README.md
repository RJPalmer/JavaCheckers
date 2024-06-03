# Checkers Game

## Overview
This is a classic implementation of the Checkers game written in Java. The game supports two-player mode, where players can compete against each other on the same computer. The game follows standard Checkers rules and provides a graphical user interface (GUI) for an enhanced gaming experience.

## Features
- Two-player mode
- Graphical User Interface (GUI) using Java Swing
- Highlighting valid moves
- Basic AI for single-player mode (optional)
- Undo and redo moves (optional)
- Save and load game state (optional)

## Installation
To run the Checkers game on your machine, follow these steps:

1. **Ensure you have Java installed**: The game requires Java Development Kit (JDK) version 8 or higher. You can download it from [Oracle's official site](https://www.oracle.com/java/technologies/javase-downloads.html).

2. **Clone the repository**:
    ```sh
    git clone https://github.com/your-username/checkers-game.git
    cd checkers-game
    ```

3. **Compile the game**:
    ```sh
    javac -d bin src/com/checkers/*.java
    ```

4. **Run the game**:
    ```sh
    java -cp bin com.checkers.CheckersGame
    ```

## How to Play
1. **Starting the Game**:
    - Run the game using the above instructions.
    - The main menu will appear. Select "New Game" to start a new game.

2. **Game Rules**:
    - Players take turns moving their pieces.
    - A piece can only move diagonally forward to an adjacent empty square.
    - If an opponent's piece is on a diagonally adjacent square, and the square immediately beyond it is empty, you can jump over the opponent's piece and capture it.
    - Multiple jumps are allowed in a single turn.
    - When a piece reaches the opposite end of the board, it becomes a King and can move diagonally forward and backward.

3. **Controls**:
    - Click on a piece to select it.
    - Click on a highlighted square to move the selected piece.
    - The game highlights all possible moves for the selected piece.

4. **Winning the Game**:
    - The game ends when one player captures all of the opponent's pieces or when no legal moves are available for the opponent

## Contributing
Contributions are welcome! If you have suggestions or improvements, please submit a pull request or open an issue.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements
- This game was inspired by the traditional Checkers board game.
- Special thanks to the Java community for their resources and tutorials.

Enjoy playing Checkers!
