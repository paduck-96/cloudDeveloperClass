import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class WebTextDownload {
    public static void main(String[] args){
        try{
            // kakao의 주소 정보 가져오기
            InetAddress ia = InetAddress.getByName("www.kakao.com");
            // 카카오에 연결
            Socket socket = new Socket(ia, 80);
            // 요청 전송 스트림 생성
            PrintWriter ps = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            // 요청 전송
            ps.println("GET https://www.kakao.com");
            ps.flush();

            // 문자 단위로 전송을 받기 위한 스트림
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 여러 줄의 문자열 하나로 만들기
            StringBuilder sb = new StringBuilder();
            while(true){
                String imsi = br.readLine();
                if(imsi == null){
                    break;
                }
                sb.append(imsi+"\n");
            }
            String html = sb.toString();
            System.out.println(html);
            // 사용한 자원 정리
            br.close();
            ps.close();
            socket.close();
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
