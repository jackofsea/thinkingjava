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
        //单链表测试
        // testSingleList();
        //双向链表测试
        //  testDoubleList();
        //单向循环链表
        testSingleCycleList();


    }

    public static void testSingleCycleList() {
        SingleCycleList cycleList = new SingleCycleList();
        cycleList.add(6);
        cycleList.add(7);
        cycleList.add(8);
        cycleList.add(9);
    }

    public static void testSingleList() {
        DoubleList doubleList = new DoubleList();
        doubleList.add(8);
        doubleList.add(5);
        doubleList.add(5);
        doubleList.add(8);
        doubleList.add(9);
        doubleList.addBytail(20);
        doubleList.display();
        doubleList.delete(8);
        doubleList.addBytail(28);
        doubleList.addBytail(22);
        doubleList.display();
        doubleList.insert(0, 6);
        doubleList.insert(3, 6);
        doubleList.insert(8, 6);
        doubleList.display();
    }

    public static void testDoubleList() {
        SingleList singleList = new SingleList();
        singleList.add(2);
        singleList.add(4);
        singleList.add(7);
        singleList.add(9);
        singleList.delete(7);
        singleList.display();
        singleList.insert(1, 12);
        singleList.display();
        singleList.insert(3, 6);
        singleList.display();
        singleList.insert(6, 44);
        singleList.display();
        singleList.delete(4);
        singleList.display();
        System.out.println("\n" + singleList.lookUp(12));
        singleList.addBytail(99);
        singleList.addBytail(11);
        singleList.display();
        singleList.delete(44);
        singleList.add(0);
        singleList.display();
    }

}


/**
 * 单链表，不带头结点
 */
class SingleList {
    private NodeSimple head;
    private int size = 0;

    static class NodeSimple {
        private int val;
        private NodeSimple next;

        public NodeSimple(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    /**
     * 头部插入
     *
     * @param val
     */
    public void add(int val) {
        NodeSimple nodeSimple = new NodeSimple(val);
        nodeSimple.next = head;
        head = nodeSimple;
        size++;
    }

    /**
     * 尾部插入
     *
     * @param val
     */
    public void addBytail(int val) {
        if (head == null) {
            add(val);
            return;
        }
        NodeSimple nodeSimple = new NodeSimple(val);
        NodeSimple root = head;
        NodeSimple pre = null;
        while (root != null) {
            pre = root;
            root = root.next;
        }
        pre.next = nodeSimple;
        size++;
    }

    /**
     * 链表插入，指定位置
     *
     * @param location
     */
    public void insert(int location, int val) {
        if (location - 1 < 0 || size <= location - 1) {
            return;
        }
        if (location == 1) {
            add(val);
            return;
        }
        NodeSimple nodeSimple = new NodeSimple(val);
        NodeSimple root = head;
        NodeSimple pre = null;
        for (int i = 1; i <= location; i++) {
            if (i == location) {
                nodeSimple.next = pre.next;
                pre.next = nodeSimple;
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
    public NodeSimple lookUp(int val) {
        NodeSimple root = head;
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            root = root.next;
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 打印链表
     */
    public void display() {
        System.out.println("\n ------ 单项链表----------");
        NodeSimple root = head;
        while (root != null) {
            System.out.print(" " + root.val);
            root = root.next;
        }

    }
}

/**
 * 单项循环链表
 */
class SingleCycleList {
    private Node head;
    private Node tail;

    static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    /**
     * 头部插入
     *
     * @param val
     */
    public void add(int val) {
        Node node = new Node(val);
        Node tmp = head;
        if (tmp == null) {
            head = node;
            tail = node;
            tail.next=head;
        } else {
          node.next=head;
          tail.next=node;
          head=node;
        }

    }

    /**
     * 打印链表
     */
    public void display() {
        System.out.println("\n ------ 单项链表----------");
        Node root = head;
        while (root != null) {
            System.out.print(" " + root.val);
            root = root.next;
        }

    }
}


/**
 * 双向链表
 */
class DoubleList {
    private NodeDoule head;
    private int size = 0;

    static class NodeDoule {
        private int val;
        private NodeDoule pre;
        private NodeDoule next;

        public NodeDoule(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    /**
     * 添加，头插法
     *
     * @param val
     */
    public void add(int val) {
        NodeDoule node = new NodeDoule(val);
        if (!isEmpty()) {
            node.next = head;
            head.pre = node;
        }
        head = node;
        size++;
    }

    /**
     * 添加，尾插法
     *
     * @param val
     */
    public void addBytail(int val) {
        if (isEmpty()) {
            add(val);
            return;
        }
        NodeDoule node = new NodeDoule(val);
        NodeDoule nodeDoule = loopUpAt(size);
        nodeDoule.next = node;
        node.pre = nodeDoule;
        size++;
    }

    /**
     * 查找指定位置的数据
     *
     * @param location
     */
    public NodeDoule loopUpAt(int location) {
        if (location - 1 < 0 || size <= location - 1) {
            return null;
        }
        NodeDoule root = head;
        for (int i = 1; i <= location; i++) {
            if (i == location) {
                return root;
            }
            root = root.next;
        }
        return null;
    }


    /**
     * 双向链表，插入
     *
     * @param location
     */
    public void insert(int location, int val) {
        if (location - 1 < 0 || size <= location - 1) {
            return;
        }
        if (location == 1) {
            add(val);
            return;
        }
        NodeDoule node = new NodeDoule(val);
        NodeDoule root = head;
        for (int i = 1; i <= location; i++) {
            if (i == location) {
                node.next = root;
                node.pre = root.pre;
                root.pre.next = node;
                root.pre = node;
                size++;
                break;
            }
            root = root.next;
        }
    }

    /**
     * 双向链表，删除节点
     *
     * @param val
     */
    public void delete(int val) {
        if (head == null) {
            return;
        }
        NodeDoule tmp = head;
        while (tmp != null) {
            if (tmp.val == val) {
                tmp.pre.next = tmp.next;
                tmp.next.pre = tmp.pre;
                size--;
            }
            tmp = tmp.next;
        }
    }

    /**
     * 链表查找
     *
     * @param val 数据
     * @return NodeDoule
     */
    public NodeDoule lookUp(int val) {
        NodeDoule root = head;
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            root = root.next;
        }
        return null;
    }

    /**
     * 判空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 链表打印
     */
    public void display() {
        System.out.println("\n--------双向链表--------");
        NodeDoule root = head;
        while (root != null) {
            System.out.print(" " + root.val);
            root = root.next;
        }

    }
}

