package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MariaDB {
    public static void main(String[] args){
        // DB 접속 정보
        String driver = null;
        String url = null;
        String id = null;
        String password = null;

        // 읽어올 파일 생성
        File file = new File("./db.properties");
        try(FileInputStream fis = new FileInputStream(file)){
            //파일의 내용 properties에 저장
            Properties properties = new Properties();
            properties.load(fis);
            //읽어온 내용 변수에 저장
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            id = properties.getProperty("id");
            password = properties.getProperty("password");
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        // 1. DB 드라이버 로드
        try{
            Class.forName(driver);
            System.out.println("드라이버 로드 성공");
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }

        // 2. DB 접속
        //java.sql.Connection
        //예외 기록은 유용
        try(Connection con =
                    DriverManager.getConnection(url, id, password)){
System.out.println(con);
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
