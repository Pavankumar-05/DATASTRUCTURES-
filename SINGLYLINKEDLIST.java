class SINGLYLINKEDLIST{
    Node head;
    private int size;
    SINGLYLINKEDLIST(){
        this.size = 0;
    }
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
            size++;//incrementing the size
        }
    }
    //inserting data at the beginning of the linkedlist
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    //inserting data at the end of the linkedlist
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next!=null)
            temp = temp.next;
        temp.next = newNode;
    }
    public void addMiddle(String data,int pos){
        Node newNode = new Node(data);
        if(pos == 0){
            newNode.next = head;
            head = newNode;
            return;
        }
        Node prev = head;
        for(int i=0;i<pos-1;i++){
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
    }
    //Displaying the data present in the linkedlist
    public void printList(){
        if(head == null){
            System.out.println("List is empty");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    //Deleting a node from the linkedlist
    public void deleteFirst(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        size--;
        head = head.next;
    }
    public void deleteMiddle(int pos){
        if(pos == 0){
            head = head.next;
            return;
        }
        Node prev = head;
        for(int i=0;i<pos-1;i++)
            prev = prev.next;
        prev.next = prev.next.next;
    }

    public void deleteByKey(String key){
        Node curr = head,prev = null;
        if(curr != null && curr.data == key){
            head = curr.next;
            System.out.println(key + " found and deleted");
            return;
        }
        while(curr != null && curr.data != key){
            prev = curr;
            curr = curr.next;
        }
        if(curr != null){
            prev.next = curr.next;
            System.out.println(key + " found and deleted");
        }
        if (curr == null) {
            System.out.println(key + " not found");
        }
    }
    //Deleting a node from the last
    public void deleteLast(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        size--;
        if(head.next==null){
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        
        secondLast.next = null;
    }
    //Returns the size pf the array
    public int getSize(){
        return size;
    }
    public static void main(String args[]){
        SINGLYLINKEDLIST list = new SINGLYLINKEDLIST();
        list.addFirst("a");
        list.addFirst("is");
        list.printList();
        list.addLast("list");
        list.printList();
        list.addFirst("This");
        list.printList();
        list.deleteFirst();
        list.deleteLast();
        list.printList();
        System.out.println(list.getSize());
        list.addFirst("This");
        System.out.println(list.getSize());
        list.addMiddle("Hello",2);
        list.printList();
        list.deleteMiddle(1);
        list.printList();
        list.deleteByKey("Hello");
        list.printList();
    }
}