package com.ivanmagda;

import java.util.ArrayList;
import java.util.List;

/**
 * If a thread (1) calls the parent.addChild(child) method at the same time as another
 * thread (2) calls the child.setParent(parent) method, on the same parent and child instances,
 * a deadlock can occur. Here is some pseudo code that illustrates this:
 * <p>
 * Thread 1: parent.addChild(child); //locks parent
 * --> child.setParentOnly(parent);
 * <p>
 * Thread 2: child.setParent(parent); //locks child
 * --> parent.addChildOnly()
 */

public class TreeNode {
    TreeNode parent = null;
    List children = new ArrayList();

    public synchronized void addChild(TreeNode child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            child.setParentOnly(this);
        }
    }

    public synchronized void addChildOnly(TreeNode child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    public synchronized void setParent(TreeNode parent) {
        this.parent = parent;
        parent.addChildOnly(this);
    }

    public synchronized void setParentOnly(TreeNode parent) {
        this.parent = parent;
    }

}
