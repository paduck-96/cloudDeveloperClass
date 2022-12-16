public class Main {
    public static void main(String[] args) {
        int n1 = 20;
        int n2 = -20;
        // 2진수 구조
        System.out.println("n1"+
                Integer.toBinaryString(n1));
        System.out.println("n1"+
                Integer.toBinaryString(n2));
        // 1의 보수 구하기
        System.out.println("n2 : "+
                Integer.toBinaryString(~n2));

    }
}