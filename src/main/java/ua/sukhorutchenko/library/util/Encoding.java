package ua.sukhorutchenko.library.util;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoding {

    public static String encodingPassword(String password) {
        if (password == null) {
            return null;
        }
        String encryptedPassword = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(password.getBytes(), 0, password.length());
            encryptedPassword = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return "{MD5}" + encryptedPassword;
    }
}