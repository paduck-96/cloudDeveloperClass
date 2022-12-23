import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesMain {
    public static void main(String [] args){
        //현재 디렉토리 위치 찾기
        File f = new File("./");
        System.out.println(f.getAbsolutePath());

        
        // 설정 파일이 경로로 지정
        File file = new File("config.properties");
        try(FileInputStream fis = new FileInputStream(file)){
            Properties properties = new Properties();
            properties.load(fis);
            //읽어오기
            System.out.println(properties.getProperty("url"));
            
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
