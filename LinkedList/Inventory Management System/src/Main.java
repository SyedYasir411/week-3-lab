class Node{
    String ItemName;
    int ItemId;
    int Quantity;
    double price;
    Node next;
    Node(String ItemName,int ItemId,int Quantity,double price){
        this.ItemName=ItemName;
        this.ItemId=ItemId;
        this.Quantity=Quantity;
        this.price=price;
        this.next=null;
    }
}

class LinkedList {
    Node head = null;
    Node current = null;

    public void add(Node n) {
        if (head == null) {
            head = n;
            return;
        }
        current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = n;
    }

    public void addBegin(Node n) {
        n.next = head;
        head = n;
    }

    public void addPosition(Node n, int Position) {
        if (Position == 0) {
            n.next = head;
            head = n;
            return;
        }

        current = head;
        int count = 0;
        while (current.next != null && count < Position - 1) {
            current = current.next;
            count++;
        }
        n.next = current.next;
        current.next = n;
    }

    public void remove(int Id) {
        if (head == null) {
            System.out.println("empty list");
            return;
        }

        current = head;
        while (current.next != null && current.next.ItemId != Id) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Not found");
            return;
        }
        current.next = current.next.next;
    }

    public void Update(int Id, int quantity) {
        if (head == null) {
            System.out.println("empty list");
            return;
        }

        current = head;
        while (current.next != null && current.next.ItemId != Id) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Not found");
            return;
        }
        current = current.next;
        current.Quantity = quantity;
    }

    public void Search(String name) {
        if (head == null || head.ItemName.equals(name)) {
            System.out.println("empty list");
            return;
        }
        current = head;
        while (current.next != null && !current.next.ItemName.equals(name)) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("item not found");
            return;
        }
        current = current.next;
        System.out.print(current.ItemName + " ");
        System.out.print(current.ItemId + " ");
        System.out.print(current.price + " ");
        System.out.print(current.Quantity + " \n");
    }

    public void Totalprice() {
        if (head == null) {
            System.out.println("empty list");
            return;
        }
        current = head;
        double total = 0;
        while (current != null) {
            total += (current.Quantity * current.price);
            current = current.next;
        }
        System.out.println("totalPrice : " + total);
    }

    public void sortAscending(boolean ascending) {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node ptr1 = head;
            Node ptr2 = head.next;
            while (ptr2 != null) {
                boolean shouldSwap = ascending ? ptr1.price > ptr2.price : ptr2.price > ptr1.price;

                if (shouldSwap) {
                    String tempName = ptr1.ItemName;
                    int tempId = ptr1.ItemId;
                    int tempQuant = ptr1.Quantity;
                    double tempPrice = ptr1.price;

                    ptr1.ItemName = ptr2.ItemName;
                    ptr1.ItemId = ptr2.ItemId;
                    ptr1.Quantity = ptr2.Quantity;
                    ptr1.price = ptr2.price;

                    ptr2.ItemName = tempName;
                    ptr2.ItemId = tempId;
                    ptr2.Quantity = tempQuant;
                    ptr2.price = tempPrice;

                    swapped = true;
                }
                ptr1 = ptr2;
                ptr2 = ptr2.next;
            }
        } while (swapped);
    }

    public void display() {
        if (head == null) {
            System.out.println("empty list");
            return;
        }

        current = head;
        while (current != null) {
            System.out.print(current.ItemName + " ");
            System.out.print(current.ItemId + " ");
            System.out.print("price : " + current.price + " ");
            System.out.print(current.Quantity + " \n");
            current = current.next;
        }
    }
}

public class Main{
    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.add(new Node("Shampoo",23,3,300));
        l1.add(new Node("wdad   ",2,1,30));
        l1.add(new Node("poo",3,2,100));
        l1.addBegin(new Node("Shao   ",232,3,100));
        l1.addPosition(new Node("sdc    ",54,4,15),1);
        l1.remove(3);
        l1.Update(54,10);
        l1.Search("sdc    ");
        l1.Totalprice();
        l1.sortAscending(false);
        l1.display();
    }
}