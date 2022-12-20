public class InstanceInner {
    // 내부 클래스의 특성에 static 추가되면
    //외부에서 인스턴스 생성시 클래스이름.new 내부클래스( )
    //안드로이드 뷰의 이벤트 인터페이스가 이런 방식
    public static class Inner{
public int score;
// 내부 클래스에 static 멤버가 존재하면
        //클래스 접근 지정자도 static 으로 추가
public static int autoIncrement;
    }
}
