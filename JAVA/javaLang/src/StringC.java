import java.io.UnsupportedEncodingException;

public class StringC {
    public static void main(String[] args){
        String str = "Hello";
        System.out.println(System.identityHashCode(str));
        //String은 데이터 수정이 불가
        //새로운 공간에 기존 문자열 복사해 작업하고
        //그 참조를 다시 리턴
        //기존의 데이터가 저장된 공간은 메모리 낭비
        str += "java";
        System.out.println(System.identityHashCode(str));

        // 변경 가능한 문자열 저장
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(System.identityHashCode(sb));
        sb.append("java");
        System.out.println(System.identityHashCode(sb));

        // 여러 데이터를 가지고 하나의 문자열 생성
        double lat = 12.789;
        double lng = 24.2987;

        //위도 경도 형태의 문자열 생성
    String msg = String.format("위도:%.3f 경도:%.3f\n", lat, lng);
    System.out.println(msg);

    String strs = "안녕하세요";
    // 바이트 배열로 변환
        try {
            //동일한 프로그램이 아닌 시스템과 채팅할 때는
            //문자열 직접 전송하지 않고
            //바이트 배열로 만덜어서 전송
            byte [] bytes = strs.getBytes("MS949");
            //byte 배열 문자열로 변환
            String result = new String(bytes, "MS949");
            System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }
}
