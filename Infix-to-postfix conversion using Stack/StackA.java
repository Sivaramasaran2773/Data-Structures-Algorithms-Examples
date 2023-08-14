package PROJECT;
import java.util.*;

// Java program to convert an infix expression to a output expression using STACK
// This code is contributed by PINNINTI SAI RAVULA , CB.EN.U4AIE21041

public class StackA {

class Stack1 {

       int top;
       char[] array;
       int length;
   
    Stack1(int a){

	    length = a;
	    array = new char[length];
	    top = -1;
   }

   //CHECKING WHETHER STACK IS FULL OR NOT
   public boolean isFull() {
	 return top == length - 1;
   }

   //CHECKING WHETHER STACK IS EMPTY OR NOT
   public boolean isEmpty() {
	 return top == -1;
   }
	
   //PUSHING ELEMENTS ON TO THE STACK
   public void push(char num){
	  if(isFull()){
		System.out.println("STACK IS FULL");
		System.exit(0);
	  }
	  top = top + 1;
	  array[top] = num;
   }

    //POPPING ELEMENTS FROM THE STACK
   public char pop(){
	     if(isEmpty()){
		    System.out.println("STACK IS EMPTY");
		    System.exit(0);
	      }
	   top = top - 1;
	   char[] temparr = new char[array.length - 1];
	   for(int i =0; i<temparr.length; i++){
		  temparr[i] = array[i];
	      }
	 array = temparr;
	 length--;
	 return array[top + 1];
   }

  //TO RETURN THE TOP ELEMENT ON THE STACK
   public void peek_operation(){
	System.out.println("ELEMENT AT THE TOP OF STACK IS :  ");
	System.out.println(array[length-1]);
   }

    //DISPLAYING THE ENTIRE STACK
   public void display(){
	   
	     for (int i = 0;i<=top;i++){
		    System.out.println(array[i]);
	    }
  }
}

  Stack1 S2;
  String output = "";

  public String Trans(String input) {

		  S2 = new Stack1(input.length());
      char[] C= new char[input.length()];
      char temp;

    for(int i=0; i<input.length(); i++) {
        temp = input.charAt(i);
        C[i] = temp;
    }
    
    for(char c: C) {

      if(c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
          output = output + c;
      } 
        else if (c == '(') {
           S2.push(c);
      } 
          else if (c == ')') {
            while(!S2.isEmpty()) {
            char t = S2.pop();
              if(t != '(') {
                output = output + t;
          } 
          else {
            break;
          }
        }
      }
      
      else if(c == '+' ||c == '-' ||c == '*' ||c == '/') {
        if(S2.isEmpty()) {
          S2.push(c);
        } 
          else {
            while(!S2.isEmpty()) {
              char t = S2.pop();
               if(t == '(') {
                S2.push(t);
              break;
            } 
            
            else if(t == '+' || t == '-' || t == '*' || t == '/') {
              if(Precedence(t) <  Precedence(c)) {
                S2.push(t);
                break;
              } 
               else {
                 output = output + t;
               }
            }
          }
          S2.push(c);
        }
      }
    }

       while(!S2.isEmpty()) {
         output = output + S2.pop();
        }
       return output;
    }
  
  public int Precedence(char c) {
      if(c == '+' || c == '-') {
        return 1;
      } 
         else {
           return 2;
      } 
  }
  public static void main(String[] args) {
    StackA inp = new StackA();

    String S2;
    System.out.println("Enter the infix expression: ");
	  Scanner sc = new Scanner(System.in);
	  S2 = sc.nextLine();

    System.out.println();
    String L2 = inp.Trans(S2);
    System.out.println("YOUR INFIX EXPRESSION IS --->" + S2 + " ");
    System.out.println("YOUR POSTFIX EXPRESSION IS --->" + L2 + " ");
	  System.out.println();
  }
}