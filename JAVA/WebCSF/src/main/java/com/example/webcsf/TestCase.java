package com.example.webcsf;

import org.junit.Test;

public class TestCase {
    @Test
    public void daoTest(){
        MemberDAO dao = MemberDAO.getInstance();
        System.out.println(dao.login("user","1111"));
        System.out.println(dao.login("user","1234"));
        System.out.println(dao.login("user2","1211"));
    }

}
