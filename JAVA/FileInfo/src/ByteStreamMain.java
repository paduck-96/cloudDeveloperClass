import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class ByteStreamMain {
    public static void main(String[] args){

        // 파일에 바이트 단위로 기록
        try(FileOutputStream fos = new FileOutputStream("./sample.txt", true);){
String msg = "Hello Java";
fos.write(msg.getBytes()); // 스트링은 오류, 바이트 변환
            fos.flush();
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
//파일의 내용을 읽기
        try(FileInputStream fis = new FileInputStream("./sample.txt");){
            // 바이트 단위로 읽어오기
            //숫자니 문자열로 가져오지 못함
//            while(true){
//                int x = fis.read();
//                if(x==-1)break;
//                System.out.println((char)x); //숫자 문자로 형 변환
//            }
            while(true){
                // 읽을 수 있는 크기로 바이트 배열 생성
                byte [] b = new byte[fis.available()];
                int len=fis.read(b);
                if(len<=0){
                    System.out.println("읽은 데이터 없음");
                    break;
                }else{
                    // 숫자 배열 출력
                    //텍스트가 아닌 경우
                    //System.out.println(Arrays.toString(b));
                    //문자열로 변환해서 출력
                    //텍스트일 경우
                    System.out.println(new String(b));
                }
            }
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
