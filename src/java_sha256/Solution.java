package java_sha256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] endodedHash = digest.digest(text.getBytes());
        System.out.println(byteHex(endodedHash));
    }

    private static String byteHex(byte[] encodedHash) {
        StringBuilder hexText = new StringBuilder(2 * encodedHash.length);
        for (int i = 0;i < encodedHash.length; i++) {
            String hex = Integer.toHexString(0xff & encodedHash[i]);
            if (hex.length() == 1) {
                hexText.append('0');
            }
            hexText.append(hex);
        }
        return hexText.toString();
    }
}