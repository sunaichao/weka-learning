package com.seres.module.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class UserDetailDTO implements Serializable {

    private static final long serialVersionUID = -3310053795890597991L;

    /**
     * 应用ID
     */
    private Integer applicationId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 组织ID(逗号分割)
     */
    private String organizeId;

    /**
     * 是否为管理员
     */
    private Boolean boolAdmin;

    /**
     * clientId
     */
    private String clientId;

    /**
     * 角色编码集合
     */
    private List<String> roleCodes;

    /**
     * 权限编码集合
     */
    private List<String> authorities;













}
