package org.example;

import org.mindrot.jbcrypt.BCrypt;

public class CryptMain {
    public static void main(String[] args){
        // 복호화가 불가능한 암호화
        String encryptString = BCrypt.hashpw("123456789012345", BCrypt.gensalt());
        System.out.println(encryptString);

        // 비교
        //평문이 먼저오고 암호화된 문장
        System.out.println(BCrypt.checkpw("12345678901234", encryptString));
    }
}
