package com.group42.controller;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.group42.model.to.BaseTO;
import com.group42.utils.DateUtils;
import com.group42.utils.PageUtils;
import com.group42.utils.PojoUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;

/**
 * BaseController: page helper
 *
 * @author Guofeng Lin
 * @since 2023/2/10
 */
public abstract class BaseController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                try {
                    setValue(DateUtils.parseDate(text));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @SafeVarargs
    public final <T> T initParam(Object to, Class<T> clazz, @Nullable SFunction<T, ?>... ignoreProperties) {
        try {
            T newInstance = clazz.getDeclaredConstructor().newInstance();
            PojoUtils.copyPropertiesLambda(to, newInstance, ignoreProperties);
            return newInstance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    protected void startPage(BaseTO baseTO) {
        PageUtils.startPage(baseTO);
    }
}
