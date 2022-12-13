class ReverseList{
    Node head;
    private int size;
    ReverseList(){
        this.size = 0;
    }
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
            size++;//incrementing the size
        }
    }
    //inserting data at the beginning of the linkedlist
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    //inserting data at the end of the linkedlist
    public void addLast(int data){
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

    public void reverseIterate(){
        if(head == null)
        return;
        if(head.next == null)
        return;
        Node prev = head;
        Node curr = head.next;
        while(curr != null){
            Node nextNode = curr.next;
            curr.next = prev;
            //updation
            prev = curr;
            curr = nextNode;
        }
        head.next = null;
        head = prev;
    }

    public Node reverseRecursive(Node head){
        if(head == null || head.next == null)
            return head;
        Node newHead = reverseRecursive(head.next);
        head.next.next = head; 
        head.next = null;
        return newHead;
    }

    public static void main(String args[]){
        ReverseList list = new ReverseList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.printList();
        list.reverseIterate();
        list.printList();
        list.head = list.reverseRecursive(list.head);
        list.printList();
    }
}



/*

import java.util.*;
public class Main
{
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(1);
		list.add(2);
		list.addFirst(0);
		list.add(3);
		list.add(4);
		System.out.println(list.size());
		for(int i = list.size()-1;i >= 0;i--){
		    System.out.print(list.get(i)+" -> ");
		}
		System.out.println("NULL");
	}
}


*/