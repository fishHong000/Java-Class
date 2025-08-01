// a link list is a data structure, remove from head, add to tail
public class LinkList {
    Node head, tail; // list�@�}�l�O�Ū��A����head == tail == null
    // add to tail
    public void add(int v) {
        if (tail == null) { // �p�Glist�O�Ū�
            head = tail = new Node(v);
        } else { // ���O�Ū�
            Node tmp = new Node(v);
            // ->...->...-> lastNode    new Node
            //                 ^
            //          tail --|
            // �n�ܦ��o��
            // ->...->...-> lastNode "-->" new Node
            //                 ^
            //          tail --|
            tail.next = newNode;
            // ==> �A�ܦ��o��
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
        if (head == null) { // �p�G�����̫�@�ӡAlist�ŤF
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