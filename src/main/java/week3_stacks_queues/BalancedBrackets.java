package week3_stacks_queues;

import java.util.Scanner;

public class BalancedBrackets {
    static class ResizingStack{
        String[] s = new String[1];
        int N = 0;
        public void resize(int capacity){
            String[] copy = new String[capacity];
            for(int i = 0; i < N ; i++){
                copy[i] = s[i];
            }
            s = copy;
        }
        public boolean isEmpty(){
            return N == 0;
        }
        public int size(){
            return N ;
        }
        public void push(String item){
            if(N == s.length){
                resize(2*s.length);
            }
            s[N++] = item;
        }
        public String pop(){
            if(isEmpty()){
                throw new RuntimeException("Stack is empty");
            }
            String item = s[--N];
            s[N] = null;
            if(N > 0 && N == s.length/4){
                resize(s.length/2);
            }
            return item;
        }
    }
    public static boolean isBalanced(String expression){
        ResizingStack stack = new ResizingStack();
        char[] s =  expression.toCharArray();
        for(int i = 0; i < s.length; i++){
            char current = s[i];
            if(current == '(' || current == '[' || current == '{'){
                stack.push(String.valueOf(current));
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    String popped =  stack.pop();
                    if(current == ')' && !popped.equals("(")){return false;}
                    if(current == ']' && !popped.equals("[")){return false;}
                    if(current == '}' && !popped.equals("{")){return false;}
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner input = new  Scanner(System.in);
        int n = input.nextInt();
        String[] result = new String[n];
        for(int i = 0; i < n; i++){
            String s = input.next();
            if(isBalanced(s)){
                result[i] = "YES";
            }else{
                result[i] = "NO";
            }
        }
        for(int i = 0; i < n; i++){
            System.out.println(result[i]);
        }
        input.close();
    }
}
