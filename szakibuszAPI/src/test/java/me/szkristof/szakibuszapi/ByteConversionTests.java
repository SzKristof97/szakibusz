package me.szkristof.szakibuszapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
public class ByteConversionTests {
    @Test
    public void whenGetBytesWithStandardCharset_thenOK() {
        String inputString = "Hello World!";
        Charset charset = StandardCharsets.UTF_8;

        byte[] byteArray = inputString.getBytes(charset);

        assertArrayEquals(
                new byte[] { 72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33},
                byteArray);
    }
}
