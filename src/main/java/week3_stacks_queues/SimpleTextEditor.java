package week3_stacks_queues;

import java.util.Scanner;


public class SimpleTextEditor {
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

    public static void main(String[] args) {
        StringBuilder currentText = new StringBuilder();
        ResizingStack History = new ResizingStack();
        Scanner input = new Scanner(System.in);
        if(input.hasNextInt()){
            int Q = input.nextInt();
            for(int i = 0; i < Q; i++){
                int type = input.nextInt();
                if(type == 1){
                    String item = input.next();
                    History.push(currentText.toString());
                    currentText.append(item);
                }else if(type == 2){
                    History.push(currentText.toString());
                    int k =  input.nextInt();
                    currentText = currentText.delete(currentText.length()-k, currentText.length());
                }else if(type == 3){
                    int pos = input.nextInt();
                    System.out.println(currentText.charAt(pos-1));
                }else{
                    if(!History.isEmpty()){
                        currentText = new StringBuilder(History.pop());
                    }
                }
            }
        }
        input.close();

    }

}
