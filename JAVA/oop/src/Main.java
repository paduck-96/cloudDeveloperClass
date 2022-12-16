public class Main {
    public static void main(String[] args) {
        //Student 클래스의 인스턴스 생성
        Student student = new Student();
        student.num = 1;
        student.name = "아이린";
        student.kor = 32;
        student.eng = 29;
        student.mat = 40;

        Student student1 = new Student();
        student1.num=2;
        // 인스턴스 속성은 인스턴스 별로 별도로 소유
        System.out.println(student.num);
        System.out.println(student1.num);
student.schoolName = "명덕고";
student1.schoolName = "제일중";
// static 속성은 모든 인스턴스가 공유하므로
        //동일데이터 출력
        System.out.println(student.schoolName);
        System.out.println(student1.schoolName);

        //static 메서드는 클래스 이름으로 호출 가능
        MethodClass.method1();
        // 클래스 이름을 가지고 메서드 호출 불가
        //MethodClass.method2();
        //인스턴스 메서드 호출
        MethodClass methodClass = new MethodClass();
        methodClass.method2();
        //methodClass.method1(); 인스턴스를 이용한 static 메서드 호출 가능하나 경고

        // 참조형 변수를 만들지 않고 인스턴스로 호출
        new MethodClass().method2();
    new MethodClass().noArgsMethod(3);
    new MethodClass().noArgsMethod(3, "hhhh");

    methodClass.addWithInteger(10,15);
    int result = methodClass.addWithInteger(20,20);
    System.out.println(result); //결과 재사용 가능

        int x = 10;
        methodClass.callByValue(x);
        System.out.println(x);
        int [] ar = {10,20,30};
        methodClass.callByReference(ar);
        // 배열을 메서드에게 넘기면 배열의 내용 변경
        //메서드의 리턴이 없다면 print 제외하고는 원본을 변경
        System.out.println(ar[0]);
        methodClass.thisMethod();
        System.out.println(methodClass.noRecursionFibonacci(3));
        System.out.println(methodClass.recursionFibonacci(3));

        methodClass.display("ski");
        methodClass.display("ski","board","zet","glide");
    }
}