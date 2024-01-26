package edu.dev.backend.utils;

/**
 * Create By  @林俊杰
 * 2022/3/19 20:50
 *
 * @version 1.0
 */
public class LocationAdapterUtils {

    final static String[] locationArrays={"公告公示","政策文件"};

    public static String policyType2Location(Integer type){
        return locationArrays[type-1];
    }
}
