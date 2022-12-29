import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownload {
    public static void main(String[] args){
        new Thread(){
            @Override
            public void run(){
                try{
                    // 다운받을 URL 생성
                    String addr = "https://tour.shinan.go.kr/images/tour/contents/sub02_0803_01.jpg";
                    // 확장자 추출
                    //.은 \와 함께 기재
                    String [] ar = addr.split("\\.");
                    String ext = ar[ar.length-1];
                    System.out.println(ext);

                            URL url = new URL(addr);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    con.setConnectTimeout(30000);
                    con.setUseCaches(false);

                    // 읽어올 바이트 스트림 생성
                    InputStream in = con.getInputStream();
                    File f = new File("manjaedo."+ext);
                    if(f.exists()==true){
                        System.out.println("이미 존재하는 파일");
                        return;
                    }
                    // 읽은 내용 저장할 파일 스트림 생성
                    FileOutputStream fos = new FileOutputStream("manjaedo."+ext);
                    //데이터 저장
                    while(true){
                        //바이트 배열 생성
                        byte[] raster = new byte[512];
                        // 바이트 배열에 저장
                        int len = in.read(raster);
                        if(len<=0)break;
                        fos.write(raster, 0, len);
                    }
                    in.close();
                    fos.close();
                    con.disconnect();
                }catch(Exception e){
                    System.out.println(e.getLocalizedMessage());
                }
            }

        }.start();
    }
}
