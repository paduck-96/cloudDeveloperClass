package main.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoLibraryCSVMain {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./text.csv")))){
            //기본 실행 경로는 프로젝트 최상위
            boolean flag = false;

            // 파싱 결과 저장하기 위한 List
            List<Player> list = new ArrayList<>();

            while(true){
                String line = br.readLine();
                if(line==null)break;
                // 첫 줄 읽지 않기 위해 조건 삽입
                if(flag==false){
                    flag=true;
                    continue;
                }
                //System.out.println(line);
                //, 단위로 분할
                String [] ar = line.split(",");
                //System.out.println(ar[0]);

                Player player = new Player();
                player.setName(ar[0]);
                player.setAge(Integer.parseInt(ar[1]));
                String birth = ar[2];
                // 문자열 Date 타입 변환해서 대입
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(birth);
                player.setBirth(date);
                player.setEmail(ar[3]);
                player.setNickname(ar[4]);

                // 리스트에 추가
                list.add(player);
            }
            for(Player player : list){
                System.out.println(player);
            }
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
