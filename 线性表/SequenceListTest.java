package 线性表;
import 线性表.SequenceList;
public class SequenceListTest {
    public static void main(String[] args){
        //创建顺序表对象
        SequenceList<String> sl = new SequenceList<>(10);
        sl.insert("yaoming");
        sl.insert("Jorden");
        sl.insert(1,"kobe");

        for(String s : sl){
            System.out.println(s);
        }
        String getResult = sl.get(1);
        System.out.println("获取索引1处的结果为："+getResult);
        String removeResult = sl.remove(0);
        System.out.println("删除的元素是："+removeResult);
        sl.clear();
        System.out.println("清空后的线性表中的元素个数位："+sl.length());
    }
    
}
