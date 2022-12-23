import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Buffer {
    public static void main(String[] args){
        /*
        try(PrintStream ps = new PrintStream(new FileOutputStream("./buffer.txt", true))){
String msg = "한글 입출력 확인할게요";
// write는 바이트 단위 기록이므로
ps.write(msg.getBytes());
// print는 문자열을 스스로 바이트로 변환해 기록
ps.print(msg);
ps.flush();
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        */
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./buffer.txt"))){
            // 나누어서 읽기
            //웹에서 다운로드 받을 때
            while(true){
                byte [] b = new byte[1024]; //128 단위로
                //1024byte 가 패킷의 단위
                int len = bis.read(b, 0, b.length);
                if(len<=0){
                    break;
                }
                // 받은 내용으로 작업
                //다운로드라면 이 순간에 파일에 기록
                //문자열이라면 하나로 모아서 읽기
                //byte를 크게하면 묶어서 처리할 수 있지만
                //읽은 것 이상일 경우 공백이 계속해서 추가
                //trim( ) 혹은 길이 지정해서 해결 가능
                System.out.println(new String(b, 0, len));
            }
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}