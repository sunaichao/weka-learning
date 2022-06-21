//package com.seres.module.jackson.ser;
//
//import cn.hutool.core.util.StrUtil;
//import com.alibaba.fastjson.JSON;
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import com.seres.module.jackson.anotation.DictFormat;
//import com.seres.module.jackson.config.DictConfig;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.io.IOException;
//
//
//@Slf4j
//public class DictFieldSerializer extends JsonSerializer<Object> {
//
//    public static final String DICT_MAP = "COMMON:DICT:CODE_MAP";
//
//    /**
//     * 字典字段名称
//     */
//    private String filedName;
//
//    /**
//     * 字段字段属性值
//     */
//    private DictFormat dictFormat;
//
//    /**
//     * 缓存
//     */
//    private RedisTemplate<String, Object> redisTemplate;
//
//    public DictFieldSerializer(String filedName, RedisTemplate<String, Object> redisTemplate, DictFormat dictFormat) {
//        this.filedName = filedName;
//        this.redisTemplate = redisTemplate;
//        this.dictFormat = dictFormat;
//    }
//
//    /**
//     * 自定义写入方法
//     * @param value
//     * @param gen
//     * @param serializers
//     * @throws IOException
//     */
//    @Override
//    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
//        gen.writeObject(value);
//        String defaultKey = null;
//        if(StrUtil.isNotBlank(this.dictFormat.dictKey())){
//            defaultKey = this.dictFormat.dictKey();
//        }else{
//            defaultKey = this.filedName;
//        }
//        String dictJson = (String) redisTemplate.opsForHash().get(DICT_MAP,defaultKey+"_"+value);
//        DictConfig dict = JSON.parseObject(dictJson,DictConfig.class);
//        log.info("dict value:{}",dict);
//        if(StrUtil.isNotBlank(this.dictFormat.targetFiled())){
//            gen.writeFieldName(this.dictFormat.targetFiled());
//        }else{
//            gen.writeFieldName(this.filedName+"Name");
//        }
//        // 字典翻译值
//        if(dict != null && StrUtil.isNotBlank(dict.getEntryMeaning())){
//            gen.writeObject(dict.getEntryMeaning());
//        }else {
//            gen.writeObject(this.dictFormat.defaultNullValue());
//        }
//        if(this.dictFormat.requiredExtend() && dict != null){
//            // 扩展字段1
//            gen.writeFieldName(this.dictFormat.extendFiled1());
//            gen.writeObject(dict.getExtendField1());
//            // 扩展字段2
//            gen.writeFieldName(this.dictFormat.extendFiled2());
//            gen.writeObject(dict.getExtendField2());
//            // 扩展字段3
//            gen.writeFieldName(this.dictFormat.extendFiled3());
//            gen.writeObject(dict.getExtendField3());
//        }
//    }
//}
