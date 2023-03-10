package Linked_List_Java;

import java.util.Scanner;

public class Sorting_LL {
    public static Node head=null;
    public static Node tail=null;
    public static class Node {
        public int data;
        public Node next;
        public Node prev;
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev=null;
        }
    }
    /**
     *
     *
     *
     */
    public static  void Insert_Beg(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data for new node");
        int data=sc.nextInt();
        Node new_node=new Node(data);
        if(head==null){
            head=new_node;
            tail=new_node;
        }
        else {
            new_node.next = head;
            head.prev= new_node;
            head=new_node;
        }
    }
    public static void Insert_End(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data for new node");
        int data=sc.nextInt();
        Node new_node=new Node(data);
        if(head==null){
            head=new_node;
            tail=new_node;
        }else {
            tail.next=new_node;
            new_node.prev=tail;
            tail=new_node;
        }

    }
    public static void Insert_AnyPos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data for new node");
        int data=sc.nextInt();
        System.out.println("Enter the index to insert");
        int n=sc.nextInt();
        Node new_node=new Node(data);
        if(head==null){
            head=new_node;
            tail=new_node;
        }
        else {
            Node ptr=head;
            Node pos=head.next;
            int i=1;
            while (i!=n){
                ptr=ptr.next;
                pos=pos.next;
                i++;
            }
            new_node.next=pos;
            new_node.prev=ptr;
            pos.prev=new_node;
            ptr.next=new_node;

        }
    }


    ///Codes for deletion in Linked List
    public static void Delete_first(){
        head=head.next;
        tail.next=head;
    }

    public static void Delete_end(){
        Node ptr=head;
        Node pos=head.next;
        while (pos.next!=head){
            pos=pos.next;
            ptr=ptr.next;
        }

        tail=ptr;
        tail.next=head;
    }

    public static void Delete_anyPOS(Scanner sc){

        if(head==null){
            System.out.println("The Linked list is empty");
        }
        else {
            System.out.println("Enter the index of the node to delete");
            int n= sc.nextInt();
            int i=1;
            Node ptr=head;
            Node pos=head.next;
            while(i!=n){
                ptr=ptr.next;
                pos=pos.next;
                i++;
            }
            ptr.next=pos.next;

        }

    }
    public static void Display(){
        if(head==null){
            System.out.println("Linked list is empty");
        }
        else {
            Node ptr1 = head;
            int i = 1;
            while (ptr1 != tail) {
                System.out.println("Data of node " + i + " is " + ptr1.data);
                ptr1=ptr1.next;
                i++;
            }
            System.out.println("Data of node " + i + " is " + ptr1.data);
        }
    }

    //    public static void Display() {
//        Node current = head;
//
//        while (current != null) {
//            System.out.print(current.data + " ");
//            current = current.next;
//        }
//
//        System.out.println();
//    }
    public static void Sorting(){
        System.out.println("Before sorting the Linked List is ");

        if(head ==null){
            System.out.println("The linked list is empty");
            return;
        } Display();

        int n=0;
        Node ptr =head;
        while(ptr!=null){
            ptr=ptr.next;
            n++;
        }
        System.out.println("Number of nods present in Linked list is "+n);

        for(int i=0;i<n;i++){
            Node t=head;
            Node t1=t.next;
            for(int j=0;j<n-1-i;j++){
                if(t.data>t1.data){
                    int d=t.data;
                    t.data=t1.data;
                    t1.data=d;
                }
                t=t1;
                t1=t1.next;
            }
        }

        System.out.println("After sorting the Linked List is ");
        Node ptr1 =head;
        int i=1;
        while (ptr1 != tail) {
            System.out.println(ptr1.data+" ");
            ptr1=ptr1.next;
            i++;
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter\n 1:to Insert a node at beginning\n 2:to insert at End \n 3:to Insert at any position\n 4:To delete 1st element\n 5:to delete last element\n 6:to delete any index element\n 7:to Display all the nodes\n 8:To sorting \n 9:To exit");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your choice");
            int choice=sc.nextInt();

            switch (choice){
                case 1:
                    Insert_Beg();
                    break;
                case 2:
                    Insert_End();
                    break;
                case 3:
                    Insert_AnyPos();
                    break;
                case 4:
                    Delete_first();
                    break;
                case 5:
                    Delete_end();
                    break;
                case 6:
                    Delete_anyPOS(sc);
                    break;
                case 7:
                    Display();
                    break;
                case 9:
                    System.exit(0);
                case 8: Sorting();
                    break;
                default:
                    System.out.println("opps! Wrong entry try again");
                    break;
            }

        }
    }
}

