public class Table {
    private static int sequence; //일련번호
    private static int step = 1; //mysql 과 오라클 차이
    //mysql은 step이 있음

    public static int getSequence() {
        return sequence;
    }

    public static void setSequence(int sequence) {
        Table.sequence = sequence;
    }

    public static int getStep() {
        return step;
    }

    public static void setStep(int step) {
        Table.step = step;
    }

    // 인스턴스 별도 소유
    private int num;

    public int getNum() {
        return num;
    }

    public Table(){
        sequence += step;
        num = sequence;
    }
}
