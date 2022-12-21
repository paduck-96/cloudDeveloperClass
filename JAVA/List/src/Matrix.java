import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class VO2{
    private int num;
    private String name;

    public VO2(int num, String name) {
        super();
        this.num = num;
        this.name = name;
    }
    public VO2(){
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
        return "VO2{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Matrix {
    public static void main(String[] args){
        // 배열의 배열 - 2차원 배열
        //Matrix 태그가 없음
        String [] doro = {"배유나", "박정아", "문정원"};
        String [] lg = {"안혜진", "유서연"};
        String [] ginseng = {"몰라", "몰라2", "몰라3"};
        //데이터 추가할 경우 하위 구조도 변경해야 하기 때문에 굉장히 비효율
        // 이차원 배열
        String [] [] volley = {doro,lg};

int i =0;
        for(String [] temp : volley){
            if(i==0){System.out.print("도로공사\t");}else{System.out.print("\nLG\t");}
            i++;
            for(String imsi : temp){
                System.out.print(imsi+"\t");
            }
        }
        // 이차원 배열 대신에 Map의 배열로
        //테이블 구조
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name","도로공사");
        map1.put("team",doro);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name","LG");
        map2.put("team",lg);
        Map<String, Object> map3 = new HashMap<>();
        map2.put("name","인삼공사");
        map2.put("team",ginseng);

        Map [] v = {map1, map2, map3};

        for(Map map : v){
            System.out.println(map.get("name")+"\t");
            String [] temp = (String[]) map.get("team");
            for(String imi : temp){
                System.out.println(imi+"\t");
            }
            System.out.println();
        }
    }
}
