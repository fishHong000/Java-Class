// a link list is a data structure, remove from head, add to tail
public class LinkList {
    Node head, tail; // list一開始是空的，此時head == tail == null
    // add to tail
    public void add(int v) {
        if (tail == null) { // 如果list是空的
            head = tail = new Node(v);
        } else { // 不是空的
            Node tmp = new Node(v);
            // ->...->...-> lastNode    new Node
            //                 ^
            //          tail --|
            // 要變成這樣
            // ->...->...-> lastNode "-->" new Node
            //                 ^
            //          tail --|
            tail.next = newNode;
            // ==> 再變成這樣
            // ->...->...-> lastNode --> new Node
            //                         "  ^"
            //                    tail "--|"    
            tail = newNode;
        }
    }
    // remove from head
    public int remove() {
        int v = head.val;
        head = head.next;
        if (head == null) { // 如果移走最後一個，list空了
            tail = null;
        }
        return v;
    }
    public boolean isEmpty() {
        if(head == null) {
            return true;
        } else {
            return false;
        }
    }
}
class Node {
    int val;
    Node next; // point to next node in this list
    public Node(int v) {
        this.val = v;
        this.next = null;
}