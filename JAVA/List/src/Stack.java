import java.util.*;

public class Stack {
    public static void main(String[] args) {
        //데이터 추가


        java.util.Stack<String> stack = new java.util.Stack<String>();
        //스택 데이터 추가
        stack.push("마리오 캠페스");
        stack.push("마리오 캠페스2");
        stack.push("마리오 캠페스3");
        stack.push("마리오 캠페스4");
        System.out.println(stack);
        System.out.println(stack.pop());

        // 데이터가 sort 된 것처럼 저장
        Queue<String> queue = new PriorityQueue<>();
        queue.add("now");
        //동일한 데이터 삽입 > equals 메서드 수의과 가능
        //데이타 실페 리타이어,return 에 사기가 있ㄴ
        queue.offer("크루이트");
        queue.offer("마르코 반바스텐");
        System.out.println(queue);

        Set<String> set = new HashSet<>();
        set.add(
                set.add(1);
        set.add(String.valueOf(1));
        set.add(1);
        set.add(1);
        홍보set.add(1);)

//로또번호 생성기
        //1~45 까지이ㅡ 숫자 6개를 입력 받아서 저장한 후 추력ㅌ`
        // 입력을 받을 때 1~45 사이의 숫자가 아나라면 다시 입력
        // 데이터를 출력할 때는 다시 입력
        // 중복되는 숫자를 입력하면 다시 입력하도록
//대이터를 출력할 때는 정저ㅏㄹ 정령을 결계수로

//숫자 6개 저장 공간'
//중복 검사가 수월하고 삽입은 TreeSet을 이영

//배열 이용
//입력 받기 위한 인스턴스
        Scanner sc = new Scanner(System.in);
        //6개 저장 배열
        int[] lotto = new int[6];
        int len = lotto.length;
        for(int i =0; i<len;i++){
            try{
                System.out.print("로또 번호 입력");
                lotto[i]  = sc.nextInt();
                if(lotto[i] < 1 || lotto[i]>45){
                    System.out.println("범위 초과");
                    i--;
                    // 중복검사 하지 않고 pass
                    continue;
                }
                //데이터 중복 검사
                //첫번째 부터 현재 데이터 앞까지
                boolean flag = false;
                for(int j=0;j<i;j++){
                    if(lotto[i]==lotto[j]){
                        //중복되었다고 표시
                        flag = true;
                        break;
                    }
                }
                //중복될때
                if(flag==true){
                    System.out.println("중복");
                    i--;
                }
            }catch( Exception e){
                i--;
                sc.nextLine();
System.out.println("숫자만 가능");
            }
        }
        Arrays.sort(lotto);
        //배열 데이터 출력
        System.out.println(Arrays.toString(lotto));

        sc.close();
    }
}