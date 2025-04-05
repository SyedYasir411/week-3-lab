class Node{
    int Task_Id;
    String TaskName;
    int Priority;
    String DueDate;
    Node next;
    Node(int Id,String Name,int Priority,String DueDate){
        this.Task_Id=Id;
        this.TaskName=Name;
        this.Priority=Priority;
        this.DueDate=DueDate;
        this.next=null;
    }
}

class LinkedList {
    Node head = null;
    Node tail = null;
    Node current = null;

    public void add(Node n) {
        if (head == null) {
        head = tail = n;
        tail.next = head;
        }else{
            tail.next=n;
            n.next=head;
            tail=n;
        }
    }

    public void addBegin(Node n){
        if(head==null){
            head=tail=n;
            tail.next=head;
            return;
        }
        n.next=head;
        head=n;
        tail.next=head;
    }

    public void addPosition(Node n,int position){
        if(head==null){
            head=tail=n;
            tail.next=head;
            return;
        }

        if(position==0){
            addBegin(n);
            return;
        }

        current=head;
        int count=0;
        do{
            if(count==position-1) break;
            current=current.next;
            count++;
        }while(current!=head);

        if(current==tail){
            add(n);
            return;
        }
        n.next=current.next;
        current.next=n;
    }

    public void remove(int id){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        if(head.Task_Id==id && head.next==null){
            head=tail=null;
            return;
        }
        if(head.Task_Id==id){
            head=head.next;
            tail.next=head;
            return;
        }
        current=head;
        while(current.next.Task_Id!=id){
            current=current.next;
            if(current==head){
                return;
            }
        }
        if(current.next==tail){
            current.next=head;
            tail=current;
            return;
        }
        current.next=current.next.next;
    }

    public void ViewCurrentTask(String Name){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        current=head;
        if(head.TaskName.equals(Name)){
            do{
                System.out.println(current.TaskName);
                current=current.next;
            }while(current!=head);
            return;
        }
        do{
            if(current.TaskName.equals(Name)){
                while(current!=head) {
                    System.out.println();
                    current=current.next;
                }
                return;
                }
            current=current.next;
        }while(current!=head);

    }

    public void displayTasks(){
        if(head==null){
            System.out.println("empty list");
            return;
        }

        current=head;
        do{
            System.out.println(current.TaskName);
            current=current.next;
        }while(current!=head);
    }

    public void displayTask(int priority){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        current=head;
        do{
            if(current.Priority==priority){
                System.out.println(current.TaskName);
            }
            current=current.next;
        }while(current!=head);
    }
}

public class Main{
    public static void main(String[] args){
        LinkedList l1=new LinkedList();
        l1.add(new Node(3,"dsv",1,"12-5-25"));
        l1.addPosition(new Node(2,"sca",2,"11-3-25"),1);
        l1.displayTask(1);
        l1.displayTasks();
    }
}