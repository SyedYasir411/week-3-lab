import java.util.Scanner;
class NODE{
    int value;
    NODE next;

    NODE(int value){
        this.value=value;
        this.next=null;
    }
}

class LinkedL{
    NODE head=null;
    NODE current = null;

    public void add(NODE n){
        if (head==null){
            head=n;
            return;
        }
        current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=n;
    }

    public void display(){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        current=head;
        while(current!=null){
            System.out.print(current.value+" ");
            current=current.next;
        }
    }
}

public class TakingInput {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        LinkedL list = new LinkedL();
        int t;
        System.out.println("Enter positive int values and -1 to stop");
        while(true){
            t=input.nextInt();
            if(t==-1){
                break;
            }
            list.add(new NODE(t));
        }

        list.display();
    }
}
