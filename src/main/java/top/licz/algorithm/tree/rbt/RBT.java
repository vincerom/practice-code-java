package top.licz.algorithm.tree.rbt;

import static top.licz.algorithm.tree.rbt.IST.EMPTY;

/**
 * 红黑树
 */
public class RBT<T> {

    private Node<T> root;
    private static final boolean BLACK = true;
    private static final boolean RED = false;

    public RBT() {
    }

    public void add(int key, T value) {
        // 1 tree is empty
        if (root == null) {
            root = new Node<>(BLACK, key, value);
            root.value = value;
            return;
        }
        // tree is not empty
        // insert a node
        Node<T> n = insertNode(key, value);
        // 2 key is exist
        n.value = value;
        // 3 father is black, finish
        if (n.father.isBlack()) {
            return;
        }
        // 4 father is red
        fixedInsert(n);
    }

    private void fixedInsert(Node<T> n) {
        if (n == root) {
            return;
        }
        if (n.father.isBlack()) {
            return;
        }

        Node<T> p = n.father;
        Node<T> pp = p.father;
        Node<T> u;
        boolean pIsLeft = true;
        if (p.leftChild == p) {
            u = p.rightChild;
        } else {
            pIsLeft = false;
            u = p.leftChild;
        }

        // 4.1 uncle is red
        if (u.isRed()) {
            u.color = BLACK;
            p.color = BLACK;
            pp.color = RED;
            fixedInsert(pp);
        }

        boolean nIsLeft = true;
        if (p.rightChild == n) {
            nIsLeft = false;
        }

        // 4.2 uncle is black or null, father is left
        // 4.2.1 n is left
        if (u.isBlack() && pIsLeft && nIsLeft) {
            p.color = BLACK;
            pp.color = RED;
            rightRotate(pp);
            return;
        }

        // 4.2.2 n is right
        if (u.isBlack() && pIsLeft && !nIsLeft) {
            leftRotate(p);
            fixedInsert(p);
        }

        // 4.3 uncle is black or null, father is right
        // 4.3.1 n is left
        if (u.isBlack() && !pIsLeft && nIsLeft) {
            rightRotate(p);
            fixedInsert(p);
        }

        // 4.3.2 n is right
        if (u.isBlack() && !pIsLeft && !nIsLeft) {
            p.color = BLACK;
            pp.color = RED;
            leftRotate(p);
            return;
        }


    }

    private void leftRotate(Node<T> n) {
        Node<T> rc = n.rightChild;
        Node<T> rclc = rc.leftChild;
        Node<T> f = n.father;

        if (f == null) {
            root = rc;
        } else if (f.leftChild == n) {
            f.leftChild = rc;
            rc.father = f;
        } else if (f.rightChild == n) {
            f.rightChild = rc;
            rc.father = f;
        }

        rc.leftChild = n;
        n.father = rc;

        n.rightChild = rclc;
        rclc.father = n;
    }

    private void rightRotate(Node<T> n) {
        Node<T> lc = n.leftChild;
        Node<T> lcrc = n.leftChild.rightChild;
        Node<T> f = n.father;

        if (f == null) {
            root = lc;
        } else if (f.rightChild == n) {
            f.rightChild = lc;
        } else if (f.leftChild == n) {
            f.leftChild = lc;
        }

        lc.rightChild = n;
        n.father = lc;

        n.leftChild = lcrc;
        lcrc.father = n;
    }

    private void changeColor(Node<T> p, boolean color) {
        p.color = color;
    }

    private Node<T> findNode(int key) {
        Node<T> p = root;
        while (p != null) {
            if (p.key == key) {
                return p;
            }
            if (p.key > key) {
                p = p.leftChild;
                continue;
            }
            p = p.rightChild;
        }
        return null;
    }

    /**
     * 增加节点，会破坏平衡
     *
     * @param key   key
     * @param value value
     * @return if key exists
     */
    private Node<T> insertNode(int key, T value) {
        Node<T> n = new Node<>(RED, key, value);
        Node<T> p = root;
        while (true) {
            if (p.key > key) {
                if (p.leftChild == null) {
                    p.leftChild = n;
                    n.father = p;
                    return n;
                }
                p = p.leftChild;
                continue;
            }
            if (p.key < key) {
                if (p.rightChild == null) {
                    p.rightChild = n;
                    n.father = p;
                    return n;
                }
                p = p.rightChild;
                continue;
            }
            break;
        }
        return p;
    }

    private Node<T> removeNode(int key) {
        Node<T> q = root;

        // todo not finish yet
        return null;
    }


    public void printRbt() {
        System.out.println();
    }

    /**
     * 红黑树的节点
     *
     * @param <T>
     */
    static class Node<T> {

        private boolean color;
        private Node<T> father;
        private Node<T> leftChild;
        private Node<T> rightChild;
        private int key;
        private T value;

        public Node(boolean color, int key, T value) {
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public Node() {
        }

        public boolean isBlack() {
            return this.color == BLACK;
        }

        public boolean isRed() {
            return this.color == RED;
        }

    }


}


enum IST {

    EMPTY,


}