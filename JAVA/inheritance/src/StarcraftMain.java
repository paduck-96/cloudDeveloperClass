public class StarcraftMain {
    public static void main(String[] args){
        Starcraft star = new Protoss();
        star.attack();

        star = new Zerg();
        star.attack();

        star = new Terran();
        star.attack();

        // 추상 클래스는 인스턴스 생성을 할 수 없어
        //new 생성자 불가
//        start = new Starcraft();
//        star.attack();
    }
}
