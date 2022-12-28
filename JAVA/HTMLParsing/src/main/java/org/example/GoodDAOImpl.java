package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodDAOImpl implements GoodDAO{
    //싱글톤 만들기 위한 코드
    // 외부에서 인스턴스 생성 못하게 생성자 private
    private GoodDAOImpl(){}
    // 참조를 저장할 변수 static으로 설정
    private static GoodDAO goodDAO;
    //변수 여부에 따라 리턴 값 결정
    public static GoodDAO getInstance(){
        if(goodDAO == null){
            goodDAO = new GoodDAOImpl();
        }
        return goodDAO;
    }
    private Connection connection; //DB 연결
    private PreparedStatement pstmt; // sql 실행
    private ResultSet rs; // select 구문

    // static 초기화
    //클래스 로드 될 때 1번 수행
    //static 속성만 사용 가능
    static{
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            //System.out.println("드라이버 로드 성공");
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
    // 초기화
    //생성자를 호출할 때마다 먼저 호출
    //init 메서드로 생성
    //모든 속성 사용 가능
    {
        try{
            connection =
                    DriverManager.getConnection("jdbc:mariadb://localhost:3306/java","root","rootPassword");
            System.out.println(connection);
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Good> getAll() {
        // list는 조회할 데이터가 없더라도 인스턴스 생성
        //조회할 데이터가 없다는 사실은 size() 가 0
        List<Good> list = new ArrayList<Good>();
        try{
            //SQL 실행 클래스의 인스턴스 생성
            pstmt = connection.prepareStatement("select * from goods");
            //SQL 실행
            rs = pstmt.executeQuery();
            // 데이터를 하나의 행씩 읽어서 DTO 객체로 변환
            while(rs.next()){
                Good good = new Good();
                good.setCode(rs.getString("code"));
                good.setName(rs.getString("name"));
                good.setManufacture(rs.getString("manufacture"));
                good.setPrice(rs.getInt("price"));

                list.add(good);
            }
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Good getGood(String code) {
        // 조회가 안 된 경우는 null
        Good good = null;
        try{
            pstmt = connection.prepareStatement(
                    "select * from goods where code = ?"
            );
            // ?에 데이터 바인딩
            //?에 바인딩할 때 인덱스는 1부터 시작
            pstmt.setString(1, code);
            rs=pstmt.executeQuery();
            if(rs.next()){
                good = new Good();
                good.setCode(rs.getString("code"));
                good.setName(rs.getString("name"));
                good.setManufacture(rs.getString("manufacture"));
                good.setPrice(rs.getInt("price"));
            }
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return good;
    }

    @Override
    public List<Good> likeGood(String content) {
        List<Good> list = new ArrayList<Good>();

        try{
            pstmt = connection.prepareStatement(
                    "select * from goods where name like ? or manufacture like ?"
            );
            pstmt.setString(1, "%"+content+"%");
            pstmt.setString(2, "%"+content+"%");

            rs=pstmt.executeQuery();

            while(rs.next()){
                Good good = new Good();
                good.setCode(rs.getString("code"));
                good.setName(rs.getString("name"));
                good.setManufacture(rs.getString("manufacture"));
                good.setPrice(rs.getInt("price"));

                list.add(good);
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return list;
    }

    @Override
    public int insertGood(Good good) {
        int result = 0;
        //삽입 작업이므로 트랜잭션 고려
        try{
            connection.setAutoCommit(false);
            pstmt = connection.prepareStatement(
                    "insert into goods values(?,?,?,?)"
            );
            pstmt.setString(1, good.getCode());
            pstmt.setString(2, good.getName());
            pstmt.setString(3, good.getManufacture());
            pstmt.setInt(4, good.getPrice());

            result = pstmt.executeUpdate();
            connection.commit();
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        }
        return result;
    }
}
