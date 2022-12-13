public class isPalindromeList{
    Node head;
    int size;
    isPalindromeList(){
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
    public Node getMiddle(Node head){
        Node fast = head;
        Node slow = head;
        while(slow.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node Reverse(Node head){
        Node prev = head;
        Node curr = head.next;
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = null;
        head = prev;
        return head;
    }
    public boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node firstHalf = getMiddle(head);
        Node SecondHalf = Reverse(firstHalf.next);
        Node firstStart = head;
        while(SecondHalf != null){
            if(SecondHalf.data != firstStart.data){
                return false;
            }
            SecondHalf = SecondHalf.next;
            firstStart = firstStart.next;
        }
        return true;
    }
    public static void main(String[] args){
        isPalindromeList list = new isPalindromeList();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(1);
        list.printList();
        System.out.println("Size of linkedlist : "+list.size);
        boolean ans = list.isPalindrome(list.head);
        System.out.println(ans);

    }
}