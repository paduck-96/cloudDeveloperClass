public class Main {
    public static void main(String[] args) {

        System.out.println(10>3);
        // 정수는 자료형 달라도 비교 가능
        System.out.println(10 > 10L);
        System.out.println(10L > 10);
        // 실수 크기 비교는 정확하지 않을 수 있음
        System.out.println((1.0-0.8)>=0.2);

        int n1 = 10;
        int n2 = 10;
        long n3 = 10L;
        System.out.println(n1==n2);
        System.out.println(n1==n3);
        // 실수나 문자열은 주의
        //문자열 리터럴 혹은 외부 입력에 따라 다름
        String s1 = "JAVA";
        String s2 = "JAVA";
        System.out.println(s1 == s2);
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String s3 = sc.nextLine();
        System.out.println(System.identityHashCode(s3));
        //System.out.println(s1 == s3 || s2==s3);
        System.out.println(s1.equals(s3));

    }
}