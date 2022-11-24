package me.szkristof.szakibuszapi.utilities;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/***
 * This class is used to convert a string or a byte array to a SHA256 hash.
 */
public class SHA256Converter {

    /***
     * Converts a byte array to a SHA256 hash.
     * @param hash The byte array to be converted.
     * @return The SHA256 hash of the byte array.
     */
    public static String convert(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /***
     * Converts a string to a SHA256 hash.
     * @param string The string to be converted.
     * @return The SHA256 hash of the string.
     */
    public static String convert(String string) {
        Charset charset = StandardCharsets.UTF_8;
        return convert(string.getBytes(charset));
    }
}
