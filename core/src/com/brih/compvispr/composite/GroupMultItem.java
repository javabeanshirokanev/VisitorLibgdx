package com.brih.compvispr.composite;

import com.badlogic.gdx.utils.Array;

public class GroupMultItem extends Item {
    private Array<Item> items;

    public GroupMultItem() {
        items = new Array<>();
    }

    public GroupMultItem(Array<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        items.add(item);
    }
    public void remove(Item item) {
        items.removeValue(item, false);
    }

    @Override
    public float calcShield() {
        float sum = 1;
        for(Item item : items.iterator()) {
            float locDef = item.calcShield();
            sum *= locDef;
        }
        return sum;
    }
}
