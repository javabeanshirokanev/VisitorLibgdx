package com.brih.compvispr.composite;

import com.brih.compvispr.visitor.Visitor;

public class Ring extends Item {
    private float defend;
    private int cost;

    public float getDefend() {
        return defend;
    }

    public int getCost() {
        return cost;
    }

    public Ring(float defend, int cost) {
        this.defend = defend;
        this.cost = cost;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRing(this);
    }
}
