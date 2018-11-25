package cn.shuangbofu.demo.util;

import cn.shuangbofu.demo.constant.DefaultInfo;

public class FilePathUtil {

    public static String getFilePath(String fileName) {
        StringBuilder stringBuilder = new StringBuilder(DefaultInfo.DIR_PATH);
        stringBuilder.append(DefaultInfo.FILE_PREFIX);
        stringBuilder.append(fileName);
        stringBuilder.append(DefaultInfo.FILE_SUFFIX);
        return stringBuilder.toString();
    }
}
