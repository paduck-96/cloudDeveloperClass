import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionHandling2 {
    public static void main(String[] args){

        String message = null;
        try(
                //br은 처리가 완료되면 자동으로 close()를 호출
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ) {
            message = br.readLine();
            //br.close(); 코드 작성 상에서는 굉장히 잘못된 행동
            //동일하게 에러 발생 시 close는 작동하지 않음
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(message);
        // 입출력에 사용되는 스트림은 반드시 닫아야 함

    }
}
