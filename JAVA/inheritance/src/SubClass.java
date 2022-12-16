public class SubClass extends SuperClass {
    public void subMethod(){
        System.out.println("Subclass 만의 메서드");
    }
    
    @Override
    public void display(){
        System.out.println("하위 클래스의 메서드");
    }
    
}
