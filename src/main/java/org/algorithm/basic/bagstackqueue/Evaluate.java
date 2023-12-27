package org.algorithm.basic.bagstackqueue;

import java.util.Stack;

/**
 * 데이크스트라의 2중 스택 알고리즘
 * (1+((2+3)*(4*5)))를 stack을 이용해서 계산
 */
public class Evaluate {

    public static void main(String[] args) {

        Stack<String> ops = new Stack<String>(); // 연산자
        Stack<Double> vals = new Stack<Double>(); // 피연산자 (double 타입으로 제한)

        // 토큰을 읽어가며 stack에 push()
        for (String s : args) {

//            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                // 연산자를 pop() 하고 연산을 수행
                String op = ops.pop();
                double v = vals.pop();

                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);

                vals.push(v);
            } else {
                vals.push(Double.parseDouble(s)); //연산자가 아니면 double로 변환해서 push()
            }

        }

        System.out.println(vals.pop());


    }
}
