package com.group42.utils;


import com.group42.constant.Constants;

import java.util.concurrent.atomic.AtomicInteger;

public class SeqUtils {
    private static final AtomicInteger commSeq = new AtomicInteger(1);

    private static final int default_length = 2;

    public static Long getId() {
        return getId(commSeq, default_length);
    }

    /**
     * Common interface serial number: yyMMddHHmmss + machineCode + commSeq
     */
    public static Long getId(AtomicInteger atomicInt, int length) {
        return calcSeq(DateUtils.dateTimeNow(Constants.idTimePrefixFormat), getSeq(atomicInt, length));
    }

    private synchronized static String getSeq(AtomicInteger atomicInt, int length) {
        double maxSeq = Math.pow(10, length);
        // to ensure (value + number) % maxSeq == 1 is true
        int value;
        if (atomicInt.incrementAndGet() >= maxSeq) {
            atomicInt.set((int) ((atomicInt.get() + 1) % maxSeq));
        }
        value = atomicInt.get();
        return StringUtils.padl(value, length);
    }


    private static Long calcSeq(String dateTimeNow, String seq) {
        return Long.valueOf(dateTimeNow + seq);
    }
}
