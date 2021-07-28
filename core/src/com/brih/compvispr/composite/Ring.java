package com.brih.compvispr.composite;

public class Ring extends Item {
    private float defend;

    public float getDefend() {
        return defend;
    }

    public Ring(float defend) {
        this.defend = defend;
    }

    @Override
    public float calcShield() {
        return defend;
    }
}
