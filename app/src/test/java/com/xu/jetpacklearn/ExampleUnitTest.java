package com.xu.jetpacklearn;

import android.util.Log;

import com.github.simonpercic.oklog.shared.data.LogData;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }




    @Test
    // 判断是否是图片 jpg png jpeg
    public void isPic() {
        String path = "sys/2c91808278814894017881b03cc20003.jpg";
        List<String> picFiles = Arrays.asList("jpg", "png", "jpeg", "bmp", "webp", "gif");

        int index = path.lastIndexOf('.');


        String end = path.substring(index+1).toLowerCase();
        System.out.println("end:"+end);
        if (picFiles.contains(end)) {
            System.out.println("baohan");
            return;
        }
        System.out.printf("buboahan");
    }
}