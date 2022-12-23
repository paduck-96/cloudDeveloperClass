import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Buffer {
    public static void main(String[] args){
        try(PrintStream ps = new PrintStream(new FileOutputStream("./buffer.txt", true))){
String msg = "Hello Stream";
// write는 바이트 단위 기록이므로
ps.write(msg.getBytes());
// print는 문자열을 스스로 바이트로 변환해 기록
ps.print(msg);
ps.flush();
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./buffer.txt"))){
            // while문 밖에 생성해 조건으로 확인
            byte [] b = new byte[bis.available()];
            while(bis.read(b)>0){
                // 파일에서 읽을 수 있는 크기로 바이트 배열 생성
                //byte [] b = new byte[bis.available()];
                //읽기
                //데이터 자체 확인
                System.out.println(Arrays.toString(b));
                //문자열로 변환
                System.out.println(new String(b));
            }
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
