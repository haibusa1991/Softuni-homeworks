package lecture04Interfaces.E07CollectionHierarchy;

import java.util.List;

public class MyListImpl extends Collection implements MyList {
    List<String> items = super.getItems();

    @Override
    public int add(String s) {
        this.items.add(0, s);
        return 0;
    }

    @Override
    public String remove() {
        String item = items.get(0);
        this.items.remove(0);
        return item;
    }

    @Override
    public int getUsed() {
        return this.items.size();
    }
}
