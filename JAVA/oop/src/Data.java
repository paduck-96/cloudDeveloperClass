public class Data {
    // auto_increment 와 같은 형식
    private static int sequence;
    static{
        sequence = 1;
    }
    private int num;
    private String name;

    public Data() {
        super();
        num = sequence++;
    }

    public Data(String name) {
        this.num = sequence++;
        this.name = name;
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

    @Override
    public String toString() {
        return "Data{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
