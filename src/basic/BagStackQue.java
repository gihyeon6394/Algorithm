package basic;

import lib.Bag;
import lib.StdIn;
import lib.StdOut;

import java.util.Stack;

public class BagStackQue {
    public static void main(String[] args) {

        // bag(args);
        // stack();

        stackDouble();
    }

    private static void stackDouble() {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                if (op.equals("+")) vals.push(vals.pop() + vals.pop());
                else if (op.equals("*")) vals.push(vals.pop() * vals.pop());
                else if (op.equals("-")) vals.push(vals.pop() - vals.pop());
                else if (op.equals("/")) vals.push(vals.pop() / vals.pop());
            } else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }

    private static void stack() {
        Stack<Integer> stack = new Stack<Integer>();
        while (!StdIn.isEmpty()) {
            stack.push(StdIn.readInt());
        }
        for (int i : stack) {
            System.out.println(i);
        }

    }

    private static void bag(String[] args) {

        Bag<Double> numbers = new Bag<Double>();

        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }

        int N = numbers.size();

        double sum = 0.0;

        for (double x : numbers) {
            sum += x;
        }

        double mean = sum / N;

        sum = 0.0;

        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
    }
}
