package org.algorithm.searching.symbolTb;

import org.algorithm.lib.StdIn;
import org.algorithm.lib.StdOut;
import org.algorithm.searching.common.ST;

public class TstClient {
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));

    }
}
