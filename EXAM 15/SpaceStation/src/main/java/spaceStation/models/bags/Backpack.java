package spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;

public class Backpack implements Bag{
    private Collection<String> items = new ArrayList<>();

    public Backpack() {
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }
}
