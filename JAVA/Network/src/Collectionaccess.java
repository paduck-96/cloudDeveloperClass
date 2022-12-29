import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Collectionaccess {

public static void main(String[] args){
    List<String> list = new ArrayList<>();
    list.add("java");
            list.add("java web progam");
    list.add("Spring");
    list.add("Spring");
    int len = list.size();
    for(int i=0;i<len;i++){
        System.out.println(list.get(i)+"\t");
    }

    // 이터레이터 사용
    Iterator<String> iterator = list.iterator();
    while(iterator.hasNext()){
        System.out.println(iterator.next());
    }
    // 빠른 열거
    for(String temp:list){
        System.out.println(temp+"\t");
    }

    // 스트림 api 활용
    //내부 반복자를 활용하게 때문에 가증 빠름
    Stream<String> stream = list.stream();
    //stream.forEach(System.out::print);
    stream.forEach(temp->System.out.println(temp+"\t"));
}}
