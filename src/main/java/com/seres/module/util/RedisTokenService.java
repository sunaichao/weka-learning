//package com.seres.module.util;
//
//import com.alibaba.fastjson.JSON;
//import com.seres.module.entity.dto.UserDetailDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class RedisTokenService {
//
//    @Autowired
//    private RedisTemplate<String,Object> redisTemplate;
//
//    public static final String USER_INFO_REDIS_KEY_HEAD = "seres:userInfo:";
//
//    /**
//     * 获取当前用户信息
//     * @param token
//     * @return
//     */
//    public UserDetailDTO getCurrentUser(String token){
//        String userInfo = (String) redisTemplate.opsForValue().get(USER_INFO_REDIS_KEY_HEAD+token);
//        return JSON.parseObject(userInfo,UserDetailDTO.class);
//    }
//}
