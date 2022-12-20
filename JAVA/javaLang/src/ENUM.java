public class ENUM {

    // 이런 타입으로 만들면
    //Gener Type의 변수는 MAN 아니면 WOMAN만 가능
    public enum Gender{
        MAN, WOMAN;
    }
    // 옵션 사용을 위해서 예전에는 final 상수
    public static void main(String[] args){
        final int MAN = 0;
        final int WOMAN = 1;

        //int 로 생성 시 정의하지 않은 값 대입 가능
        //int gender = MAN;
        //gender = 3;

        // Gender 가 enum 이므로
        Gender t = Gender.MAN;
        t = Gender.WOMAN;
        //t = Gender.HUMAN;
    }
}
