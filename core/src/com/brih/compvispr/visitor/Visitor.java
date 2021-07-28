package com.brih.compvispr.visitor;

import com.brih.compvispr.composite.GroupItem;
import com.brih.compvispr.composite.GroupMultItem;
import com.brih.compvispr.composite.Ring;

public interface Visitor {
    void visitRing(Ring item);
    void visitGroupItem(GroupItem item);
    void visitGroupMultItem(GroupMultItem item);
}
