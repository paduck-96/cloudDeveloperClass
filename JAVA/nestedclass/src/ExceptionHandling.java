public class ExceptionHandling {
    public static void main(String[] args){
        int i=0;
        int j=0;
        try {
            System.out.println(i / j);
        }// catch가 여러개면 일치하는 catch 블럭 처리 후
        //다른 catch 는 모두 pass
        //상위 클래스의 참조형 변수에는 하위 클래스 인스턴스 참조를
        //저장할 수 있기 때문에 catch를 여러개 작성 시 주의
        //상위 클래스 예외처리 구문을 먼저 만들고
        //아래에 하위 클래스 예외처리 구문을 만들면 컴파일 에러
        //-아래 예외처리 구문은 dead code
        catch(ArithmeticException e){
            // 예외 발생시 수행할 내용
            // 예외 발생하지 않으면 수행되지 않음
            System.out.println("0으로 나누면 안됌");
            
        }catch(NullPointerException e){
            System.out.println("Null이 속성이나 메서드 호출 시 예외");
        }
        finally{
            // 예외 발생 여부에 상관없이 수행
            System.out.println("예외 발생 여부에 상관없이 수행");
        }
    }
}
