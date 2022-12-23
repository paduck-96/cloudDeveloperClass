import java.io.File;
import java.util.Date;

public class FileInformationMain {
    public static void main(String[] args) {
        // 파일 객체 생성
        File f = new File("C:\\Users\\user\\codetest\\classTwo\\1018.js");
        if(f.exists()==true){
            System.out.println("파일 크기" + f.length());
            System.out.println("마지막 수정 날짜" + f.lastModified());
            Date date = new Date(f.lastModified());
            System.out.println(date);
        }else{
            System.out.println("파일 없음");
        }
    }
}
