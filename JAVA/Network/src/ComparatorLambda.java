import java.util.Arrays;
import java.util.Comparator;

public class ComparatorLambda {
    public static void main(String [] args){
        // 데이터 정렬을 위한 문자열 배열
        String [] ar = {"야구", "축구", "배구", "농구", "당구"};
        Arrays.sort(ar, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 내림차순
                return o2.compareTo(o1);
            }
        });

        // 코드는 간결하나 가독성 감소
        Arrays.sort(ar, (o1,o2)->
        //{
            //return
            o2.compareTo(o1)
                //;
        //}
        );
        System.out.println(Arrays.toString(ar));
    }
}