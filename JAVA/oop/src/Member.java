import java.util.Date;

public class Member {
    private String email;
    private String password;
    private String [] nicknames;
    private Date birthday;
    private boolean married;
    private int age;

    // 모든 속성을 매개변수로 받아 초기화해주는 생성자
    public Member(String email, String password, String [] nicknames, Date birthday, boolean married, int age) {
        this.email = email;
        this.password = password;
        this.nicknames = nicknames;
        this.birthday = birthday;
        this.married = married;
        this.age = age;
    }
    // 매개변수가 없는 생성자
    //기본 제공, 생성자 생성시 소멸


    public Member() {
        super();
    }

    // 메서드 접근자
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getNicknames() {
        return nicknames;
    }

    public void setNicknames(String[] nicknames) {
        this.nicknames = nicknames;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 속성에 배열이나 List 와 같은 컬렉션이 있을 때는
    //컬렉션 내에서 하나의 데이터만 읽고 쓸 수 있는 메서드 제공 고려
    public String getNickname(int index){
        return nicknames[index];
    }
    public void setNickname(int index, String nickname){
        nicknames[index] = nickname;
    }

    // 6개의 값을 받아서 속성 초기화
    public void init(String email, String password, String [] nicknames, Date birthday, boolean married, int age){
        // 클래스 메서드 안에서 속성 이름 사용시
        //메서드 안에 만들어진 것을 먼저 찾고
        //클래스에 만들어진 것을 이후에 찾고, 마지막에는 상위 클래스에서 찾음
        //바로 클래스에 만들어진 걸 찾으려면 this.
        //상위 클래스는 super
        this.email = email;
        this.password = password;
        this.nicknames=nicknames;
        this.birthday=birthday;
        this.married=married;
        this.age=age;

    }

    // 모든 속성의 toString 호출해 하나의 문자열로
    //출력 메서드에서 인스턴스 이름 대입시 자동 호출
    //디버깅 위해 작성
    @Override
    public String toString(){
        return "Member [email=" + email+", password=" + password + ", nicknames="+ nicknames + ", birthday=" + birthday +", married" + married +", age=" + age;
    }
}
