public class Main {
    public static void main(String[] args) {
        String [] nicknames = {"adam", "군계", "파이터"};
        // 인스턴스 생성
        Data original = new Data(1, "itstudy", nicknames);
        // 인스턴스의 참조 복사
        //참조 대상이나 원본이 내부 데이터를 변경하면 영향을 줌
        Data data = original;
        System.out.println(original);
        data.setNum(2);
        System.out.println(original);

        // 자바는 복제를 이용하고자 하는 경우 clone 메서드를 재정의
        //재정의할 때 cloneable 인터페이스 implements

        Data copy = original.clone();
        System.out.println(original);
        copy.setNum(3);
        System.out.println(original);
        String [] newNicknames = copy.getNicknames();
        newNicknames[0]="아담";
        System.out.println(original);

        Data data1 = new Data(1, "구름", null);
        Data data2 = new Data(1, "구름", null);
        // ==는 참조를 비교하는 연산자
        //2개의 instance는 각각 생성자를 호출하여 참조 다름
        //내용이 같은지는 equals 재정의로 확인
        System.out.println(data1==data2);
        System.out.println(data1.equals(data2));
    }
}