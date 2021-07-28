package com.brih.compvispr.composite;

import com.badlogic.gdx.utils.Array;

public class GroupItem extends Item {
    private Array<Item> items;

    public GroupItem() {
        items = new Array<>();
    }

    public GroupItem(Array<Item> items) {
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
        float sum = 0;
        for(Item item : items.iterator()) {
            float locDef = item.calcShield();
            sum += locDef;
        }
        return sum;
    }
}
