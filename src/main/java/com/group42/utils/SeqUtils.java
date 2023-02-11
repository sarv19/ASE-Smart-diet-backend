package com.group42.utils;


import com.group42.excpetion.UtilException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SeqUtils {
    public static final String commSeqType = "COMMON";

    private static final AtomicInteger commSeq = new AtomicInteger(1);

    private final static Integer machineCode = 1;

    private static final int default_length = 2;

    public static String getId() {
        return getId(commSeq, default_length);
    }

    /**
     * Common interface serial number: yyMMddHHmmss + machineCode + commSeq
     *
     */
    public static String getId(AtomicInteger atomicInt, int length) {
        return calcSeq(DateUtils.dateTimeNow(), getSeq(atomicInt, length));
    }

    /**
     * Obtain a large number of IDs at once
     *
     * @param number the number of ID you want to get
     */
    public static List<String> getBatchId(int number) {
        return getBatchId(number, default_length);
    }

    /**
     * Obtain a large number of IDs at once
     *
     */
    public static List<String> getBatchId(int number, int maxLength) {
        String dateTimeNow = DateUtils.dateTimeNow();
        List<String> batchId = getBatchId(commSeq, number, maxLength);
        List<String> result = new ArrayList<>(batchId.size() * 2);
        for (String id : batchId) {
            result.add(calcSeq(dateTimeNow, id));
        }
        return result;
    }

    private synchronized static String getSeq(AtomicInteger atomicInt, int length) {
        List<String> batchId = getBatchId(atomicInt, 1, length);
        return batchId.get(0);
    }

    private synchronized static List<String> getBatchId(AtomicInteger atomicInt, int number, int maxLength) {
        if (number < 0) throw new UtilException("The number of serial numbers obtained in batches cannot be less than 0");
        else if (0 == number) return Collections.emptyList();
        double maxSeq = Math.pow(10, maxLength);
        // to ensure (value + number) % maxSeq == 1 is true
        if (number > maxSeq) throw new UtilException("The number of batches obtained cannot be greater than the maximum length");
        int value = atomicInt.getAndAdd(number);
        if (atomicInt.get() >= maxSeq) {
            atomicInt.set((int) ((value + number) % maxSeq));
        }
        List<String> result = new ArrayList<>(2 * number);
        for (int i = 0; i < number; i++) {
            result.add(StringUtils.padl(value++, maxLength));
        }
        return result;
    }

    private static String calcSeq(String dateTimeNow, String seq) {
        String result = dateTimeNow;
        result += machineCode;
        result += seq;
        return result;
    }
}
