import javax.swing.*;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
/*
        Puzzle p = new Puzzle();

        System.out.println("Solving...");
        System.out.println();

        while (!p.puzzleSolved()) {
            try {
                int cellSolvedBefore = p.countSolved();
                p.checkRows();
                p.checkColumns();
                p.checkBoxes();
                int cellSolvedAfter = p.countSolved();
                if(cellSolvedBefore == cellSolvedAfter){
                    System.out.println("Making guess");
                    p.makeGuess();
                    break;
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("Error occurred while solving the puzzle.");
                break;
            }
            p.print();
            System.out.println();
        }

        if (p.puzzleSolved()) {
            System.out.println("Sudoku solved!");
            System.out.println();
            p.print();
        } else {
            System.out.println();
            System.out.println("Unable to solve the Sudoku puzzle.");
        }

    }

 */


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SudokuSolverGUI().setVisible(true);
            }
        });

    }


}