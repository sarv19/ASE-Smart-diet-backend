//package com.group42.utils;
//
//import com.mtrsz.common.excpetion.UtilException;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @auther zhouzhifeng
// * @date 2022/6/27
// */
//public class SeqUtils {// 通用序列类型
//    public static final String commSeqType = "COMMON";
//
//    // 上传序列类型
//    public static final String uploadSeqType = "UPLOAD";
//
//    // 通用接口序列数
//    private static AtomicInteger commSeq = new AtomicInteger(1);
//
//    // 上传接口序列数
//    private static AtomicInteger uploadSeq = new AtomicInteger(1);
//
//    // 机器标识
//    private static String machineCode = "A";
//
//    private static final int default_length = 3; // 如果批量申请序列号时，尽可能不要使用默认长度，要不然可能和ID抢序列
//
//    /**
//     * 获取通用序列号
//     *
//     * @return 序列值
//     */
//    public static String getId() {
//        return getId(commSeqType);
//    }
//
//    /**
//     * 默认16位序列号 yyMMddHHmmss + 一位机器标识 + 3长度循环递增字符串
//     *
//     * @return 序列值
//     */
//    public static String getId(String type) {
//        AtomicInteger atomicInt = commSeq;
//        if (uploadSeqType.equals(type)) {
//            atomicInt = uploadSeq;
//        }
//        return getId(atomicInt, default_length);
//    }
//
//    /**
//     * 通用接口序列号 yyMMddHHmmss + 一位机器标识 + length长度循环递增字符串
//     *
//     * @param atomicInt 序列数
//     * @param length    数值长度
//     * @return 序列值
//     */
//    public static String getId(AtomicInteger atomicInt, int length) {
//        return calcSeq(DateUtils.dateTimeNow(), getSeq(atomicInt, length));
//    }
//
//    /**
//     * 一次性获得大量的ID
//     * 尽可能不要使用默认长度，要不然可能和ID抢序列，所以此方法为 @Deprecated
//     *
//     * @param number 要获得的个数
//     */
//    @Deprecated
//    public static List<String> getBatchId(int number) {
//        return getBatchId(number, default_length);
//    }
//
//    /**
//     * 一次性获得大量的ID，maxLength尽可能不要等于3（default_length）
//     *
//     * @param number    要获得的个数
//     * @param maxLength 生成的ID的序列位的最大长度
//     */
//    public static List<String> getBatchId(int number, int maxLength) {
//        String dateTimeNow = DateUtils.dateTimeNow();
//        List<String> batchId = getBatchId(commSeq, number, maxLength);
//        List<String> result = new ArrayList<>(batchId.size() * 2);
//        for (String id : batchId) {
//            result.add(calcSeq(dateTimeNow, id));
//        }
//        return result;
//    }
//
//    /**
//     * 序列循环递增字符串[1, 10 的 (length)幂次方), 用0左补齐length位数
//     *
//     * @return 序列值
//     */
//    private synchronized static String getSeq(AtomicInteger atomicInt, int length) {
////        // 先取值再+1
////        int value = atomicInt.getAndIncrement();
////
////        // 如果更新后值>=10 的 (length)幂次方则重置为1
////        int maxSeq = (int) Math.pow(10, length);
////        if (atomicInt.get() >= maxSeq) {
////            atomicInt.set(1);
////        }
////        // 转字符串，用0左补齐
////        return StringUtils.padl(value, length);
//        List<String> batchId = getBatchId(atomicInt, 1, length);
//        return batchId.get(0);
//    }
//
//    /**
//     * 一次性获得大量的ID
//     *
//     * @param atomicInt 使用的原子序列
//     * @param number    要获得的个数
//     * @param maxLength 生成的ID的序列位的最大长度
//     */
//    private synchronized static List<String> getBatchId(AtomicInteger atomicInt, int number, int maxLength) {
//        if (number < 0) throw new UtilException("批量获取序列号的个数不能小于0");
//        else if (0 == number) return Collections.emptyList();
//        double maxSeq = Math.pow(10, maxLength);
//        // 确保 (value + number) % maxSeq == 1 为true
//        if (number > maxSeq) throw new UtilException("批量获取的个数不能大于最大长度");
//        int value = atomicInt.getAndAdd(number);
//        if (atomicInt.get() >= maxSeq) {
//            atomicInt.set((int) ((value + number) % maxSeq));
//        }
//        List<String> result = new ArrayList<>(2 * number);
//        for (int i = 0; i < number; i++) {
//            result.add(StringUtils.padl(value++, maxLength));
//        }
//        return result;
//    }
//
//    private static String calcSeq(String dateTimeNow, String seq) {
//        String result = dateTimeNow;
//        result += machineCode;
//        result += seq;
//        return result;
//    }
//}
