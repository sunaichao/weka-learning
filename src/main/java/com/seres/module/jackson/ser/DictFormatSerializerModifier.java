//package com.seres.module.jackson.ser;
//
//import com.fasterxml.jackson.databind.BeanDescription;
//import com.fasterxml.jackson.databind.SerializationConfig;
//import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
//import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
//import com.fasterxml.jackson.databind.ser.std.NullSerializer;
//import com.seres.module.jackson.anotation.DictFormat;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.util.List;
//
//
//@Slf4j
//public class DictFormatSerializerModifier extends BeanSerializerModifier {
//
//    /**
//     * 缓存
//     */
//    private  RedisTemplate<String, Object> redisTemplate;
//
//    public DictFormatSerializerModifier(RedisTemplate<String, Object> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//    @Override
//    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDescription, List<BeanPropertyWriter> beanProperties) {
//        for (BeanPropertyWriter beanProperty : beanProperties) {
//            DictFormat dictFormat = beanProperty.getAnnotation(DictFormat.class);
//            if (dictFormat != null){
//                // 当前字段fieldName
//                String filedName = beanProperty.getFullName().getSimpleName();
//                DictFieldSerializer dictFieldSerializer = new DictFieldSerializer(filedName,redisTemplate,dictFormat);
//                //自定以序列器
//                beanProperty.assignSerializer(dictFieldSerializer);
//                //null值序列器
//                beanProperty.assignNullSerializer(NullSerializer.instance);
//            }
//        }
//        return beanProperties;
//    }
// }
