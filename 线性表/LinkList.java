package 线性表;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T>{
    private Node head;
    private int N;
    private class Node{
        T item;
        Node next;
        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
        }
    public LinkList(){
        this.head = new Node(null,null);
        this.N = 0;
    }
    public int length(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public T get(int i){
        Node n = head.next;
        for(int index = 0;index<i;i++){
            n = n.next;
        }
        return n.item;
    }
    public void insert(T t){
        Node n = head;
        while(n.next!=null){
            n = n.next;
        }
        Node newNode = new Node(t,null);
        n.next = newNode;
        N++;
    }
    public void insert(int i,T t){
        //找到i位置前一个结点
        Node pre = head;
        for(int index = 0;index<i;i++){
            pre = pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //创建新结点，并且新结点需要指向原来i位置的结点
        Node newNode = new Node(t,curr);
        //原来i位置的结点指向新结点即可
        pre.next = newNode;
        N++;
    }
    public T remove(int i){
        //要找到i位置的前一个结点
        Node pre = head;
        for(int index = 0;index<i;index++){
            pre = pre.next;
        }
        //要找到i位置的结点
        Node curr = pre.next;
        //要找到i位置下一个结点
        Node nex = curr.next;
        //前一个结点指向下一个结点
        pre.next = nex;
        //元素个数-1
        N--;
        return curr.item;
    }
    public int indexOf(T t){
        Node n = head;
        for(int index = 0;n.next!=null;index++){
            n = n.next;
            if(n.item.equals(t)){
                return index;
            }
            
        }
        return -1;
    }
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new LIterator();
    }
    private class LIterator implements Iterator{
        private Node n;
        public LIterator(){
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return n.next!=null;
        }

        @Override
        public Object next() {
            // TODO Auto-generated method stub
            n = n.next;
            return n.item;
        }

    }
}
