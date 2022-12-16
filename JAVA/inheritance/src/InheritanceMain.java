public class InheritanceMain {
    public static void main(String[] args){
        Sub sub = new Sub();
        // Sub 클래스에 만들지 않았던 setNum 과 Name 사용 가능
        sub.setNum(0);
        sub.setName("hh");
        sub.setNickname("222");

        System.out.println(sub);

        Super s1 = new Super(1,"1");
        Sub s2 = new Sub();

        // 상위 클래스 타입의 참조형 변수에는
        //하위 클래스 타입의 인스턴스 참조 바로 대입 가능
        Super s3 = new Sub();
        // 하위 클래스 타입의 참조형 변수에는
        //상위 클래스 타입의 인스턴스 참조 대입 불가
        //강제 형 변환은 가능
        //Sub s4 = new Super(2,"33");
        // s3에 대입된 인스턴스는 원래 Sub 타입
        Sub s4 = (Sub) s3;
        // 원래 타입이 Super 이기 때문에 예외
        Sub s5 = (Sub)(new Super(1,"hh")); //예외 발생
    }
    
}
