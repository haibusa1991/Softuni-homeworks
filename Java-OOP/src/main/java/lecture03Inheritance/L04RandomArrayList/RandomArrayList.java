package lecture03Inheritance.L04RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement() {
        Random r = new Random();
        int index = r.nextInt(this.size());
        T item = this.get(index);
        this.remove(index);
        return item;
    }
}
