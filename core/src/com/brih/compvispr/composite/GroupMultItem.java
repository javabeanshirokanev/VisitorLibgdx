package com.brih.compvispr.composite;

import com.badlogic.gdx.utils.Array;
import com.brih.compvispr.visitor.Visitor;

public class GroupMultItem extends Item {
    private Array<Item> items;
    private int innerCost;

    public Array<Item> getItems() {
        return items;
    }

    public int getInnerCost() {
        return innerCost;
    }

    public GroupMultItem(int innerCost) {
        items = new Array<>();
        this.innerCost = innerCost;
    }

    public void add(Item item) {
        items.add(item);
    }
    public void remove(Item item) {
        items.removeValue(item, false);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitGroupMultItem(this);
    }
}
