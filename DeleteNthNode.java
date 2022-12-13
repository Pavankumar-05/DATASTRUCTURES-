import java.util.*;
public class DeleteNthNode
{
    Node head;
    int size;
    DeleteNthNode(){
        size = 0;
    }
    
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            size++;
        }
    }
    
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    
    public void addLast(int data){
        Node newNode = new Node(data);
        
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    
    public void printList(){
        if(head == null)
            System.out.println("List is empty");
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    
    public void deleteNth(int n){
        int pos = size - n;
        System.out.println(pos);
        if(size < n){
            System.out.println("Not possible");
            return;
        }
        if(pos == 0){
            head = head.next;
            return;
        }
        Node prev = head;
        for(int i=0;i<pos-1;i++){
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }
    
	public static void main(String[] args) {
		DeleteNthNode list = new DeleteNthNode();
		list.addFirst(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.printList();
		System.out.println("Size of List = "+list.size);
		list.deleteNth(2);
		list.printList();
	}
}
