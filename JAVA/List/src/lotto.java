import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class lotto {
    //Set 이용해서 구현
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //중복된 데이터를 저장하지 않고 데이터를 정렬해서 저장
        Set<Integer> set = new TreeSet<>();
        while(set.size()<6){
            System.out.print("로또 번호 입력 : ");
            int temp = sc.nextInt();
            if(temp<1||temp>45){
                System.out.println("범위 초과");
                continue;
            }
            //중복 검사
            boolean result = set.add(temp);
            if(result==false){
                System.out.println("중복");
            }
        }
        System.out.println(set);

        //배열로 사용
        Integer[] lotto = (Integer[])set.toArray();
        System.out.println(lotto);
        sc.close();
    }
}
