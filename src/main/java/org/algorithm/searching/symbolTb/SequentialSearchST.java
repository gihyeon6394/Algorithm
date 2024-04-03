package org.algorithm.searching.symbolTb;

public class SequentialSearchST<Key, Value> {
    private Node first; // linked list의 head

    // linked list node 구조
    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    // key를 찾아 value 리턴
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    // 키 찾기
    // 존재하면 value 업데이트
    // 없으면 새로운 노드 추가
    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
    }

    //TODO: size(), keys(), delete()
}
