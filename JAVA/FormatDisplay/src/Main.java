public class Main {
    public static void main(String[] args) {
        
        int n = 37;
        double d = 23.768952;
        String name1 = "adam";
        String name2 = "아담12";
        
        // 정수 출력
        //10자리 확바
        //남는 자리 0 추가
        System.out.printf("n:%d\n", n);
        System.out.printf("n:%10d\n", n);
        System.out.printf("n:%010d\n", n);

        // 소수 출력
        //6자리까지
        //3자리까지 - 반올림
        System.out.printf("n:%f\n", d);
        System.out.printf("n:%.3f\n", d);

        // 문자열 출력
        //%s 는 문자열 출력이 아니라
        //시작위치부터 바이트 단위로 데이터를 가져와서
        //문자로 변환 후 출력, null 만날 때까지 출력
        System.out.printf("n1:%10s\n", name1);
        System.out.printf("n2:%10s\n", name2);
    }
}