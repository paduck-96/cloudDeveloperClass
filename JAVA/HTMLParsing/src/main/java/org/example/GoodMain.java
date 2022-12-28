package org.example;

public class GoodMain {
    public static void main(String[] args){
        GoodDAO dao = GoodDAOImpl.getInstance();

        System.out.println(dao.getAll());
        // 기본키를 가지고 조회하면 존재하는 경우 데이터 리턴
        //없는 경우 nmull 리턴
        System.out.println(dao.getGood("1"));

        Good good = new Good();
        good.setCode("10");
        good.setName("과자");
        good.setManufacture("서울");
        good.setPrice(1800);

        int r = dao.insertGood(good);
        if(r==1){
            System.out.println("삽입 성공");
        }else{
            System.out.println("삽입 실패");
        }
        
        System.out.println(dao.likeGood("사"));
    }
}
