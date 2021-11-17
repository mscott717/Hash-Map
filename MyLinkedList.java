/** Linked List Lab
 * Made by Toby Patterson 5/31/2020
 * For CS165 at CSU
 */

public class MyLinkedList<E> implements MiniList<E>{
    /* Private member variables that you need to declare:
     ** The head pointer
     ** The tail pointer
     */
    Node head;
    Node tail;
    int listSize = 0;

    public class Node {
        // declare member variables (data, prev and next)
        E data;
        Node next;
        Node prev;


        // finish these constructors
        public Node(E data, Node prev, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        public Node(E data) {
            this(data, null, null);
        } // HINT: use this() with next = prev = null
    }

    // Initialize the head and tail pointer
    public MyLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public boolean add(E item) {
        Node n = new Node(item);
        if(head == null){//if list is empty
            head = n;
            tail = n;
            listSize++;
            return true;
        }
        else{
            n.prev = tail;
            tail.next = n;
            tail = n;
            listSize++;
            return true;
        }
    }

    @Override
    public void add(int index, E element) {
        int counter = 0;
        Node curr = head;
        Node sucNode;
        Node predNode;

        while(curr!=null){
            if(counter == index){
                Node n = new Node(element);
                sucNode = curr.next;
                predNode = curr.prev;
                predNode.next = n;
                n.next = curr;

            }
            curr = curr.next;
            counter++;
        }
        listSize++;
    }

    @Override
    public E remove() {
        if(head!=null){
            Node n = head;
            head = head.next;
            listSize--;
            return n.data;
        }
        return null;
    }

    private Node getNode(int index) {

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public E remove(int index) {
        Node curr = getNode(index);
        Node sucNode;
        Node predNode;

        if(head == null){
            return null;
        }
        else if(index == 0){
            head = head.next;
            head.prev = null;
            listSize--;
            return curr.data;
        }
        else if(index == listSize-1){
            tail = tail.prev;
            tail.next = null;
            listSize--;
            return curr.data;
        }

        else{//Draw it out!

                    predNode = getNode(index-1);
                    sucNode = getNode(index +1);
                    sucNode.prev = predNode;
                    predNode.next = sucNode;
        }
        listSize--;
        return curr.data;
    }

    @Override
    public boolean remove(E item) {
        Node sucNode;
        Node predNode;

        if(head == null){
            return false;
        }
        if(item == tail.data){//if item is at the end of the list
            tail = tail.prev;
            tail.next = null;
            listSize--;
            return true;
        }

        Node curr = head;
        int counter = 0;

        while (curr!=null){
            if(curr.data == item){
                predNode = getNode(counter-1);
                sucNode = getNode(counter +1);
                sucNode.prev = predNode;
                predNode.next = sucNode;
            }
            curr = curr.next;
            counter++;
        }
        listSize--;
        return true;
    }

    @Override
    public void clear() {
        head = null;
        listSize = 0;
    }

    @Override
    public boolean contains(E item) {
        Node curr = head;

        while(curr != null){
            if(curr.data == item){
                return true;
            }
            else{
                curr = curr.next;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        Node curr = head;
        int counter = 0;

        while(curr != null){
            if(counter == index){
                return curr.data;
            }
            counter++;
            curr = curr.next;
        }
        return null;
    }

    @Override
    public int indexOf(E item) {
        Node curr = head;
        int counter = 0;

        while(curr!=null){
            if(curr.data == item){
                return counter;
            }
            counter++;
            curr = curr.next;
        }
        return -1;//if item is not found in the list
    }

    @Override
    public boolean isEmpty() {
        if(head == null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int size() {
        return listSize;
    }

//
//     Uncomment when ready to test
    @Override
    public String toString() {
        String ret = "";
        Node curr = head;
        while (curr != null) {
            ret += curr.data + " ";
            curr = curr.next;
        }
        return ret;
    }

}