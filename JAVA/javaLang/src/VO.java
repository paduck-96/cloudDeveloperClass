// 크기 비교가 가능한 메서드가 있다는 것을 보장
public class VO implements Comparable<VO> {
    private  int num;
    private String name;
    private int age;

    public VO() {
        super();
    }

    public VO(int num, String name, int age) {
        super();
        this.num = num;
        this.name = name;
        this.age = age;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "VO{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(VO o) {
        // 숫자는 뺄셈으로 정렬 가능
        //return this.age-o.age;
        return this.name.compareTo(o.name);
    }
}
