import java.math.BigDecimal;

public class WrapperC {
    public static void main(String[] args) {
        //Wrapper 클래스 사용
        Double d = new Double(13.67);
        d = 17.23; // 기본형 대입시 new Double()로 변환
        System.out.println(d);
        double x = d;
        System.out.println(x);

        double d1 = 1.600000000000;
        double d2 = 0.100000000000;
        System.out.println(d1+d2); //1.7이 아님

        // 정확한 산술 연산을 위해
        //BigDecimal로 데이터 만들고 연산 수행시 정확한 결과 확인
        BigDecimal b1 = new BigDecimal("1.600000000000000");
        BigDecimal b2 = new BigDecimal("0.100000000000000");
        System.out.println(b1.add(b2));


    }
}
