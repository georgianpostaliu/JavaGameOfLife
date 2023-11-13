# JavaGameOfLife
Introduction

This Java project implements Conway's Game of Life, a cellular automaton devised by the mathematician John Conway. The game consists of a grid of cells, each of which can be in one of two states: alive or dead. The cells evolve over time based on a set of rules, creating interesting patterns and behaviors. The project includes a Life class that manages the game's logic and a Board class that represents the grid.
Life Class
Constants

    ROWS: The number of rows in the game board (20).
    COLS: The number of columns in the game board (80).
    TIME_DELAY: Time delay in milliseconds used for controlling the animation speed (100).

Methods

    initializeBoard(Board board)
        Randomly initializes the provided Board object with live and dead cells.
        Each cell has a 1/3 chance of being alive.

    displayBoard(Board board)
        Displays the current state of the board in the console.
        Alive cells are represented by '0', and dead cells are represented by '.'.

    countNeighbours(int row, int col, Board b)
        Counts the number of alive neighbors around a specified cell.

    calculateNextGen(Board b, Board nextB)
        Calculates the next generation of the game board based on the rules of Conway's Game of Life.
        Updates the nextB board with the calculated values.

    transferNextToCurrent(Board board, Board nextBoard)
        Transfers the values from the nextBoard to the current board.

    slow()
        Introduces a time delay for animation purposes.

    main(String[] args)
        The main entry point for the application.
        Creates instances of the Board class, initializes the board, and iteratively displays and updates the board for 100 generations.

Board Class
Fields

    b: A 2D array representing the game board.

Methods

    Board(int rows, int cols)
        Constructor that initializes a new board with the specified number of rows and columns.

    get(int row, int col)
        Retrieves the value (alive or dead) of the cell at the specified row and column.

    set(int row, int col, int value)
        Sets the value (alive or dead) of the cell at the specified row and column.

Usage

To run the Game of Life simulation, execute the main method in the Life class. The simulation will run for 100 generations, displaying each generation with a delay specified by TIME_DELAY. The initial state of the board is randomized.

Feel free to explore and modify the code to experiment with different initial configurations or adjust the rules for cell evolution.
