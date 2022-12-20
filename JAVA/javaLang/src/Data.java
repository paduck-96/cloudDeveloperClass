import java.util.Arrays;
import java.util.Objects;

// 하나의 데이터 묶음을 표현 - VO
public class Data implements Cloneable{
    private int num;
    private String name;
    private String [] nicknames;

    // 속성을 대입받아서 생성하는 생성자
    //인스턴스 빠르게 초기화시 주로 이용
    public Data(int num, String name, String[] nicknames) {
        this.num = num;
        this.name = name;
        this.nicknames = nicknames;
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

    public String[] getNicknames() {
        return nicknames;
    }

    public void setNicknames(String[] nicknames) {
        this.nicknames = nicknames;
    }

    // default Constructor
    public Data(){
        super();
    }

    // 인스턴스의 내용을 빠르게 만들 때 상ㅇ
    //디버깅 위한 메서드
    @Override
    public String toString() {
        return "Data{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nicknames=" + Arrays.toString(nicknames) +
                '}';
    }
    
    public Data clone(){
        Data data = new Data();
        // 이 방식은 얕은 복사
        //num은 숫자로 바로 복제 가능
        //name 과 nicknames 은 숫자 데이터가 아니라서
        //바로 대입시 참조가 대입
        data.setNum(this.num);
        data.setName(this.name);
        //data.setNicknames(this.nicknames);
        //참조를 대입할 수 밖에 없는 구조
        /**
         * 배열 요소 하나씩 접근해 일일이 전달
         * String [] nicknames = new String[this.nicknames.length];
         *         for(int i=0; i<nicknames.length;i++){
         *             nicknames[i] = this.nicknames[i];
         *         }
         */
        // 배열 복제 후 대입 - 깊은 복사
        String [] nicknames = Arrays.copyOf(this.nicknames, this.nicknames.length);
        data.setNicknames(nicknames);
        
        return data;
    }

    @Override
    public boolean equals(Object other){
        boolean result = false;
        // 원래 자료형으로 변환
        Data other1 = (Data)other;
        // 숫자나 boolean 은 == 로 일치여부 판단
        //그 이외 자료형은 equals 로 판단
        if(this.num == other1.getNum() && this.name.equals(other1.getName())){
            return true;
        }

        //Objects.hash(데이터 나열)
        //데이터를 가지고 정수로 만든 해시코드 생성
        //return result;
        return (Objects.hash(num, name)) == (Objects.hash(other1.getNum(), other1.getName()));
    }
}
