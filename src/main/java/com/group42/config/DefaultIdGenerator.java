package com.group42.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.group42.utils.DateUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class DefaultIdGenerator implements IdentifierGenerator {

    private static final AtomicInteger SEQ = new AtomicInteger(0);


    @Override
    public Number nextId(Object entity) {
        return Long.parseLong(nextUUID(entity));
    }

    @Override
    public String nextUUID(Object entity) {
        String yyMMddHHmm = DateUtils.parseDateToStr(DateUtils.YYYYMMDDHHMMSS, new Date());
        if(SEQ.incrementAndGet() > 99) {
            SEQ.set(0);
        }
        return yyMMddHHmm + "" + String.format("%02d", SEQ.get());
    }
}