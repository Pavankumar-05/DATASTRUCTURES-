public class detectLoop{
    Node head;
    int size;
    detectLoop(){
        size = 0;
    }
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
            size++;
        }
    }

    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /*public void printList(){
        if(head == null){
            System.out.println("List is empty");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }*/
    public boolean hasCycle(Node head){
        Node fast = head;
        Node slow = head;
        boolean flag = false; 
        while(fast != null && fast.next != null && slow != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
            flag = true;
            break;
            }

        }
        //System.out.println(flag);
        return flag;
    }
    
    
    public static void main(String[] args){
        detectLoop list = new detectLoop();
        list.push(20);
        list.push(4);
        list.push(15);
        list.push(10);
        //list.printList();
        //System.out.println("Size of linkedlist : "+list.size);
        list.head.next.next.next.next = list.head;
        boolean ans = list.hasCycle(list.head);
        System.out.println(ans);

    }
}