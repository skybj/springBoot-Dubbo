package cn.jsxwsl.dubbo.service.impl;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import cn.jsxwsl.dubbo.service.RedisService;
import redis.clients.jedis.JedisCommands;
/**
 * 实际开发中建议使用RedisTemplate<K,V>
 * @author Administrator
 *
 */
@Service
public class RedisServiceImpl implements RedisService {
	
	//StringRedisTemplate继承自RedisTemplate，只能操作键值都是String类型的数据
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	//StringRedisTemplate则使用StringRedisSerializer序列化
	@Resource(name = "stringRedisTemplate")
	ValueOperations<String, String> valOpsStr;
	//RedisTemplate默认使用JdkSerializationRedisSerializer序列化
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;
	
    //ValueOperations 操作字符串
	@Resource(name = "redisTemplate")
	ValueOperations<Object, Object> valOpsObj;
	
	/**
     * 根据指定key获取String
     * @param key
     * @return
     */
    public String getStr(String key){
    	
    
        return valOpsStr.get(key);
    }

    /**
     * 普通设置Str缓存
     * @param key
     * @param val
     */
    public void setStr(String key, String val){
        valOpsStr.set(key,val);
    }
    /**
     * 设置Str缓存并加锁，这种方式如果 setIfAbsent挂了 即还没有来得及设置超时时间，这个锁会一直存在
     * @param key
     * @param val
     */
    public void setStrLock(String key, String val){
    	//注意是当key不存在时才能加锁成功，所以使用 setIfAbsent 方法
    	valOpsObj.setIfAbsent(key, val);
    	//设置超时时间
    	redisTemplate.expire(key, 30000, TimeUnit.MILLISECONDS);
    	//这是2步操作非原子操作
      
    }
    /**
     * 这样设置锁的时候就能够保证设置 Redis 值和过期时间的原子性
     * @param key
     * @param val
     */
    public void setStrLockV2(String key, String val){
    	String key1=key;
    	String result = redisTemplate.execute(new RedisCallback<String>() {
    	    @Override
    	    public String doInRedis(RedisConnection connection) throws DataAccessException {
    	        JedisCommands commands = (JedisCommands) connection.getNativeConnection();
    	        return commands.set("key", "锁定的资源", "NX", "PX", 30000);
    	    }
    	});

      
    }

    /**
     * 删除指定key
     * @param key
     */
    public void del(String key){
        stringRedisTemplate.delete(key);
    }

    /**
     * 根据指定o获取Object
     * @param o
     * @return
     */
    public Object getObj(Object o){
        return valOpsObj.get(o);
    }

    /**
     * 设置obj缓存
     * @param o1
     * @param o2
     */
    public void setObj(Object key, Object o2){
    	//如果需要使用锁就使用setIfAbsent，这样的话并发情况下 只有一个能设置成功 相当于加锁操作
    	//valOpsObj.setIfAbsent(key, value)
        valOpsObj.set(key, o2);
        //给key加上超时时间
       // redisTemplate.expire(key, 30000, TimeUnit.MILLISECONDS);
    }

    /**
     * 删除Obj缓存
     * @param o
     */
    public void delObj(Object o){
        redisTemplate.delete(o);
    }

}
