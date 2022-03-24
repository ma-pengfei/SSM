package com.itheima.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 两个泛型：第一个表示转换前的数据类型，第二个表示转换后的数据类型
 */
public class DateConverter implements Converter<String, Date> {
    /**
     * 转换方法
     */
    @Override
    public Date convert(String dateStr){

        //将日期字符串dateStr转换为日期对象date
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
