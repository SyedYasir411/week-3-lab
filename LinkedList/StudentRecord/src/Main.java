class Node{
    int Roll_Num;
    String Name;
    int Age;
    String Grade;
    static int size;
    Node next;

    Node(int Roll_num,String Name,int Age,String Grade){
        this.Roll_Num=Roll_num;
        this.Name=Name;
        this.Age=Age;
        this.Grade=Grade;
        size++;
    }
}

class LinkedList{
    Node head=null;
    Node current=null;
    public void add(Node n){
        if(head==null){
            head=n;
            return;
        }

        current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=n;
    }

    public void addBeginning(Node n){
        n.next=head;
        head = n;
    }

    public void addPosition(Node n,int position){
        if(position==0){
            head=n;
            return;
        }

        current=head;
        int count=0;
        while(current!=null && count<position-1){
            current=current.next;
            count++;
        }
        if(current==null){
            System.out.println("pos out of range");
        }
        n.next=current.next;
        current.next=n;
    }

    public void display(){
        current=head;
        while(current!=null){
            System.out.println("RollNum: "+current.Roll_Num+", Name: "+current.Name+", Grade: "+current.Grade+", Age: "+current.Age);
            current=current.next;
        }
    }

    public void deleteByRoll(int Roll){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        current=head;
        if(current.Roll_Num==Roll){
            head=current.next;
            Node.size--;
            return;
        }
        while(current.next!=null && current.next.Roll_Num!=Roll){
            current=current.next;
        }
        if(current.next==null){
            System.out.println("no such number");
            return;
        }
        current.next=current.next.next;
        Node.size--;
    }

    public void displayByRoll(int Roll){
        if(head==null){
            System.out.println("Empty list");
        }

        current=head;
        while(current!=null && current.Roll_Num!=Roll){
            current=current.next;
        }
        if(current==null){
            System.out.println("No such number");
            return;
        }
        System.out.println("RollNum: "+current.Roll_Num+", Name: "+current.Name+", Grade: "+current.Grade+", Age: "+current.Age);
    }

    public void updateByRoll(int Roll,String G){
        current=head;
        while(current!=null && current.Roll_Num!=Roll){
            current=current.next;
        }
        if(current==null){
            System.out.println("no such number");
            return;
        }
        current.Grade=G;
    }
}
public class Main{
    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.addBeginning(new Node(1,"Charan",20,"A"));
        l1.addPosition(new Node(2,"sca",20,"A"),1);
        l1.add(new Node(3,"cdsva",36,"F"));
//        l1.deleteByRoll(1);
//        l1.displayByRoll(3);
        l1.updateByRoll(2,"B");
        l1.display();
        System.out.println("Size : "+Node.size);
    }
}