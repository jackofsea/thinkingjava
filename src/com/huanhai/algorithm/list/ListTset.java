package com.huanhai.algorithm.list;

/**
 * 链表
 *
 * @author 覃波
 * @version 1.0
 * @date 2021-02-23 11:26
 **/
public class ListTset {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.add(new SingleList.NodeSimple(2));
        singleList.add(new SingleList.NodeSimple(4));
        singleList.add(new SingleList.NodeSimple(7));
        singleList.add(new SingleList.NodeSimple(9));
        singleList.delete(7);
        singleList.display();
        singleList.insert(1, new SingleList.NodeSimple(12));
        singleList.display();
        singleList.insert(3, new SingleList.NodeSimple(6));
        singleList.display();
        singleList.insert(6, new SingleList.NodeSimple(44));
        singleList.display();
        singleList.delete(4);
        singleList.display();
        System.out.println("\n"+singleList.lookUp(12));
        singleList.addBytail( new SingleList.NodeSimple(99));
        singleList.addBytail( new SingleList.NodeSimple(11));
        singleList.display();
        singleList.delete(44);
        singleList.add(new SingleList.NodeSimple(0));
        singleList.display();

    }

}

/**
 * 单链表，不带头结点
 *
 */
class SingleList {
    private NodeSimple head;
    private int size = 1;

    static class NodeSimple {
        private int val;
        private NodeSimple next;

        public NodeSimple(int val) {
            this.val = val;
        }
        @Override
        public String toString(){
            return Integer.toString(val);
        }
    }

    /**
     * 头部插入
     *
     * @param node
     */
    public void add(NodeSimple node) {
        node.next = head;
        head = node;
        size++;
    }

    /**
     *  尾部插入
     * @param node
     */
    public void addBytail(NodeSimple node) {
        if(head==null){
            add(node);
            return;
        }
        NodeSimple root = head;
        NodeSimple pre=null;
        while (root!= null) {
            pre = root;
            root = root.next;
        }
        pre.next=node;
        size++;
    }

    /**
     * 链表插入，指定位置
     *
     * @param location
     */
    public void insert(int location, NodeSimple node) {
        if (location - 1 < 0 || size <= location - 1) {
            return;
        }
        if(location == 1){
            add(node);
            return;
        }
        NodeSimple root = head;
        NodeSimple pre=null;
        for (int i = 1; i <= location; i++) {
            if (i == location) {
                node.next = pre.next;
                pre.next = node;
                size++;
                break;
            }
            pre = root;
            root = root.next;
        }
    }

    /**
     * 删除节点
     *
     * @param val
     */
    public void delete(int val) {
        if (head == null) {
            return;
        }
        NodeSimple tmp = head;
        NodeSimple pre = null;
        while (tmp != null) {
            if (tmp.val == val) {
                pre.next = pre.next.next;
                size--;
                break;
            }
            pre = tmp;
            tmp = tmp.next;
        }
    }

    /**
     * 链表查找
     *
     * @param val
     * @return
     */
    public NodeSimple lookUp(int val){
        NodeSimple root = head;
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            root = root.next;
        }
        return null;
    }

    public void display() {
        System.out.println("\n----------------");
        NodeSimple root = head;
        while (root != null) {
            System.out.print(" " + root.val);
            root = root.next;
        }

    }
}
/**
 * 双向链表
 *
 */
class DoubleList {
    private NodeDoule head;
    private int size = 1;

    static class NodeDoule {
        private int val;
        private NodeDoule pre;
        private NodeDoule next;

        public NodeDoule(int val) {
            this.val = val;
        }
        @Override
        public String toString(){
            return Integer.toString(val);
        }
    }

    public void add(NodeDoule node) {
        node.next = head;
        head = node;
        size++;
    }

    /**
     * 链表插入
     *
     * @param location
     */
    public void insert(int location, NodeDoule node) {
        if (location - 1 < 0 || size <= location - 1) {
            return;
        }
        if(location == 1){
            add(node);
            return;
        }
        NodeDoule root = head;
        NodeDoule pre=null;
        for (int i = 1; i <= location; i++) {
            if (i == location) {
                node.next = pre.next;
                pre.next = node;
                size++;
                break;
            }
            pre = root;
            root = root.next;
        }
    }

    /**
     * 删除节点
     *
     * @param val
     */
    public void delete(int val) {
        if (head == null) {
            return;
        }
        NodeDoule tmp = head;
        NodeDoule pre = null;
        while (tmp != null) {
            if (tmp.val == val) {
                pre.next = pre.next.next;
                size--;
                break;
            }
            pre = tmp;
            tmp = tmp.next;
        }
    }

    public NodeDoule lookUp(int val){
        NodeDoule root = head;
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            root = root.next;
        }
        return null;
    }

    public void display() {
        System.out.println("\n----------------");
        NodeDoule root = head;
        while (root != null) {
            System.out.print(" " + root.val);
            root = root.next;
        }

    }
}