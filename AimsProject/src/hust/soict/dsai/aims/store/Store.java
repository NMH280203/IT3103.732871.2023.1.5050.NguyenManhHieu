package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.*;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    public boolean addMedia(Media m){
        return itemsInStore.add(m);
    }

    public boolean removeMedia(Media m) {
        if (itemsInStore.contains(m)) {
            itemsInStore.remove(m);
            return true;
        } else {
            return false;
        }
    }

    public void displayStore() {
        for (Media m : itemsInStore) {
            System.out.println(m.toString());
        }
    }
    public Media searchInStore(String title) {
        for (Media m: itemsInStore){
            if(m.isMatch(title)){
                return m;
            }
        }
        return null;
    }
}