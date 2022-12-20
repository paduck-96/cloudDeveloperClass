import java.util.Date;

public class ConstructorMain {

    public static void main(String[] args){
        // 인스턴스 생성
        Member member = new Member();
        member.setAge(27);
        member.setBirthday(new Date()); // 오늘 날짜 설정
        member.setBirthday(new Date(1970,5,29)); // 특정 날짜 설정
//        //월은 +1 크게, 년도는 1970을 빼고
        member.setEmail("test@kakao.com");
        member.setMarried(false);
        member.setPassword("1234");

        String [] nicknames = {"카카오","네이버","배달의민족"};
                member.setNicknames(nicknames);

                System.out.println(member);

                Member member1= new Member();
                member1.init("tt@kakao.com", "1234",nicknames,new Date(),false,5);
                System.out.println(member1);

                //

        //생성자를 이용한 초기화
                Member member2 = new Member("tt@kakao.com", "1234", nicknames , new Date(),false,5);
                System.out.println(member2);
    }
}
