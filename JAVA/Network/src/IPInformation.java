import java.io.FileInputStream;
import java.net.InetAddress;
import java.util.Arrays;

public class IPInformation {
    public static void main(String[] args){
        try{
            // 자신의 컴퓨터 ip 확인
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println(localhost);
            // 도메인을 가지고 ip 확인
            InetAddress [] naver = InetAddress.getAllByName("www.naver.com");
            System.out.println(Arrays.toString(naver));
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            // 오늘 날짜로 txt 파일을 만들어서 예외 처리 기록

        }
    }
}
