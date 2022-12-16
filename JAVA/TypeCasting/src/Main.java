public class Main {
    public static void main(String[] args) {

        double d = 37.4;
        // 실수를 정수에 대입하면 오류
        //int n = d;
        //자료 손실 발생
        int n = (int) d;
        System.out.println(n);

        short s1 = 200;
        short s2 = 300;
        // 최소 단위 int
        //short result = s1+s2;
        short result = (short)(s1+s2);
        System.out.println(result);

        // 정수 2개 평균
        int score1 = 91;
        int score2 = 90;
        double avg = (score2+score1) /2;
        System.out.println(avg);
        avg = ((double)score2+score1) /2;
        System.out.println(avg);
    }
}