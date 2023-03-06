import java.util.ArrayList;

class Node {
    public int val;
    public Node next;
    Node(){}

    Node(int val){
        this.val = val;
    }

    Node(int val, Node next){
        this.val = val;
        this.next = next;
    }

}

public class MyLinkedList {
    private Node head;
    private Node tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public int get(int index) {
        int val = -1;
        if (index < 0 || index >= size()) {
            return val;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val, head);
        head = newNode;
    }

    public void addAtTail(int val) {
        if(head == null) {
            addAtHead(val);
        }else {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            Node newNode = new Node(val);
            temp.next = newNode;

        }
    }

    public void addAtIndex(int index, int val) {
        if(index > size()){
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == size()){
            addAtTail(val);
            return;
        }
        Node node = head;
        Node newNode = new Node(val);
        while(node != null && index >1){
            node = node.next;
            index--;
        }
        newNode.next = node.next;
        node.next = newNode;

    }

    public void deleteAtHead(){
        head = head.next;
    }

    public void deleteAtIndex(int index) {
        if(index >= size()){
            return;
        }
        if(index == 0){
            deleteAtHead();
            return;
        }
        Node node = head;
        while(node != null && index > 1){
            node = node.next;
            index--;
        }

        node.next = node.next.next;
        if(node.next == null){
            tail = node;
        }
    }

    @Override
    public String toString(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size(); i++){
            list.add(get(i));
        }
        return list.toString() + " <- This is myLinkedList";
    }


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(3);
//        linkedList.addAtTail(4);
//        linkedList.addAtTail(10);
//        linkedList.addAtHead(3);

      //  linkedList.addAtTail(10);
        //System.out.println(linkedList.get(1) + " gotten element");
      //  linkedList.addAtIndex(1,5);

       // System.out.println(linkedList.size() + " before deleting,"  + " list itself: " + linkedList.toString() );
     //  linkedList.deleteAtIndex(1);
       // linkedList.addAtTail(4);
       // linkedList.addAtIndex(1,2);
      //  System.out.println(linkedList.size() + " <- size of the list" + " after deleting," + " list itself: " + linkedList.toString());

        //linkedList.addAtIndex(1,100);
      //  System.out.println(linkedList.size() + " <- size of the list " + linkedList.toString());


     //   ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        System.out.println(linkedList.toString() + " after adding 3 numbers at head");
        linkedList.addAtTail(10);
        System.out.println(linkedList.toString() + " after adding 3 numbers at head and 1 at tail");
        linkedList.addAtIndex(3,0);
        System.out.println(linkedList.toString() + " after adding at index 3, 0");
        linkedList.deleteAtIndex(2);
        System.out.println(linkedList.toString() + " after deleting at index 2");
        linkedList.addAtHead(6);
        System.out.println(linkedList.toString() +  " after adding 6 at head");
        linkedList.addAtTail(4);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.get(4));
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5,0);
        linkedList.addAtHead(6);


        System.out.println(linkedList.size() + " <- size of the list " + linkedList.toString());
    }
}

