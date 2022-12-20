import java.io.IOException;

public class SystemC {
    public static void main(String[] args){
        String os = System.getProperty("os.name");
        String version = System.getProperty("java.version");
        System.out.println(os);
        System.out.println(version);

        long start = System.currentTimeMillis();
        for(int i =0; i<1000000000;i=i+1){}
        long end = System.currentTimeMillis();
        System.out.println((end-start)+"밀리 초");

        //Runtime 클래스 인스턴스
        Runtime r1 = Runtime.getRuntime();
        Runtime r2 = Runtime.getRuntime();
        System.out.println(System.identityHashCode(r1));
        System.out.println(System.identityHashCode(r2));
        
        //프로세스 실행
        //Mac 은 open 파일 경로 형태
        //Windows 는 프로세스 이름만 사용
        try {
            r1.exec("notepad");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int [] ar = new int[1000000];

        start = System.currentTimeMillis();
        // 인덱스 이용한 순회
//        for(int i=0;i<ar.length;i++){
//            System.out.println(ar[i]);
//        }
        //빠른 열거
        for(int temp:ar){
            System.out.println(temp);
        }
        end = System.currentTimeMillis();
        System.out.println((end-start)+"밀리 초");
    }


}
