class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class Stack{
    Node top;

    public boolean isEmpty(){
        return top==null;
    }

    public void push(Node n){
        n.next=top;
        top=n;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        int out = top.data;
        top=top.next;
        return out;
    }

    public int peek(){
        return top.data;
    }
}

public class Main{
    public static void main(String[] args){
        Stack s = new Stack();
        s.push(new Node(10));
        s.push(new Node(20));
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}