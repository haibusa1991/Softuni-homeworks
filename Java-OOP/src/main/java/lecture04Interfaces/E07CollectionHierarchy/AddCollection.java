package lecture04Interfaces.E07CollectionHierarchy;

import java.util.List;

public class AddCollection extends Collection implements Addable {
    List<String> items = super.getItems();


    @Override
    public int add(String s) {
        this.items.add(s);
        return this.items.size() - 1;
    }
}
