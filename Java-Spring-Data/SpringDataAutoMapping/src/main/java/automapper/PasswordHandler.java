package automapper;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class PasswordHandler {
    private final static int ITERATION_COUNT = 1024;
    private final static int KEY_LENGTH = 128;
    private static SecretKeyFactory skf = null;

    static {
        try {
            skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String encodePassword(String plainPassword) throws InvalidKeySpecException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);

        KeySpec keySpec = new PBEKeySpec(plainPassword.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH);

        return String.format("%s:%s", toHex(salt), toHex(skf.generateSecret(keySpec).getEncoded()));
    }


    public static boolean doPasswordsMatch(String plainPassword, String storedPassword) throws InvalidKeySpecException {
        String[] parts = storedPassword.split(":");

        byte[] salt = fromHex(parts[0]);
        byte[] hash = fromHex(parts[1]);

        PBEKeySpec spec = new PBEKeySpec(plainPassword.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH);
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        return Arrays.equals(hash, testHash);
    }

    private static String toHex(byte[] array) {
        StringBuilder sb = new StringBuilder();

        for (byte b : array) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private static byte[] fromHex(String hex) {
        byte[] bytes = new byte[hex.length() / 2];

        for (int i = 0; i < bytes.length; i++) {
            int index = i * 2;
            int val = Integer.parseInt(hex.substring(index, index + 2), 16);
            bytes[i] = (byte) val;
        }

        return bytes;
    }
}
