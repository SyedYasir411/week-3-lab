//class Node{
//    int value;
//    Node next;
//    Node(int value){
//        this.value=value;
//        this.next = null;
//    }
//}
//
//class LinkedList {
//
//    Node head = null;
//    Node current = null;
//
//    public void add(Node n){
//        if(head == null){
//            head = n;
//        }else{
//            current = head;
//            while(current.next != null){
//                current= current.next;
//
//            }
//            current.next = n;
//        }
//    }
//
//    public void addAtBegining(Node n){
//        if(head==null){
//            head=n;
//        }else{
//            n.next=head;
//            head=n;
//        }
//    }
//
//    public void addPosition(Node n,int position){
//        if(position==0){
//            head=n;
//            return;
//        }
//        current = head;
//        int count=0;
//        while(current !=null && count<(position-1)){
//            current = current.next;
//            count++;
//        }
//
//        if(current==null){
//            System.out.println("pos out of range");
//            return;
//        }
//        n.next=current.next;
//        current.next=n;
//
//    }
//
//    public void display(){
//        if(head == null){
//            System.out.println("Linked List is empty");;
//        }else{
//            current = head;
//            while(current != null){
//                System.out.println(current.value);
//                current = current.next;
//            }
//        }
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        LinkedList l1 = new LinkedList();
//        l1.add(new Node(10));
//        l1.add(new Node(20));
//        l1.add(new Node(30));
//        l1.addAtBegining(new Node(5));
//        l1.addPosition(new Node(15),2);
//        l1.addPosition(new Node(40),5);
//        l1.display();
//
//    }
//}
