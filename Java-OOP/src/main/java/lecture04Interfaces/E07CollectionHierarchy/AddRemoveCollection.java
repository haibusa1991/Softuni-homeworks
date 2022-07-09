package lecture04Interfaces.E07CollectionHierarchy;

import java.util.List;

public class AddRemoveCollection extends Collection implements AddRemovable{
    List<String> items = super.getItems();

    @Override
    public String remove() {
        String item = this.items.get(this.items.size() - 1);
        this.items.remove(this.items.size() - 1);
        return item;
    }

    @Override
    public int add(String s) {
        this.items.add(0, s);
        return 0;
    }
}
