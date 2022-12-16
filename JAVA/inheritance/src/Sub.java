public class Sub extends Super{
private String nickname;

public Sub(){
    //System.out.println("상위 클래스 생성자 호출 전 에러");
    // 상위 클래스의 생성자 호출
    super(1, "adam");
    System.out.println("상위 클래스 생성자 호출 뒤 수행은 에러 아님");
}
    @Override
    public String toString() {
    // 상위 클래스의 toString( ) 호출 시
        // 하위에도 toString( ) 있어서 super. 필요
        return super.toString() + "Sub{" +
                "nickname='" + nickname + '\'' +
                '}';
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
