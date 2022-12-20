// 미지정 자료형의 이름은 한 글자로 하는 것이 관례
public class Generic <T>{
    private T [] data;

    //...은 데이터 개수에 상관없이 매개변수로 받아서
    //배열로 만들어주는 문법
    public Generic(T ... n){
        data = n;
    }

    //배열의 데이터 출력
    public void disp(){
        for(T temp : data){
            System.out.println(temp);
        }
        
        //Generics 가 적용된 클래스 인스턴스 생성 시
        //실제 자료형을 결정 지어야 경고 발생하지 않음
        //Generic obj1 = new Generic();
        Generic <String> obj1 = new Generic<>("해글러", "헌즈", "두란", "레너드");
        obj1.disp();
        // 기본형은 Generics에 적용할 수 없음
        //Generic<int> obj2 = new Generic<int>()
    }
}
