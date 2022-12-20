public class MethodClass {
    private static int num;
    private String name;
    public static void method1(){
        num=1;
        // static 메서드에서는 instance 속성 사용 불가
        //this. 가 없어
        //name="adam";
        System.out.println("static method");
    }

    public void method2(){
        num = 1;
        name="adam";
        System.out.println("instance method");
    }

    // static 은 인스턴스를 생성할 필요가 없음
    public static void noArgsMethod(){
        for(int i =0;i<5;i++){
            System.out.println("method");
        }
    }

    // 매개변수가 정수 1개인 메서드
    public static void noArgsMethod(int n){
        for(int i =0;i<n;i++){
            System.out.println("method");
        }
    }
    public static void noArgsMethod(int n,String msg){
        for(int i =0;i<n;i++){
            System.out.println(msg);
        }
    }
    // 리턴이 없는 메서드는 연속해서 호출 불가능
    public int addWithInteger(int first, int second){
        //System.out.println((first+second));
        return (first+second);
    }

    public void hi(){
        return;
    }
    public void hi(int a, String b){
        return;
    }
    public void hi(String b, int a){
        return;
    }

    // 매개변수 기본형 1개
    //내부에서 매개변수 값 수정해도 넘겨준 데이터는 변경되지 않음
    public static void callByValue(int n ){
        n=n+1;
        System.out.println(n);
    }

    // 매개변수가 참조형
    public static void callByReference(int [] ar) {
        ar[0] = ar[0]+1;
        System.out.println(ar[0]);
    }
    
    public int score = 100;
    public void thisMethod(){
        int score = 200;
        // scope 법칙 - 동일한 이름은 가까이나 최근게 사용됨
        System.out.println(score);
        System.out.println(this.score);
    }

    public static int noRecursionFibonacci(int n){
        int n_1 = 1;
        int n_2 = 1;
        int fibo = 1;
        int i = 3;
        while(i<=n){
            fibo=n_1+n_2;

            n_2 = n_1;
            n_1=fibo;
            i=i+1;
        }
        return fibo;
    }
    // 재귀를 이용한 피보나치 수열
    public static int recursionFibonacci(int b){
        if(b==1 || b==2){
            return 1;
        }
        return recursionFibonacci(b-1)+recursionFibonacci(b-2);
    }

    // 매개변수 개수 가변
    public static void display(String ... args){
        for(String temp : args){
            System.out.println(temp);
        }
    }
}
