import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class LogMain {
    public static void main(String[] args){
        //파일 경로 확인
        File file = new File("log.txt");
        System.out.println(file.exists());

        //문자열 스트림 생성
        try(BufferedReader br = new BufferedReader(new FileReader("log.txt"))){
            int sum = 0;
            while(true){
                String log = br.readLine();
                if(log==null){
                    break;
                }
                //System.out.println(log);
                //공백을 기준으로 분할
                String [] ar = log.split(" ");
                //트래픽(특정 값) 확인
                //System.out.println(ar[ar.length-1]);
                try{
                    sum = sum + Integer.parseInt(ar[ar.length - 1]);

                }catch(Exception e){
                    System.out.println(e.getLocalizedMessage());
                }
                //System.out.println(sum);
                /**
                 * IP별 합계 구하기
                 */
                Map<String, Integer> maps = new HashMap<>();
                int mapSum = 0;
                try{
                    maps.put(ar[0], Integer.parseInt(ar[ar.length - 1]));
                }catch(Exception e){
                    System.out.println(e.getLocalizedMessage());
                }
                System.out.println(maps);
            }

        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
