import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class VO{
    private int num;
    private String name;

    public VO(int num, String name) {
        super();
        this.num = num;
        this.name = name;
    }
    public VO(){
        super();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "VO{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}

public class MVC{
    public static void main(String[] args){
        //데이터 생성 - model
        VO vo = new VO(1, "adam");

        //데이터 출력 - View
        //모델의 근원이 도는 VO 클래스 안에 속성 이름을 변경하면
        //view도 수정되어야 함
        //관계형 DB는 VO 클래스 활용
//        System.out.println(vo.getNum());
//        System.out.println(vo.getName());
        Map<String , Object> map = new HashMap<>();
        //데이터 저장-모델
        map.put("num",1);
        map.put("name","adam");

        // map의 모든 키를 가져와서 출력
        Set<String > keys = map.keySet();
        for(String key:keys){
            System.out.println(key+" : "+map.get(key));
        }
    }
}