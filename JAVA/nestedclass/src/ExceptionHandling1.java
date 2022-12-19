public class ExceptionHandling1 {
    // 해당 메서드 다른 곳에서 호출 할 때 Arithmetic예외 처리 필수
    public static void exception() throws ArithmeticException{
        int kor = 10;
        int eng = 120;
        if(kor>100||eng>100){
            throw new ArithmeticException("점수는 100보다 작거나 같아야 함");
        }
        double avg = (kor+eng)/2;
        System.out.println(avg);
    }
    public static void main(String [] args) throws Exception{
exception();
// Thread 클래스 sleep 메서드는
        // 지정한 시간 동안 현재 스레드 수행 중지
        //인터럽티드exception 을 처리해야함
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
