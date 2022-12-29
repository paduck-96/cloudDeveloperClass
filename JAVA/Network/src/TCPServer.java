import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String [] args){
        try{
            // 서버 소켓 생성
            ServerSocket ss = new ServerSocket(9999);
            while(true){
                System.out.println("서버 대기 중");
                // 대기
                Socket socket = ss.accept();
                // 접속한 클라이언트 정보 확인
                System.out.println(socket);
                // 클라이언트 전송 내용 읽기
                BufferedReader br2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                StringBuilder sb = new StringBuilder();
                while(true){
                    String imsi = br2.readLine();
                    if(imsi == null){
                        break;
                    }
                    sb.append(imsi+"\n");
                }
                String text = sb.toString();
                System.out.println(text);
                // 읽을 내용이 한 줄이라면
                //String msg = br.readLine();
                br2.close();
                socket.close();
            }
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
