import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UTIL {
    public static void main(String[] args){
        // 정수 배열
        int [] ar = {60,30,20,87,56};

        // 문자열 배열
        String [] br = {
                "해글러", "헌즈", "두란", "레너드","박종팔"
        };

        // 배열 데이터 확인
        System.out.println(Arrays.toString(ar));
        Arrays.sort(ar);
        System.out.println(Arrays.toString(ar));
        Arrays.sort(br);
        System.out.println(Arrays.toString(br));

        // VO 클래스의 인스턴스 5개 소유하는 배열
        VO [] datas = new VO[5];
        datas[0] = new VO(1,"배수지",28);
        datas[1] = new VO(2,"이지은",29);
        datas[2] = new VO(3,"배주현",31);
        datas[3] = new VO(4,"박수영",26);
        datas[4] = new VO(5,"유지민",22);
        System.out.println(Arrays.toString(datas));
        Arrays.sort(datas);
        System.out.println(Arrays.toString(datas));

        String [] names ={"리치히", "하일스베르", "로섬","고슬링"};
        System.out.println(Arrays.toString(names));

        String [] copy = Arrays.copyOf(names, names.length);
        Arrays.sort(copy);
        System.out.println(Arrays.toString(copy));
        Arrays.sort(copy, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(Arrays.toString(copy));
    }
}
