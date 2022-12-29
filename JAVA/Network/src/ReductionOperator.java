import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReductionOperator {
    public static void main(String[] args){
        List<String> list = Arrays.asList("남자","여자","남자1","여자2","여자3","남자","여자");

        // 스트림 생성
        Stream<String > stream = list.stream();
        //stream.forEach((temp)->System.out.println(temp+"\t"));
        // 2개 빼고 출력
        //stream.skip(2).forEach((temp)->System.out.println(temp+"\t"));
        // 2개 빼고 3개 사용
        //stream.skip(2).limit(3).forEach((temp)->System.out.println(temp+"\t"));
        // 중복 제거
        //stream.distinct().forEach((temp)->System.out.println(temp+"\t"));
        // 필터링
        //매개변수 1개, Boolean을 리턴하는 함수 대입
        //stream.filter(name->name.charAt(0) == '남').forEach((temp)->System.out.println(temp+"\t"));
        // 특정 조건을 만족하는 필터 - ㅇ으로 시작
        stream.filter(name->name.charAt(0) >= '아' && name.charAt(0) <'자').forEach((temp)->System.out.println(temp+"\t"));
    }
}
