package top.licz.algorithm.list;

/**
 * 双向链表类
 *
 * @author vince
 */
public class DuplexList {

    public static void main(String[] args) {
        Node<Integer> node = Node.convertToNodes(new Integer[]{0, 1, 2, 3});
        node.add(5);
        node.add(4, 4);
        node.add(1, 0);
        node.del(1);
        node.printTree();
        System.out.println(node.get(9));
    }

}

/**
 * 双向链表节点
 */
class Node<T> {

    private Node<T> prev;

    private Node<T> next;

    private T data;

    public Node(Node<T> prev, Node<T> next, T data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    public Node() {
    }

    public void add(T data) {
        Node<T> p = this;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node<>(p, null, data);
    }

    public void add(int i, T data) {
        Node<T> p = this;
        int id = -1;
        while (p.next != null) {
            p = p.next;
            id++;
            if (i == id) {
                Node<T> n = new Node<>(p.prev, p, data);
                p.prev.next = n;
                p.prev = n;
            }
        }
    }

    public void del(int i) {
        Node<T> p = this;
        int id = -1;
        while (p.next != null) {
            p = p.next;
            id++;
            if (i != id) {
                continue;
            }
            if (p.next == null) {
                p.prev.next = null;
                return;
            }
            p.prev.next = p.next;
            p.next.prev = p.prev;
        }
    }

    public T get(int i) {
        Node<T> p = this;
        int id = -1;
        while (p.next != null) {
            p = p.next;
            id++;
            if (i == id) {
                return p.data;
            }
        }
        throw new IndexOutOfBoundsException("try to get element in index: " + i + ", list size: " + (id + 1));
    }

    public void printTree() {
        Node<T> p = this.next;
        do {
            System.out.print(p.data + " ");
            p = p.next;
        } while (p != null);
    }

    // 必须定义<T>，静态方法不能访问类定义的泛型
    public static <T> Node<T> convertToNodes(T[] nums) {
        Node<T> h = new Node<>();
        Node<T> p = h;
        for (T num : nums) {
            Node<T> n = new Node<T>(p, null, num);
            p.next = n;
            p = n;
        }
        return h;
    }
}
