package your_code;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Chicken val;
        Node prev;
        Node next;

        private Node(Chicken d, Node prev, Node next) {
            this.val = d;
            this.prev = prev;
            this.next = next;
        }

        private Node(Chicken d) {
            this.val = d;
            prev = null;
            next = null;
        }
    }

    public MyLinkedList() {
        head= null;
        tail=null;
        size=0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Chicken c) {
        addLast(c);
    }

    public Chicken pop() {
        return removeLast();
    }

    public void addLast(Chicken c) {
        if (size==0){
            Node addC= new Node(c, null, null);
            head=addC;
            tail=addC;
            size=1;
        }else{
            Node addC1= new Node(c, null, null);
            addC1.val=c;
            addC1.prev=tail;
            tail.next=addC1;
            tail=addC1;
            size++;
        }
    }

    public void addFirst(Chicken c) {
        if (size==0){
            Node addC=new Node(c, null, null);
            head=addC;
            tail=addC;
            size=1;
        }else{
            Node addC= new Node(c, null, null);
            addC.val=c;
            addC.next=head;
            head.prev=addC;
            head=addC;
            size++;
        }
    }

    public Chicken get(int index) {
        Node mainN=head;
        for(int i =0; i<index; i++){
            mainN=mainN.next;
        }
        return mainN.val;
    }

    public Chicken remove(int index) {
        Node mainN=head;
        if(index==0){
            return removeFirst();
        }else if(index==size-1){
            return removeLast();
        }
        for(int i =0; i<index; i++){
            mainN=mainN.next;
        }
        size--;
        mainN.prev.next=mainN.next; //skipping over mainN, so it never gets hit in either direction
        mainN.next.prev=mainN.prev;
        return mainN.val;
    }

    public Chicken removeFirst() {
        if(size==0){
            return null;
        }
        Chicken deadchick=head.val;
        head=head.next;
        size--;
        if(size!=0){
        head.prev=null;}
        return deadchick;
    }

    public Chicken removeLast() {
        if (size==0){
            return null;
        }
        Chicken deadchick=tail.val;
        tail=tail.prev;
        size--;
        if(size!=0){
        tail.next=null;}
        return deadchick;
    }
}