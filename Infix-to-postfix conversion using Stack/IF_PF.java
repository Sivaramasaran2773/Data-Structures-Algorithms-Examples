package PROJECT;
import java.util.Scanner;

// Java program to convert an infix expression to a postfix expression using STACK
// This code is contributed by PINNINTI SAI RAVULA , CB.EN.U4AIE21041

public class IF_PF {
	class Stack1{

       int top;
       char[] ARR;
       int length;
   
    Stack1(int dim){

	  length = dim;
	  ARR = new char[length];
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
		System.out.println("OUR STACK IS FULL");
		System.exit(0);
	  }
	  top = top + 1;
	  ARR[top] = num;
   }

   //POPPING ELEMENTS FROM THE STACK
   public char pop(){
	     if(isEmpty()){
		    System.out.println("OUR STACK IS EMPTY");
		    System.exit(0);
	      }
	   top = top - 1;
	   char[] tempArr = new char[ARR.length - 1];
	   for(int i =0; i<tempArr.length; i++){
		  tempArr[i] = ARR[i];
	      }
	     ARR = tempArr;
	     length--;
	     return ARR[top + 1];
     }

  //TO RETURN THE TOP ELEMENT ON THE STACK
   public void peek_Operatoration(){
	   System.out.println("TOP ELEMENT ON THE STACK IS :  ");
	   System.out.println(ARR[length-1]);
   }

   //DISPLAYING THE ENTIRE STACK
   public void display(){
	   
	     for (int i = 0;i<=top;i++){
		  System.out.println(ARR[i]);
	}
  }
}

//------------------------------------------ /////// --------------------------------------------//

  String output = "";  // Output postfix string
  Stack1 S1;            // An empty stack

  public  String Trans(String input) {

    S1 = new Stack1(input.length());
      for(int m = 0; m< input.length(); m++){

		switch(input.charAt(m)){
		  case '(':
			S1.push(input.charAt(m));
			break;
		  case ')':
			Brack(input.charAt(m));
			break;
          case '+':
		  case '-':
		     Operator(input.charAt(m), 1);
			 break;
		  case '*':
		  case '/':
		     Operator(input.charAt(m), 2);
			 break;
		   default:
		output = output + input.charAt(m);
	}
}
    while(!S1.isEmpty()){
		output = output + S1.pop();
	}
	return output;
  }

  private void Brack(char charAt) {
	while(!S1.isEmpty()) {
		char temp = S1.pop();
		if(temp == '(') {
			break;
		}
		else {
			output = output + temp;
		}
	}
}

public  void Operator(char opThis, int PREC_C) {
	while(!S1.isEmpty()){
		char opTop = S1.pop();
        if(opTop == '(' ) {
			S1.push(opTop);
			break;
		}
		else {
			int PREC_S;
			if(opTop == '+' || opTop == '-') {
				PREC_S = 1;
			}
			
			else{
              PREC_S = 2;
			}
			if(PREC_C > PREC_S) {
				S1.push(opTop);
				break;
			}	
			else {
				output = output + opTop;
			}
		}		
	}
	S1.push(opThis);
}

public static void main(String[] args) {
	IF_PF inp = new IF_PF();

	String S1;
    System.out.println("Enter the infix expression: ");
	  Scanner sc = new Scanner(System.in);
	  S1 = sc.nextLine();

	System.out.println();
    String L1 = inp.Trans(S1);
	System.out.println("YOUR INFIX EXPRESSION IS --->" + S1 + " ");
    System.out.println("YOUR POSTFIX EXPRESSION IS --->" + L1 + " ");
	System.out.println();
  }
}