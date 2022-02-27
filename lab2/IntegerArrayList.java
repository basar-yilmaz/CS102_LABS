package lab2;
import java.util.ArrayList;
public class IntegerArrayList {

    ArrayList<IntegerArray> numbers;

    public IntegerArrayList() {
        numbers = new ArrayList<IntegerArray>();
    }

    public int getSize() {
        return numbers.size();
    }

    public IntegerArray getIntegerArrayAt(int index) {
        return numbers.get(index);
    }

    public void setIntegerArrayAt(int index, IntegerArray intArr) {
        numbers.set(index, intArr);
    }

    public void addIntegerArray(String number) {
        numbers.add(new IntegerArray(number));
    }

    public void removeIntegerArray(int index) {
        numbers.remove(index);
    }

    public void removeIntegerArray(IntegerArray intArr) {
        for (IntegerArray x: numbers) {
            if (x.equals(intArr))
                numbers.remove(x);
        }
    }

    public IntegerArray min(int start, int end) {
        IntegerArray min = numbers.get(start);
        for (int i = start+1; i < end; i++) {
            if (numbers.get(i).compareTo(min) < 0)
                min = numbers.get(i);
        }
        return min;
    }



    
}
