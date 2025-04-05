//class Node{
//    int value;
//    Node next;
//    Node(int n){
//        this.value=n;
//        this.next=null;
//    }
//}
//
//class Linked{
//    Node head=null;
//    Node current = null;
//
//    public void add(Node n){
//        if(head==null){
//            head=n;
//        }else{
//            current = head;
//            while(current.next!=null){
//                current=current.next;
//            }
//            current.next=n;
//        }
//    }
//
//    public void addBegining(Node n){
//        n.next=head;
//        head=n;
//    }
//
//    public void addPosition(Node n,int position){
//        if(position==0){
//            n.next=head;
//            head=n;
//            return;
//        }
//
//        current=head;
//        int count=0;
//
//        while(current !=null && count<position-1){
//            current=current.next;
//            count++;
//        }
//
//        if(current==null){
//            System.out.println("out of range");
//            return;
//        }
//
//        n.next=current.next;
//        current.next=n;
//    }
//
//    public void deletevalue(int value){
//        if(head.value==value){
//            head=head.next;
//        }
//
//        current=head;
//        while(current.next!=null && current.next.value!=value){
//            current=current.next;
//        }
//        if(current.next==null){
//            System.out.println("value not found");
//            return;
//        }
//        current.next=current.next.next;
//    }
//
//    public void display(){
//        if(head==null){
//            System.out.println("list is empty");
//        }else{
//            current=head;
//            while(current!=null){
//                System.out.println(current.value);
//                current=current.next;
//            }
//        }
//    }
//}
//
//public class P1 {
//    public static void main(String[] args){
//        Linked l2 = new Linked();
//        l2.add(new Node(5));
//        l2.add(new Node(19));
//        l2.addBegining(new Node(1));
//        l2.addPosition(new Node(10),3);
//        l2.deletevalue(10);
//        l2.display();
//    }
//}