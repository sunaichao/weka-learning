/*
 *
 *  *  Copyright (C) HAND Enterprise Solutions Company Ltd.
 *  *  All Rights Reserved
 *
 */

package com.seres.module.util;


import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Slf4j
public class ServletRequestHeaderUtils {

    private ServletRequestHeaderUtils(){}

    /**
     * 应用ID
     */
    private static final String APP_ID = "appId";

    /**
     * 用户ID
     */
    private static final String USER_ID = "userId";
    /**
     * ClientID
     */
    private static final String CLIENT_ID = "clientId";
    /**
     * 组织结构ID
     */
    private static final String ORGANIZE_ID = "organizeId";
    /**
     * 层级ID:例如 总部-1、分公司-2、区域-3、城市-4、门店-5
     */
    private static final String LEVEL_ID = "levelId";
    /**
     * 是否管理员角色
     */
    private static final String IS_ADMIN = "isAdmin";
    /**
     * 数据权限：1-个人 2-组织
     */
    private static final String DATA_AUTHORITY_HEADER = "dataAuthority";

    /**
     * 获取网关放置的appId请求头
     *
     * @return 请求头
     */
    public static Integer getApplicationId() {
        try {
            String appId = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getHeader(APP_ID);
            return Integer.valueOf(appId);
        } catch (Exception e) {
            log.warn("head of appId is null:{}",e);
            return null;
        }
    }

    /**
     * 获取网关放置的userId请求头
     *
     * @return 请求头
     */
    public static String getUserId() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getHeader(USER_ID);
        } catch (Exception e) {
            log.warn("head of userId is null:{}",e);
            return null;
        }

    }
    /**
     * 获取网关放置的clientId请求头
     *
     * @return 请求头
     */
    public static String getClientId() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getHeader(CLIENT_ID);
        } catch (Exception e) {
            log.warn("head of clientId is null:{}",e);
            return null;
        }
    }

    /**
     * 获取网关放置的组织结构请求头
     *
     * @return 请求头
     */
    public static String getOrganizeId() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getHeader(ORGANIZE_ID);
        } catch (Exception e) {
            log.warn("head of organizeId is null:{}",e);
            return null;
        }

    }

    /**
     * 获取网关放置的层级ID请求头
     *
     * @return 请求头
     */
    public static String getLevelId() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getHeader(LEVEL_ID);
        } catch (Exception e) {
            log.warn("head of levelId is null:{}",e);
            return null;
        }

    }

    /**
     * 获取网关放置的是否是管理员请求头
     *
     * @return 请求头
     */
    public static boolean isAdmin() {
        boolean result = false;
        try {
            String admin = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getHeader(IS_ADMIN);
            if(StrUtil.isNotBlank(admin)&&"true".equals(admin)){
                result = true;
            }
        } catch (Exception e) {
            log.warn("head of isAdmin is null:{}",e);
        }
        return result;
    }

    /**
     * 获取网关放置的数据权限请求头
     *
     * @return 请求头
     */
    public static String getDataAuthority() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getHeader(DATA_AUTHORITY_HEADER);
        } catch (Exception e) {
            log.warn("head of dataAuthority is null:{}",e);
            return null;
        }
    }
}
