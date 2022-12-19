public class Embed {
    public String name;

    public void createEmbedded(){
        // 다른 클래스의 인스턴스 생성
        //생성자를 이용한 주입
        //생성자 호출 시 현재 인스턴스의 참조를 넘겨줌
        EmbeddedClass obj = new EmbeddedClass(this);
        //setter를 이용한 주입
        obj.setEmbed(this);

        //포함하는 인스턴스가 포함된 인스턴스의 멤버 호출
        obj.score=100;
        System.out.println(obj.score);
    }
}
