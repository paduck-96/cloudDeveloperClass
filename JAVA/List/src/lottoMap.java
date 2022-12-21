import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 데이터 클래스 VO

public class lottoMap {

public static void main(String[] args){
//Map 활용
    //데이터의 종류가 1가지라면 Object 대신에
    //해당 자료형 기재
    Map<String, Object> map = new HashMap<>();
    map.put("name", "adam");
    // 중복key값 입력 시 수정
    System.out.println(map.get("name"));
    map.put("name","군계");
    System.out.println(map.get("name"));
    System.out.println(map.get("name2"));

    //value를 Object로 설정했을 때
    //삽입은 String 이지만
    //Map의 Value type이 Object이기 때문에
    //String value = map.get("name");
    //원상 복구하고자 하면 강제 형 변환
    String value = (String) map.get("name");

    // 모든 키 가져오기
    Set<String > keys = map.keySet();
    System.out.println(keys);


}
}
