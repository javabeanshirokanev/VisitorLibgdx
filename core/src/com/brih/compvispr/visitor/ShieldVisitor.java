package com.brih.compvispr.visitor;

import com.brih.compvispr.composite.GroupItem;
import com.brih.compvispr.composite.GroupMultItem;
import com.brih.compvispr.composite.Item;
import com.brih.compvispr.composite.Ring;

public class ShieldVisitor implements Visitor {
    @Override
    public void visitRing(Ring item) {
        item.resultDefend = item.getDefend();
    }

    @Override
    public void visitGroupItem(GroupItem item) {
        int sum = 0;
        for(Item locitem : item.getItems().iterator()) {
            if(locitem instanceof Ring) {
                Ring ring = (Ring)locitem;
                sum += ring.getDefend();
                continue;
            }
            if(locitem instanceof GroupItem) {
                GroupItem group = (GroupItem)locitem;
                visitGroupItem(group);
                sum += group.resultDefend;
                continue;
            }
            if(locitem instanceof GroupMultItem) {
                GroupMultItem group = (GroupMultItem)locitem;
                visitGroupMultItem(group);
                sum += group.resultDefend;
            }
        }
        item.resultDefend = sum;
    }

    @Override
    public void visitGroupMultItem(GroupMultItem item) {
        int def = 1;
        for(Item locitem : item.getItems().iterator()) {
            if(locitem instanceof Ring) {
                Ring ring = (Ring)locitem;
                def *= ring.getDefend();
                continue;
            }
            if(locitem instanceof GroupItem) {
                GroupItem group = (GroupItem)locitem;
                visitGroupItem(group);
                def *= group.resultDefend;
                continue;
            }
            if(locitem instanceof GroupMultItem) {
                GroupMultItem group = (GroupMultItem)locitem;
                visitGroupMultItem(group);
                def *= group.resultDefend;
            }
        }
        item.resultDefend = def;
    }
}
