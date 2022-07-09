package lecture04Interfaces.E07CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

 abstract class Collection {
    private int maxSize;
    private List<String> items;

     public Collection() {
         this.maxSize=100;
         this.items= new ArrayList<>();
     }


    public List<String> getItems(){
         return this.items;
    }

}
