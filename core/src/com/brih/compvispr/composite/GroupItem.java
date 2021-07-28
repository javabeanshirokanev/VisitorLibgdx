package com.brih.compvispr.composite;

import com.badlogic.gdx.utils.Array;
import com.brih.compvispr.visitor.Visitor;

public class GroupItem extends Item {
    private Array<Item> items;

    public Array<Item> getItems() {
        return items;
    }

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
    public void accept(Visitor visitor) {
        visitor.visitGroupItem(this);
    }
}
