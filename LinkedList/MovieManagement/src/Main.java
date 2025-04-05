class Node{
    String Title;
    String Director;
    int YearOfRelease;
    double Rating;
    Node next;
    Node prev;
    Node(String Title,String Director,int Year,double Rating){
        this.Title=Title;
        this.Director=Director;
        this.YearOfRelease=Year;
        this.Rating=Rating;
        next=null;
        prev=null;
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
        n.prev=current;
    }
    public void addBegin(Node n){
        if(head==null){
            head=n;
            return;
        }
        n.next=head;
        head.prev=n;
        head=n;
    }
    public void addPosition(Node n,int Position){
        if(head==null){
            head=n;
            return;
        }
        if(Position == 0 ){
            n.next=head;
            head.prev=n;
            head=n;
            return;
        }

        current=head;
        int count=0;
        while(current!=null && count<Position -1){
            current=current.next;
            count++;
        }
        if(current==null){
            System.out.println("out of range");
            return;
        }
        n.next=current.next;
        if(current.next!=null) {
            current.next.prev = n;
        }
        n.prev=current;
        current.next=n;
    }
    public void remove(String title){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        current = head;
        if(current.Title.equals(title)){
            head=head.next;
            if(head!=null){
                head.prev=null;
            }
            return;
        }
        while(current.next!=null && !current.next.Title.equals(title)){
            current=current.next;
        }
        if(current.next==null){
            System.out.println("no title");
            return;
        }

        if(current.next.next==null){
            current.next=null;
            return;
        }
        current.next.next.prev=current;
        current.next=current.next.next;


    }
    public void SearchByDirector(String director){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        current=head;
        while(current!=null){
            if(current.Director.equals(director)){
                System.out.print("Title : "+current.Title+" ,");
                System.out.print("Director : "+current.Director+" ,");
                System.out.print("Year : "+current.YearOfRelease+" ,");
                System.out.print("Rating : "+current.Rating+"\n");
                return;
            }
            current=current.next;
        }
        if(current==null){
            System.out.println("no such director");
        }
    }

    public void displayforward(){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        current = head;
        while(current!=null) {
            System.out.print("Title : "+current.Title+" ,");
            System.out.print("Director : "+current.Director+" ,");
            System.out.print("Year : "+current.YearOfRelease+" ,");
            System.out.print("Rating : "+current.Rating+"\n");
            current=current.next;
        }
    }

    public void displayBackward(){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        current=head;
        while(current.next!=null){
            current=current.next;
        }
        while(current!=null){
            System.out.print("Title : "+current.Title+" ,");
            System.out.print("Director : "+current.Director+" ,");
            System.out.print("Year : "+current.YearOfRelease+" ,");
            System.out.print("Rating : "+current.Rating+"\n");
            current=current.prev;
        }
    }

    public void updateRating(String title, double rating){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        current=head;
        while(current!=null){
            if(current.Title.equals(title)){
                current.Rating=rating;
                return;
            }
            current=current.next;
        }
    }
}

public class Main{
    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.add(new Node("Fast","niv",2000,3.2));
        l1.addBegin(new Node("veasd","esfd",2000,3.0));
        l1.addPosition(new Node("asc","cas",2000,2.1),1);
        l1.remove("asc");
        l1.updateRating("Fast",4.9);
        l1.displayforward();
        System.out.println();
        l1.displayBackward();
    }
}