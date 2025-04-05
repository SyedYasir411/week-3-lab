class Node{
    String Title;
    String Author;
    String Genre;
    int Book_ID;
    boolean Availability_Status;
    static int size;
    Node next;
    Node prev;
    Node(String Title,String Author,String Genre,int Book_ID,boolean Availability_Status){
        this.Title=Title;
        this.Author=Author;
        this.Genre=Genre;
        this.Book_ID=Book_ID;
        this.Availability_Status=Availability_Status;
        this.next=null;
        this.prev=null;
        size++;
    }
}

class LinkedList{
    Node head=null;
    Node tail=null;
    Node current=null;
    public void add(Node n){
        if(head==null){
            head=tail=n;
            return;
        }
        tail.next=n;
        n.prev=tail;
        tail=n;
    }

    public void addBegin(Node n){
        if(head==null){
            head=tail=n;
            return;
        }
        head.prev=n;
        n.next=head;
        head=n;
    }
    public void addPosition(Node n,int position){
        if(head==null){
            head=tail=n;
            return;
        }
        if(position==0){
            addBegin(n);
            return;
        }
        current=head;
        int count=0;
        while(current!=null && count<position-1){
            current=current.next;
        }
        if(current==null){
            System.out.println("position out of range");
            return;
        }
        n.next=current.next;
        current.next.prev=n;
        current.next=n;
    }

    public void removeById(int id){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        current=head;
        while(current.next!=null && current.next.Book_ID!=id){
            current=current.next;
        }
        if(current.next==null){
            System.out.println("no such id");
            return;
        }
        if(current.next==tail){
            current.next=null;
            tail=current;
            Node.size--;
            return;
        }
        current.next=current.next.next;
        current.next.prev=current;
        Node.size--;
    }
    public void searchByTitle(String title){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        current=head;
        while(current!=null && !current.Title.equals(title)){
            current=current.next;
        }
        if(current==null){
            System.out.println("No such title");
            return;
        }
        System.out.println(current.Title);
        System.out.println(current.Author);
        System.out.println(current.Book_ID);
        System.out.println(current.Genre);
        System.out.println(current.Availability_Status);
    }
    public void updateAvailability(int id,boolean status){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        current=head;
        while(current!=null && current.Book_ID!=id){
            current=current.next;
        }
        if(current==null){
            System.out.println("no such id");
            return;
        }
        current.Availability_Status=status;
    }
    public void displayForward(){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        current=head;
        while(current!=null){
            System.out.print(current.Title+" ,");
            System.out.print(current.Author+" ,");
            System.out.print(current.Book_ID+" ,");
            System.out.print(current.Genre+" ,");
            System.out.print(current.Availability_Status+" \n");
            current=current.next;
        }
    }

    public void displayBackward(){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        current=tail;
        while(current!=null){
            System.out.print(current.Title+" ,");
            System.out.print(current.Author+" ,");
            System.out.print(current.Book_ID+" ,");
            System.out.print(current.Genre+" ,");
            System.out.print(current.Availability_Status+" \n");
            current=current.prev;
        }
    }
    public void size(){
        System.out.println("Size : "+Node.size);
    }
}

public class Main{
    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.addPosition(new Node("casd","casc","cas",453,true),0);
        l1.add(new Node("egebg","dvasd","vdaa",3,true));
        l1.addBegin(new Node("casca","casa","cas",42,false));
        l1.searchByTitle("casd");
        System.out.println();
        l1.updateAvailability(453,false);
        l1.removeById(3);
        l1.displayForward();
        l1.displayBackward();
        l1.size();
    }
}