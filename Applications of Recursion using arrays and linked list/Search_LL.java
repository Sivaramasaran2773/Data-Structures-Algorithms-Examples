package com.company;
import java.util.Scanner;

class Node1
{
    int data;
    Node1 next;
    Node1(int d)
    {
        data = d;
        next = null;
    }
}

class Search_LL
{
    Node1 head;
    public void push(int new_data)
    {
        Node1 new_node = new Node1(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void printList(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node1 currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public boolean search(Node1 head, int x)
    {
        if (head == null)
            return false;

        if (head.data == x)
            return true;

        return search(head.next, x);
    }

    public static void main(String args[])
    {

        Search_LL llist = new Search_LL();

        llist.push(5);
        llist.push(44);
        llist.push(41);
        llist.push(18);
        llist.push(32);
        System.out.print("LinkedList: ");
        llist.printList();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the element you want to search: ");
        int x = sc.nextInt();

        if (llist.search(llist.head, x))
            System.out.println("The element is present in the linked list");
        else
            System.out.println("The element is not present in the linked list");
    }
}
