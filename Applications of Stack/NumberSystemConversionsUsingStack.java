package com.company;
import java.util.*;
                                                      // Convert from integer to any binary and octal number system//
public class NumberSystemConversionsUsingStack {

   public void dec2bin(int a){
       Stack theStack = new Stack();
       int remainder_1;

       while(a>0){
           remainder_1 = a%2;
           theStack.push(remainder_1);
           a/=2;
       }
       while(!theStack.isEmpty())
           System.out.print(theStack.pop());

   }

   public void dec2oct(int b){
       Stack theStack = new Stack();
       int remainder_2;

       while(b>0){
           remainder_2 = b%8;
           theStack.push(remainder_2);
           b/=8;
       }
       while(!theStack.isEmpty())
           System.out.print(theStack.pop());

   }

    public static void main(String[] args) {
       NumberSystemConversionsUsingStack numconv = new NumberSystemConversionsUsingStack();
        Scanner sc = new Scanner (System.in);
        System.out.print(" Enter the decimal number: ");
        int dec = sc.nextInt();
        System.out.print("Binary value of the given decimal input: ");
        numconv.dec2bin(dec);
        System.out.println();
        System.out.print("Octal value of the given decimal input: ");
        numconv.dec2oct(dec);


   }

    class Stack {
        private int maxSize;
        private ArrayList<Integer> stackArray;
        private int top;

        public Stack() {
            stackArray = new ArrayList<>();
            top = -1;
        }
        public void push(int j) {
            stackArray.add(j);
            ++top;
        }
        public int pop() {
            --top;
            return stackArray.get(top+1);

        }
        public int peek() {
            return stackArray.get(top);
        }
        public boolean isEmpty() {
            return (top == -1);
        }
    }
}
