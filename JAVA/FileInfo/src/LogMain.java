import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LogMain {
    public static void main(String[] args){
        //문자열 스트림 생성
        try(BufferedReader br = new BufferedReader(new FileReader("log.txt"))){
            int sum = 0;
            Map<String, Object> maps = new HashMap<String, Object>();
            while(true){
                String log = br.readLine();
                if(log==null){
                    break;
                }
                //공백을 기준으로 분할
                String [] ar = log.split(" ");
                //System.out.println(Arrays.toString(ar));
                //트래픽(특정 값) 확인
                //System.out.println(ar[ar.length-1]);
//                try{
//                    sum = sum + Integer.parseInt(ar[ar.length - 1]);
//
//                }catch(Exception e){
//                    System.out.println(e.getLocalizedMessage());
//                }
//                System.out.println(sum);
                /**
                 * IP별 합계 구하기
                 */

                try{
                    Object temp = maps.get(ar[0]);
                    if(temp==null){
                        maps.put(ar[0], Integer.parseInt(ar[ar.length-1]));
                    }else{
                        int value = (Integer)maps.get(ar[0]);
                        value = value + Integer.parseInt(ar[ar.length-1]);
                        maps.put(ar[0], value);
                    }




                }catch(Exception e){
                    System.out.println(e.getLocalizedMessage());
                }
                Set<String> keys = maps.keySet();
                for(String key : keys){
                    System.out.println(key + " : "+maps.get(key));
                }

            }

        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
