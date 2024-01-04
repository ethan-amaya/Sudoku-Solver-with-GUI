import java.util.ArrayList;
import java.util.Arrays;
public class Cell {

    public int value = 0;
    ArrayList<Integer> possibleValues;
    Boolean isSolved(){
        return value != 0;
    }
    public Cell(){
        possibleValues = new ArrayList<>();
        for (int i = 1; i < 10; i++){
            possibleValues.add(i);
        }
    }

    public Cell(Cell c){
        value = c.value;
        possibleValues = new ArrayList<>(c.possibleValues);
    }

    void setValue(int x){
        value = x;
        possibleValues.clear();
        possibleValues.add(x);
    }

    void removeValue(int x){
        for (int i = 0; i < possibleValues.size(); i++){
            if (x == possibleValues.get(i)){
                possibleValues.remove(i);
                break;
            }
        }
        if (possibleValues.size() == 1){
            setValue(possibleValues.get(0));
        }
    }

    public String toString(){
        return possibleValues.toString();
    }
}
