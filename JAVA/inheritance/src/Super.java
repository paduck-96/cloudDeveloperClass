public class Super {
    private int num;
    protected String name;

    //public Super(){};
    public Super(int num, String name){
        this.num = num;
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
        return "Super{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
