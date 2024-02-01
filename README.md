# Sudoku-Solver-with-GUI
This project I worked on in summer of 2023 and updated in 2024. 

The project just started as creating an algorithm that could solve Sudoku puzzles. I created an algorithm that checks each row, column, and 3x3 box to eliminate possible solutions to the puzzle. The algorithm repeats until each cell of the puzzle has one single number, meaning the puzzle has been solved.

The solving capability is limited, as it can only solve easy-medium difficulty puzzles. I added a makeGuess() function which attempts to solve the puzzle when the algorithm gets stuck and doesn't eliminate any more solutions.

I created a GUI using Swing in Java so that user input can be used as a way to set values of cells and solve the puzzle. 
