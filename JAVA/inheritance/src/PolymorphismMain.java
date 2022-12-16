public class PolymorphismMain {
    public static void main(String[] args){
        // 변수 선언 클래스와 인스턴스 생성 클래스가 동일
        SuperClass superClass = new SuperClass(); //당연히 되는 것
        // superClass 변수가 호출할 수 있는 것은
        //변수 선언 클래스의 것들만 가능
        superClass.superMethod();
        superClass.display();
        
        
        // 변수 선언 클래스와 인스턴스 생성 클래스가 상속 관계
        SuperClass subClass = new SubClass(); // 인스턴스 생성 클래스가 하위로 가능
        //변수 선언은 superclass 이나 인스턴스는 subclass
        //호출할 수 있는 건 superclass 를 참조하지만
        //호출되는 건 subclass의 것 => superclass에 있는 걸 subclass 형태로 호출
        subClass.superMethod(); //overriding이 안된 메서드
        subClass.display(); //overriding 된 메서드

        //overriding 된 메서드만 인스턴스 클래스를 따라 감

        SuperClass obj = new SuperClass();
        //대입된 인스턴스는 Superclass 의 인스턴스
        //Superclass -display
        obj.display();
        //대입된 인스턴스는 SubCLass
        //subclass-display
        obj = new SubClass();
        obj.display();
    }
}
