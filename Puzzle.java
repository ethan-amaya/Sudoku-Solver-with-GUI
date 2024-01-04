import java.util.ArrayList;
import java.util.Arrays;
public class Puzzle {

    public Boolean puzzleSolved() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!grid[i][j].isSolved()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Puzzle() {
        grid = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                grid[i][j] = new Cell();
        }

/*
      grid[0][1].setValue(5);
        grid[0][7].setValue(7);
        grid[0][8].setValue(9);
        grid[1][2].setValue(3);
        grid[1][5].setValue(8);
        grid[1][6].setValue(1);
        grid[2][0].setValue(2);
        grid[2][1].setValue(9);
        grid[2][4].setValue(6);
        grid[2][5].setValue(4);
        grid[2][6].setValue(5);
        grid[3][0].setValue(5);
        grid[3][2].setValue(6);
        grid[3][3].setValue(4);
        grid[3][7].setValue(1);
        grid[3][8].setValue(3);
        grid[4][1].setValue(2);
        grid[4][3].setValue(9);
        grid[4][5].setValue(5);
        grid[4][6].setValue(6);
        grid[4][8].setValue(7);
        grid[5][5].setValue(3);
        grid[6][6].setValue(3);
        grid[6][7].setValue(4);
        grid[7][5].setValue(9);
        grid[7][6].setValue(7);
        grid[7][7].setValue(2);
        grid[8][0].setValue(4);
        grid[8][3].setValue(2);
        grid[8][8].setValue(1);

*/




    }

    public Puzzle(Puzzle p){
        grid = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                grid[i][j] = new Cell(p.grid[i][j]);
        }
    }

        public Cell[][] grid;

    public Cell[] getRow(int index)
    {
        Cell[] row = new Cell[9];
        for(int i = 0; i < 9; i++)
        {
            row[i] = grid[index][i];
        }

        return row;
    }

    public Cell[] getColumn(int index){
        Cell[] column = new Cell[9];
        for (int i = 0; i < 9; i++){
            column[i] = grid[i][index];
        }

        return column;
    }

    public void updateRow(int index, Cell[] row){
        for(int i = 0; i < 9; i++){
            grid[index][i] = row[i];
        }
    }

    public void updateColumn(int index, Cell[] column){
        for(int i = 0; i < 9; i++){
            grid[i][index] = column[i];
        }
    }

    public Cell[] getBox(int index){
        Cell[] box = new Cell[9];
        int counter = 0;
        int startRow = (index / 3) * 3;
        int startColumn = (index % 3) * 3;

        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startColumn; col < startColumn + 3; col++) {
                box[counter] = grid[row][col];
                counter++;
            }
        }
        return box;
    }

    public void updateBox(int index, Cell[] box){
        int counter = 0;
        int startRow = (index / 3) * 3;
        int startColumn = (index % 3) * 3;

        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startColumn; col < startColumn + 3; col++) {
                grid[row][col] = box[counter];
                counter++;
            }
        }
    }

    public void checkRows(){
        for (int i = 0; i < 9; i++) {
            Cell[] row = getRow(i);
            ArrayList<Integer> valuesToRemove = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if (row[j].isSolved()) {
                    int value = row[j].value;
                    valuesToRemove.add(value);
                }
            }

            for (int value : valuesToRemove) {
                for (int j = 0; j < 9; j++) {
                    if (!row[j].isSolved()) {
                        row[j].removeValue(value);
                    }
                }
            }
            updateRow(i, row);
        }
    }

    public void checkColumns(){
        for (int i = 0; i < 9; i++) {
            Cell[] column = getColumn(i);
            ArrayList<Integer> valuesToRemove = new ArrayList<>();

            for (int j = 0; j < 9; j++) {
                if (column[j].isSolved()) {
                    int value = column[j].value;
                    valuesToRemove.add(value);
                }
            }

            for (int value : valuesToRemove) {
                for (int j = 0; j < 9; j++) {
                    if (!column[j].isSolved()) {
                        column[j].removeValue(value);
                    }
                }
            }
            updateColumn(i, column);
        }
}

    public void checkBoxes() {
        for (int i = 0; i < 9; i++) {
            Cell[] box = getBox(i);
            ArrayList<Integer> valuesToRemove = new ArrayList<>();

            for (int j = 0; j < 9; j++) {
                if (box[j].isSolved()) {
                    int value = box[j].value;
                    valuesToRemove.add(value);
                }
            }

            for (int value : valuesToRemove) {
                for (int j = 0; j < 9; j++) {
                    if (!box[j].isSolved()) {
                        box[j].removeValue(value);
                    }
                }
            }
            updateBox(i, box);
        }
    }

    public void print(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(grid[i][j].toString());
            }
            System.out.println();
        }
    }

    public Integer countSolved(){
        int solvedCounter = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(grid[i][j].isSolved()){
                    solvedCounter++;
                }
            }
        }
        return solvedCounter;
    }

    public static void solvePuzzle(Puzzle puzzle) {
        while (!puzzle.puzzleSolved()) {
            int cellSolvedBefore = puzzle.countSolved();
            puzzle.checkRows();
            puzzle.checkColumns();
            puzzle.checkBoxes();
            int cellSolvedAfter = puzzle.countSolved();
            if (cellSolvedBefore == cellSolvedAfter) {
                puzzle.makeGuess();
                break;
            }
        }
    }

    public void makeGuess() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Cell cell = grid[i][j];
                if (!cell.isSolved()) {
                    for (int value : cell.possibleValues) {
                        Puzzle copy = new Puzzle(this);
                        copy.grid[i][j].setValue(value);
                        solvePuzzle(copy);
                        if (copy.puzzleSolved()) {
                            grid = copy.grid;
                            return;
                        }
                    }
                }
            }
        }
    }
}
