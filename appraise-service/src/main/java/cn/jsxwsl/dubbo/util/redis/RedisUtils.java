package cn.jsxwsl.dubbo.util.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class RedisUtils {
/**	 RedisTemplate中定义了对5种数据结构操作
redisTemplate.opsForValue();//操作字符串
redisTemplate.opsForHash();//操作hash
redisTemplate.opsForList();//操作list
redisTemplate.opsForSet();//操作set
redisTemplate.opsForZSet();//操作有序set
 */
 @Autowired
 private RedisTemplate<Object, Object> template;
 
  public void set (){
	  template.opsForValue().set(null, null);
	 
 }
  public void setHash (){
	  template.opsForHash().scan(null, null);
	 
 }
 
 

}
