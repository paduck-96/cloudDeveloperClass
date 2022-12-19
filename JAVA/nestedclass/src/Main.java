public class Main {
    public static void main(String[] args) {
        // 외부 클래스의 인스턴스를 생성
       //InstanceInner instanceInner = new InstanceInner();
       // 내부 클래스의 인스턴스 생성
       //InstanceInner.Inner obj = instanceInner.new Inner();

        // static inner class 의 인스턴스 생성
        InstanceInner.Inner obj = new InstanceInner.Inner();

        // 인스턴스 생성
        //인터페이스나 추상 클래스 등을 상속해서 클래스를 만들고
        //인스턴스를 만드는 경우
        //변수는 대부분 인터페이스 나 추상 클래스 이름으로 만들고
        //생성자는 사용하고자 하는 클래스의 생성자를 이용하는 경우가 많음
        SampleAble instance = new SampleAbleImpl();
        // 메서드 호출
        instance.method();

        // Anonymous class 사용
        SampleAble anonymous = new SampleAble() {
            @Override
            public void method() {
                System.out.println("annonymous");
            }
        };
        anonymous.method();

        // 메서드 1회 호출 시 변수 생성 불필요
        new SampleAble(){

            @Override
            public void method() {
                System.out.println("변수도 안 만들고 anonymous");
            }
        }.method();

        // public 클래스에 public static 속성은 어느 곳에서나 호출 가능
        GlobalData.global = 10;

        //Singleton singleton1 = new Singleton();
        //Singleton singleton2 = new Singleton();
        Singleton singleton1 = Singleton.sharedInstance();
        Singleton singleton2 = Singleton.sharedInstance();
        System.out.println(System.identityHashCode(singleton1));
        System.out.println(System.identityHashCode(singleton2));

        Table row1 = new Table();
        System.out.println(row1.getNum());
        Table.setStep(10);
        Table row2 = new Table();
        System.out.println(row2.getNum());
    }
}