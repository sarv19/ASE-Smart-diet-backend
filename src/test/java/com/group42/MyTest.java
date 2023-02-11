package com.group42;

import com.group42.utils.DateUtils;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * MyTest
 *
 * @author Guofeng Lin
 * @since 2023/2/10
 */
public class MyTest {

    private static final AtomicInteger SEQ = new AtomicInteger(0);
    public String nextUUID(Object entity) {
        String yyMMddHHmm = DateUtils.parseDateToStr(DateUtils.YYYYMMDDHHMM, new Date());
        if(SEQ.incrementAndGet() > 9999) {
            SEQ.set(0);
        }
        return yyMMddHHmm + "" + String.format("%04d", SEQ.get());
    }
    @Test
    public void test() {
        System.out.println("MyTest");
        System.out.println(nextUUID(null));
    }
}
