public class Student {
    public static String schoolName;

    // static 초기화
    static{
        System.out.println("로고 출력");
        //static 변수 사용 가능
        schoolName = "스카이캐슬";
        //num= 1; 인스턴스 사용 불가
    }
    // 클래스 내부라면 선언만 가능
    //생성자로 해결
    public final int x;
    public Student(){
        x = 1;
    }
    // 인스턴스 속성 생성
    //접근지정자가 public 이므로 외부에서 인스턴스를 통해 접근 가능
    public String name;
    //protected int num;
    //같은 패키지 내에서는 public으로 적용
    int num;
    public int kor;
    public int eng;
    public int mat;
}
