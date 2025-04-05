class Node{
    double process_Id;
    double burstTime;
    double priority;
    Node next;
    Node(double id,double time,double priority){
        this.process_Id=id;
        this.burstTime=time;
        this.priority=priority;
        next=null;
    }
}

class LinkedList{
    Node head=null;
    Node tail=null;
    Node current=null;
    Node temp=null;
    int size;

    public void add(Node n){
        if(head==null){
            head=tail=n;
            tail.next=head;
            size++;
            return;
        }

        n.next=head;
        tail.next=n;
        tail=n;
        size++;
    }

    public void remove(double id){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        if(head.process_Id == id){
            head=head.next;
            tail.next=head;
            size--;
            return;
        }
        current=head;
        while(current.next!=head && current.next.process_Id!=id){
            current=current.next;
        }
        if(current.next==head){
            System.out.println("no such element");
            return;
        }
        if(current.next==tail){
            current.next=head;
            tail=current;
            size--;
            return;
        }
        current.next=current.next.next;
        size--;
    }

    public void execute(double time) {
        if (head == null) {
            System.out.println("empty list");
            return;
        }
        current = head;
        while(size!=0) {
            Node nextNode = current.next;
            current.burstTime = current.burstTime - time;
            if (current.burstTime <= 0) {
                remove(current.process_Id);
            }
            if (head != null) {
                temp = head;
                do {
                    System.out.println(temp.burstTime);
                    temp = temp.next;
                } while (temp != head);
                System.out.println();
            }
            current = (size != 0) ? nextNode : null;
        }
    }
}

public class Main{
    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.add(new Node(2,15,3));
        l1.add(new Node(1,1,10));
        l1.add(new Node(3,4,5));
        l1.execute(2);
    }
}