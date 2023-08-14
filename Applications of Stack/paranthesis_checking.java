package com.company;

public  class paranthesis_checking {
    private String input;

     boolean areBracketsBalanced(String expr){
        input = expr;
        int stackSize = input.length();
        Stack theStack = new Stack(stackSize);

        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                theStack.push(x);
                continue;
            }

            if (theStack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = theStack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = theStack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = theStack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return (theStack.isEmpty());
    }


    public static void main(String[] args) {
        paranthesis_checking obj = new paranthesis_checking();
        String expr = "(([{}))]";
        System.out.println("Given input: " + expr);

        if (obj.areBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }

    class Stack {
        private int maxSize;
        private char[] stackArray;
        private int top;

        public Stack(int max) {
            maxSize = max;
            stackArray = new char[maxSize];
            top = -1;
        }
        public void push(char j) {
            stackArray[++top] = j;
        }
        public char pop() {
            return stackArray[top--];
        }
        public char peek() {
            return stackArray[top];
        }
        public boolean isEmpty() {
            return (top == -1);
        }
    }
}


