import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 정수를 저장하기 위한 ArrayList;
        List <Integer> al = new ArrayList<>();
        // 정수 저장 LinkedList
        List <Integer> li = new LinkedList<>();

        for(int i =0; i<100000;i++){
            al.add(i);
            li.add(i);
        }
        long start;
        long end;
        start = System.currentTimeMillis();
        for(int i =0; i<100000; i++){
            Integer integer = al.get(i);

        }
        end = System.currentTimeMillis();
        System.out.println("ArrayList : " +(end-start));
        start = System.currentTimeMillis();
        for(int i =0; i<100000; i++){
            Integer integer = li.get(i);

        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList : " +(end-start));

        List <String> list = new ArrayList<>();
        list.add("클루망");
        list.add("이상천");
        list.add("브롬달");
        list.add("쿠드롱");

        //순홰
        for(String temp : list){
            System.out.println(temp);
        }
        //정렬
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);
    }
}