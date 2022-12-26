public class RunnableLambda {
    public static void main(String[] args){
        // Runnable 인터페이스 이용한 스레드
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i<10; i++){
                    try{
                        Thread.sleep(1000);
                        System.out.println("일반적 방식");
                    }catch(Exception e){
                        System.out.println(e.getLocalizedMessage());
                    }
                }
            }
        }).start();

        new Thread(()->{
            for(int i =0; i<10; i++){
                try{
                    Thread.sleep(1000);
                    System.out.println("일반적 방식");
                }catch(Exception e){
                    System.out.println(e.getLocalizedMessage());
                }
            }
        }).start();
    }
}
