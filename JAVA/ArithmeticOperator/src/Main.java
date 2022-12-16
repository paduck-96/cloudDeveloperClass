public class Main {
    public static void main(String[] args) {

        short s1 = 20;
        short s2 = 30;
        // 자바의 산술연산 최소 단위는 int
        //int로 변환 연산 수행 해 오류
        //short result = s1+s2;
    int result = s1+s2;

    double d = 0.1;
    double tot = 0.0;
    for(int i =0; i<100;i++){
        tot = tot+d;
    }
    System.out.println(tot);

    // 나누기 연산에서의 나누는 수 확인
        //0으로 나눈 것이 에러가 아닐 수도
        //연산이 되지 않을 경우 Infinity 나 NaN이 될 수 있음
        System.out.println(5/0.0);
    }
}