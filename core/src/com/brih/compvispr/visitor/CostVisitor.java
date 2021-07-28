package com.brih.compvispr.visitor;

import com.brih.compvispr.composite.GroupItem;
import com.brih.compvispr.composite.GroupMultItem;
import com.brih.compvispr.composite.Item;
import com.brih.compvispr.composite.Ring;

public class CostVisitor implements Visitor {
    @Override
    public void visitRing(Ring item) {
        item.resultCost = item.getCost();
    }

    @Override
    public void visitGroupItem(GroupItem item) {
        int sum = 0;
        for(Item locitem : item.getItems().iterator()) {
            if(locitem instanceof Ring) {
                Ring ring = (Ring)locitem;
                sum += ring.getCost();
                continue;
            }
            if(locitem instanceof GroupItem) {
                GroupItem group = (GroupItem)locitem;
                visitGroupItem(group);
                sum += group.resultCost;
                continue;
            }
            if(locitem instanceof GroupMultItem) {
                GroupMultItem group = (GroupMultItem)locitem;
                visitGroupMultItem(group);
                sum += group.resultCost;
            }
        }
        item.resultCost = sum;
    }

    @Override
    public void visitGroupMultItem(GroupMultItem item) {
        int sum = 0;
        for(Item locitem : item.getItems().iterator()) {
            if(locitem instanceof Ring) {
                Ring ring = (Ring)locitem;
                sum += ring.getCost();
                continue;
            }
            if(locitem instanceof GroupItem) {
                GroupItem group = (GroupItem)locitem;
                visitGroupItem(group);
                sum += group.resultCost;
                continue;
            }
            if(locitem instanceof GroupMultItem) {
                GroupMultItem group = (GroupMultItem)locitem;
                visitGroupMultItem(group);
                sum += group.resultCost;
            }
        }
        item.resultCost =  sum + item.getInnerCost();
    }
}
