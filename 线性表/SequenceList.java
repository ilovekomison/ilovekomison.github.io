package 线性表;
import java.util.Iterator;

public class SequenceList<T> implements Iterable<T>{
    private T[] eles;
    private int N;
    public SequenceList(int capacity){
        this.eles = (T[])new Object[capacity];
        this.N = 0;
    }
    public void clear(){
        this.N = 0;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int length(){
        return N;
    }
    public T get(int i){
        return eles[i];
    }
    public void insert(T t){
        if(N==eles.length){
            resize(2*eles.length);
        }
        eles[N++] = t;
    }
    public void insert(int i,T t){
        for(int j = N;j>i;j--){
            eles[j] = eles[j-1];
        }
        eles[i] = t;
        N++;
    }
    public T remove(int i){
        T current = eles[i];
        for(int index = i;index<N-1;index++){
            eles[index] = eles[index+1];
        }
        N--;
        if(N<eles.length/4){
            resize(eles.length/2);
        }
        return current;
    }
    public int indexOf(T t){
        for(int i = 0;i<N;i++){
            if(eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }
    public void resize(int newSize){
        T[] temp = eles;
        eles = (T[])new Object[newSize];
        for(int i = 0;i<N;i++){
            eles[i] = temp[i];
        }
    }
    @Override
    public Iterator<T> iterator(){
        return new SIterator();
    }
    
    private class SIterator implements Iterator<T>{
        private int cursor;
        public SIterator(){
            this.cursor = 0;
        }
        @Override
        public boolean hasNext(){
            return cursor < N;
        }
        @Override
        public T next(){
            return eles[cursor++];
        }
    }
}
