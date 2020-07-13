package SSM.UTILS;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtil {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String passwordEncode(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String p = "123";
        System.out.println(bCryptPasswordEncoder.encode(p));
    }
}
