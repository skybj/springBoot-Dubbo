package cn.jsxwsl.dubbo.service;


public interface RedisService {
	/**
     * 根据指定key获取String
     * @param key
     * @return
     */
    public String getStr(String key);
    

    /**
     * 普通设置Str缓存
     * @param key
     * @param val
     */
    public void setStr(String key, String val);
    /**
     * 设置Str缓存并加锁，这种方式如果 setIfAbsent挂了 即还没有来得及设置超时时间，这个锁会一直存在
     * @param key
     * @param val
     */
    public void setStrLock(String key, String val);
    /**
     * 这样设置锁的时候就能够保证设置 Redis 值和过期时间的原子性
     * @param key
     * @param val
     */
    public void setStrLockV2(String key, String val);
      
    

    /**
     * 删除指定key
     * @param key
     */
    public void del(String key);
    /**
     * 根据指定o获取Object
     * @param o
     * @return
     */
    public Object getObj(Object o);

    /**
     * 设置obj缓存
     * @param o1
     * @param o2
     */
    public void setObj(Object key, Object o2);
    	

    /**
     * 删除Obj缓存
     * @param o
     */
    public void delObj(Object o);


}
