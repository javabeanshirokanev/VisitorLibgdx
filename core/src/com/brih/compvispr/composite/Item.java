package com.brih.compvispr.composite;

import com.brih.compvispr.visitor.Visitor;

public abstract class Item {
    public int resultCost;
    public float resultDefend;

    public abstract void accept(Visitor visitor);
}
