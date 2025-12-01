package 线性表;

import java.util.Iterator;

public class TowWayLinkList<T> implements Iterable<T>{
    private Node head;
    private Node last;
    private int N;
    private class Node{
        public Node(T item,Node pre,Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
        public T item ;
        public Node pre;
        public Node next;
    }
    public TowWayLinkList(){
        this.head = new Node(null,null,null);
        this.last = null;
        this.N = 0;
    }
    public void clear(){
        this.head.pre = null;
        this.head.next = null;
        this.head.item = null;
        this.last = null;
        this.N = 0;
    }
    public int length(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public T getFirst(){
        if(isEmpty()) return null;
        return head.next.item;
    }
    public T getLast(){
        if(isEmpty()) return null;
        return last.item;
    }
    public void insert(T t){
        if(isEmpty()){
            //如果链表为空:
            //创建新结点
            Node newNode = new Node(t,head,null);
            //让新结点成为尾结点
            last = newNode;
            //让头结点指向尾结点
            head.next = newNode;
        }else{
            //如果链表不为空
            //创造新的结点
            Node oldLast = last;
            Node newNode = new Node(t,oldLast,null);
            //让当前的尾结点指向新结点
            oldLast.next = newNode;
            //让新结点成为尾结点
            last = newNode;
        }
        N++;
    }
    public void insert(int i,T t){
        //找到i位置前一个结点
        Node pre = head;
        for(int index = 0;index<i;index++){
            pre = pre.next;
        }
        //找到i位置结点
        Node curr = pre.next;
        //创建新结点
        Node newNode = new Node(t,pre,curr);
        //让i位置的前一个结点的下一个结点变成新结点
        pre.next = newNode;
        //让i位置的起那一个结点编程新结点
        curr.pre = newNode;
        //元素个数+1
        N++;
    }
    public T get(int i){
        Node n = head.next;
        for(int index = 0;index<i;index++){
            n = n.next;
        }
        return n.item;
    }
    public int indexOf(T t){
        Node n = head;
        for(int i = 0;n.next!=null;i++){
            n = n.next;
            if(n.next.equals(t))return i;
        }
        return -1;
    }
    public T remove(int i){
        //找到i位置前一个结点
        Node n = head;
        for(int index = 0;index<i;index++){
            n = n.next;
        }
        //找到i位置的结点
        Node curr = n.next;
        //找到i位置下一个结点
        Node nex = curr.next;
        //让i位置的前一个结点的下一个结点变为i位置的下一个结点
        n.next = nex;
        //让i位置的下一个结点的上一个结点变为i位置的前一个结点
        nex.pre = n;
        //元素个数-1
        N--;
        return curr.item;
    }
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new TIterator();
    }
    private class TIterator implements Iterator{
        private Node n;
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