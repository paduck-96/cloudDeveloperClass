import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableMain {
    public static void main(String [] args){
        /*
        //인스턴스 단위로 기록할 수 있는 ㅅ트림
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sample.dat", true))){
            //기록할 인스턴스 생성
            Data data = new Data(1, "adam", "군계");
            oos.writeObject(data);
            oos.flush();
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        */
//읽기
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sample.dat"))){
            //기록할 인스턴스 생성
            Data data = (Data) ois.readObject();
            System.out.println(data);
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
