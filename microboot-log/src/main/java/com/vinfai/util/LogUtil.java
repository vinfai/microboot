package com.vinfai.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志按不同文件输出<br/>
 * https://blog.csdn.net/mggwct/article/details/77718122
 * @author fangwenhui
 * @date 2018-03-28 13:38
 **/
public class LogUtil {

    public static Logger getLogger(LogFileName desc) {
        return LoggerFactory.getLogger(desc.getDesc());
    }


    public static <T> Logger getLogger(Class<T> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

}

