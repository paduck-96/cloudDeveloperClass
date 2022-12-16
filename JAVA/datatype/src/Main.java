public class Main {
    public static void main(String[] args) {

        int x = 100;
        System.out.println(x);
        int y = 100;
        // 같은 참조를 가지기 때문에 같은 해시코드
        System.out.println(System.identityHashCode(x));
        System.out.println(System.identityHashCode(y));
        
        // 자료형보다 크면 에러
        //x = 2000000000000;
        long l = 200_000_000_000_0L;
        System.out.println(l);

        // 16진수 저장
        //참조 나 색상
        x = 0x789;
        System.out.println(x);
        // 8진수 저장
        //권한 설정 시 사용 - rwx
        x = 0777;
        System.out.println(x);

        float f = 0.12345678f;
        System.out.println(f);
        // 정확도 초과시 자동 반올림
        f = 0.12345678923456f;
        System.out.println(f);

        char ch = 'A';
        System.out.println(ch);
        System.out.println(ch+1);
        //ch = \142;
        System.out.println(ch);
        ch = '\uAC00';
        System.out.println(ch);

        // int 의 경우 21억 정도 까지 저장 가능하나
        //21억을 넘어서서 - overflow
        //음수로 변경
        x = 2000000000 + 1000000000;
        System.out.println(x);
        // undeflow
        //양수처리
        x = -2000000000 + -1000000000;
        System.out.println(x);
    }
}