package com.wskc.redis.util;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisUtil
{

	@Autowired
	private RedisTemplate stringRedisTemplate;
	
	@Resource(name = "stringRedisTemplate")
	private ListOperations<String, Object> listOps;

	@Resource(name = "stringRedisTemplate")
	private ValueOperations<String, Object> valueOps;

	@Resource(name = "stringRedisTemplate")
	private HashOperations<String, String, Object> hashOps;

	@Resource(name = "stringRedisTemplate")
	private SetOperations<String, Object> setOps;
	
	@Resource(name = "stringRedisTemplate")
	private ZSetOperations<String, Object> ZSetOps;
	
    @Autowired 
    @Qualifier("redisTemplate")
    public RedisTemplate<String, Object> redisTemplate;
    
    @Autowired
    @Qualifier("redisTemplate")
    protected RedisTemplate<Serializable, Serializable> redisTemplateSerializable;
    
    

    /**
     * 缓存基本的对象，Integer、String、实体类等
     * @param key    缓存的键值
     * @param value    缓存的值
     * @return        缓存的对象
     */
    public void setCacheObject(String key, Object value)
    {
        redisTemplate.opsForValue().set(key,value);
    }
    /**
     * 获得缓存的基本对象。
     * @param key        缓存键值
     * @param operation
     * @return            缓存键值对应的数据
     */
    public Object getCacheObject(String key/*,ValueOperations<String,T> operation*/)
    {
        return redisTemplate.opsForValue().get(key); 
    }
    
    /**
     * 缓存基本的对象，Integer、String、实体类等
     * @param key  缓存的键值
     * @param value 缓存的值
     */
    public void setVoObject(String key,Object value){
    	valueOps.set(key, value);
    }
    /**
     * 得到基本对象，Integer,String,实体类
     * @param key
     * @return
     */
    public Object getVoObject(String key){
    	return valueOps.get(key);
    }
    
    /**
     * 设置右边进入
     * @param key
     * @param value
     * @return
     */
    public Long setLoRightPush(String key,Object value){
    	return listOps.rightPush(key, value);
    }
    /**
     * 设置左边进入
     * @param key
     * @param value
     * @return
     */
    public Long setLoLeftPush(String key,Object value){
    	return listOps.leftPush(key, value);
    }
    /**
     * 获得类型某个范围的值
     * 
     * @param key
     * @param start       从0开始
     * @param end       -1表示全部
     */
    public List<Object> getLoRange(String key,int start ,int end){
    	return listOps.range(key, start, end);
    }
    /**
     * 取出左边第一个，取出后列表中不存在
     * @param key
     * @return
     */
    public Object getLoLeftPop(String key){
    	return listOps.leftPop(key);
    }
    /**
     * 更新下标为index的值
     * @param key
     * @param index
     * @param value
     */
    public void setLoUpdate(String key,int index,Object value){
    	listOps.set(key, index, value);
    }
    /**
     * 删除下标为index，值为value的元素
     * @param key
     * @param index
     * @param value
     */
    public void delLoRemove(String key,int index,Object value){
    	listOps.remove(key, index, value);
    }
    /**
     * 得到list大小
     * @param key
     * @return
     */
    public Long getLoListSize(String key){
    	return listOps.size(key);
    }
    /**
     * 得到index下标的元素
     * @param key
     * @param index
     * @return
     */
    public Object getLolindex(String key,int index){
    	return listOps.index(key, index);
    }
    /**
     * 添加无序集合
     * @param key
     * @param values
     * @return
     */
    public Long addSo(String key,Object ... values){
    	return setOps.add(key, values);
    }
    /**
     * 查询set集合
     * @param key
     * @return
     */
    public Set<Object> getSo(String key){
    	return setOps.members(key);
    }
    /**
     * 判断是否有这个值
     * @param key
     * @param value
     * @return
     */
    public boolean isSoMember(String key,Object value){
    	return setOps.isMember(key, value);
    }
    /**
     * 移除set中的值
     * @param key
     * @param values
     */
    public void delSoRemove(String key,Object ... values){
    	setOps.remove(key, values);
    }
    /**
     * 获得两个set的交集
     * @param key1
     * @param key2
     * @return
     */
    public Set<Object> getSoIntersect(String key1,String key2){
    	return setOps.intersect(key1, key2);
    }
    /**
     * 获得两个set的并集
     * @param key1
     * @param key2
     * @return
     */
    public Set<Object> getSoUnion(String key1,String key2){
    	return setOps.union(key1, key2);
    }
    /**
     * 获得两个set的差集
     * @param key1
     * @param key2
     * @return
     */
    public Set<Object> getSoDiff(String key1,String key2){
    	return setOps.difference(key1, key2);
    }
    /**
     * 随机返回并删除set中得一个元素
     * @param key
     * @return
     */
    public Object getSoSpop(String key){
    	return setOps.pop(key);
    }
    /**
     * 比较差集并且存储到另一个set中
     * @param key1
     * @param key2
     * @param destKey
     * @return
     */
    public Long getSoDiffStore(String key1,String key2,String destKey){
    	return setOps.differenceAndStore(key1, key2, destKey);
    }
    /**
     * 交集并存储到另一个集合中
     * @param key1
     * @param key2
     * @param destKey
     * @return
     */
    public Long getSoInterStore(String key1,String key2,String destKey){
    	return setOps.intersectAndStore(key1, key2, destKey);
    }
    /**
     * 并集并存储到另一个集合中
     * @param key1
     * @param key2
     * @param destKey
     * @return
     */
    public Long getSoUnionStore(String key1,String key2,String destKey){
    	return setOps.unionAndStore(key1, key2, destKey);
    }
    /**
     * 把第一个集合的元素移动到第二个集合中
     * @param key1
     * @param key2
     * @param value
     */
    public void setSoMove(String key1,String key2,Object value){
    	setOps.move(key1, value, key2);
    }
    /**
     * 返回set的大小
     * @param key
     * @return
     */
    public Long getSoSize(String key){
    	return setOps.size(key);
    }
    /**
     * 随机获得一个元素
     * @param key
     * @return
     */
    public Object getSoRandMember(String key){
    	return setOps.randomMember(key);
    }
    /**
     * 随机获得多个元素
     * @param key
     * @param count
     * @return
     */
    public List<Object> getSoRandMemberMore(String key,int count){
    	return setOps.randomMembers(key, count);
    }
    /**
     * 添加一个field,修改
     * @param key
     * @param hashKey
     * @param value
     */
    public void setHoPut(String key,String hashKey,Object value){
    	hashOps.put(key, hashKey, value);
    }
    /**
     * 添加map
     * @param key
     * @param m
     */
    public void setHoPutAll(String key,Map<String,Object> m){
    	hashOps.putAll(key, m);
    }
    /**
     * 得到hash中field的值
     * @param key
     * @param hashKey
     * @return
     */
    public Object getHo(String key,String hashKey){
    	return hashOps.get(key, hashKey);
    }
   
    /**
     * 获得所有的hashKeys
     * @param keys
     */
    public Set<String> getHoKeys(String keys){
    	return hashOps.keys(keys);
    }
    /**
     * 获得所有的value
     * @param keys
     * @return
     */
    public List<Object> getHoValues(String keys){
    	return hashOps.values(keys);
    }
    /**
     * 判断是否存在
     * @param key
     * @param hashKey
     * @return
     */
    public boolean isHoExists(String key,String hashKey){
    	return hashOps.hasKey(key, hashKey);
    }
    /**
     * 得到hashkey数量
     * @param keys
     * @return
     */
    public Long getHoSize(String key){
    	return hashOps.size(key);
    }
    /**
     * 删除指定的hashKey
     * @param key
     * @param hashKey
     */
    public void delHoRemove(String key,String hashKey){
    	hashOps.delete(key, hashKey);
    }
    /**
     * 添加
     * @param key
     * @param value
     * @param score
     * @return
     */
    public boolean addZSo(String key,Object value,int score){
    	return ZSetOps.add(key, value, score);
    }
    /**
     * 获得start-end个数据
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<Object> getZSoRange(String key,int start,int end){
    	return ZSetOps.range(key, start, end);
    }
    /**
     * 通过score获得set
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<Object> getZSoRangeScore(String key,int min,int max){
    	return ZSetOps.rangeByScore(key, min, max);
    }
    /**
     * 通过score获得set,并分页
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public Set<Object> getZSoRangeScore(String key,int min,int max,int offset,int count){
    	return ZSetOps.rangeByScore(key, min, max, offset, count);
    }
    /**
     * 获得start-end之间，按照score排序得set
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<Object> getZSoReverseRange(String key,int start,int end){
    	return ZSetOps.reverseRange(key, start, end);
    }
    
    /**
     * 获得score在min-max之间，按照score排序得set
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<Object> getZSoReverseRangeByScore(String key,int min,int max){
    	return ZSetOps.reverseRangeByScore(key, min, max);
    }
    /**
     * 获得score在min-max之间，按照score排序得set,并分页
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<Object> getZSoReverseRangeByScore(String key,int min,int max,int offset,int count){
    	return ZSetOps.reverseRangeByScore(key, min, max,offset,count);
    }
    /**
     * 删除，按照对象
     * @param key
     * @param values
     */
    public  Long delZSoRemove(String key,Object ... values){
    	return ZSetOps.remove(key, values);
    }
    /**
     * 删除，按照下标
     * @param key
     * @param values
     */
    public  Long delZSoRemoveRange(String key,int start,int end){
    	return ZSetOps.removeRange(key, start, end);
    }
    /**
     * 删除，按照score
     * @param key
     * @param values
     */
    public  Long delZSoRemoveRangeByScore(String key,int min,int max){
    	return ZSetOps.removeRangeByScore(key, min, max);
    }
    
    /**
     * 缓存List数据
     * @param key        缓存的键值
     * @param dataList    待缓存的List数据
     * @return            缓存的对象
     */
    public Object setCacheList(String key, List<Object> dataList)
    {
        ListOperations<String, Object> listOperation = redisTemplate.opsForList();
        if(null != dataList)
        {
            int size = dataList.size();
            for(int i = 0; i < size ; i ++)
            {
                listOperation.rightPush(key,dataList.get(i));
            }
        }
        return listOperation;
    }
    
    /**
     * 获得缓存的list对象
     * @param key    缓存的键值
     * @return        缓存键值对应的数据
     */
    public List<Object> getCacheList(String key)
    {
        List<Object> dataList = new ArrayList<Object>();
        ListOperations<String, Object> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size(key);
        
        for(int i = 0 ; i < size ; i ++)
        {
            dataList.add(listOperation.leftPop(key));
        }
        return dataList;
    }
    
    /**
     * 获得缓存的list对象
     * @Title: range 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @param key
     * @param @param start
     * @param @param end
     * @param @return    
     * @return List<T>    返回类型 
     * @throws
     */
    public List<Object> range(String key, long start, long end)
    {
        ListOperations<String, Object> listOperation = redisTemplate.opsForList();
        return listOperation.range(key, start, end);
    }
    
    /** 
     * list集合长度
     * @param key 
     * @return 
     */  
    public Long listSize(String key) {  
        return redisTemplate.opsForList().size(key);  
    }  
    
    /**
     * 覆盖操作,将覆盖List中指定位置的值
     * @param key
     * @param int index 位置
     * @param String
     *            value 值
     * @return 状态码
     * */
    public void listSet(String key, int index, Object obj) {
        redisTemplate.opsForList().set(key, index, obj);
    }
        
    /**
     * 向List尾部追加记录
     * 
     * @param String
     *            key
     * @param String
     *            value
     * @return 记录总数
     * */
    public long leftPush(String key, Object obj) {
        return redisTemplate.opsForList().leftPush(key, obj);
    }

    /**
     * 向List头部追加记录
     * 
     * @param String
     *            key
     * @param String
     *            value
     * @return 记录总数
     * */
    public long rightPush(String key, Object obj) {
        return redisTemplate.opsForList().rightPush(key, obj);
    }
    
    /**
     * 算是删除吧，只保留start与end之间的记录
     * 
     * @param String
     *            key
     * @param int start 记录的开始位置(0表示第一条记录)
     * @param int end 记录的结束位置（如果为-1则表示最后一个，-2，-3以此类推）
     * @return 执行状态码
     * */
    public void trim(String key, int start, int end) {
        redisTemplate.opsForList().trim(key, start, end);
    }
    
    /**
     * 删除List中c条记录，被删除的记录值为value
     * 
     * @param String
     *            key
     * @param int c 要删除的数量，如果为负数则从List的尾部检查并删除符合的记录
     * @param Object
     *            obj 要匹配的值
     * @return 删除后的List中的记录数
     * */
    public long remove(String key, long i, Object obj) {
        return redisTemplate.opsForList().remove(key, i, obj);
    }
    
    /**
     * 缓存Set
     * @param key        缓存键值
     * @param dataSet    缓存的数据
     * @return            缓存数据的对象
     */
    public BoundSetOperations<String, Object> setCacheSet(String key,Set<Object> dataSet)
    {
        BoundSetOperations<String, Object> setOperation = redisTemplate.boundSetOps(key);    
        /*T[] t = (T[]) dataSet.toArray();
             setOperation.add(t);*/
        
        Iterator<Object> it = dataSet.iterator();
        while(it.hasNext())
        {
            setOperation.add(it.next());
        }
        return setOperation;
    }
    
    /**
     * 获得缓存的set
     * @param key
     * @param operation
     * @return
     */
    public Set<Object> getCacheSet(String key/*,BoundSetOperations<String,T> operation*/)
    {
        Set<Object> dataSet = new HashSet<Object>();
        BoundSetOperations<String,Object> operation = redisTemplate.boundSetOps(key);    
        
        Long size = operation.size();
        for(int i = 0 ; i < size ; i++)
        {
            dataSet.add(operation.pop());
        }
        return dataSet;
    }
    
    /**
     * 缓存Map
     * @param key
     * @param dataMap
     * @return
     */
    public int setCacheMap(String key,Map<String, Object> dataMap)
    {
        if(null != dataMap)
        {
            HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
            for (Map.Entry<String, Object> entry : dataMap.entrySet()) {  
                /*System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  */
                if(hashOperations != null){
                    hashOperations.put(key,entry.getKey(),entry.getValue());
                } else{
                    return 0;
                }
            } 
        } else{
            return 0;
        }
        return dataMap.size();
    }
    
    /**
     * 获得缓存的Map
     * @param key
     * @param hashOperation
     * @return
     */
    public Map<Object, Object> getCacheMap(String key/*,HashOperations<String,String,T> hashOperation*/)
    {
        Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
        /*Map<String, T> map = hashOperation.entries(key);*/
        return map;
    }
    
    /**
     * 缓存Map
     * @param key
     * @param dataMap
     * @return
     */
    public void setCacheIntegerMap(String key,Map<Integer, Object> dataMap)
    {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        if(null != dataMap)
        {
            for (Map.Entry<Integer, Object> entry : dataMap.entrySet()) {  
                /*System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  */
                hashOperations.put(key,entry.getKey(),entry.getValue());
            } 
            
        }
    }
    
    /**
     * 获得缓存的Map
     * @param key
     * @param hashOperation
     * @return
     */
    public Map<Object, Object> getCacheIntegerMap(String key/*,HashOperations<String,String,T> hashOperation*/)
    {
        Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
        /*Map<String, T> map = hashOperation.entries(key);*/
        return map;
    }
    
    /**
     * 从hash中删除指定的存储
     * 
     * @param String
     * @return 状态码，1成功，0失败
     * */
    public long deleteMap(String key) {
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.opsForHash().delete(key);
		return 1;
    }
    
     /**
      * 设置过期时间
      * @param key
      * @param time
      * @param unit
      * @return
      */
    public boolean expire(String key, long time, TimeUnit unit) {
        return redisTemplate.expire(key, time, unit);
    }
    
    /**
     * increment
     * @param key
     * @param step
     * @return
     */
    public long increment(String key, long step) {
        return redisTemplate.opsForValue().increment(key, step);
    }

    
    //redisTemplateSerializable
    
    /**
     * 删除redis的所有数据
     */
    /*@SuppressWarnings({"unchecked", "rawtypes"})
    public String flushDB() {
        return redisTemplateSerializable.execute(new RedisCallback() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
    }*/
    
    public long del(final byte[] key) {  
        return (Long) redisTemplateSerializable.execute(new RedisCallback<Object>() {  
            public Long doInRedis(RedisConnection connection) {  
                return connection.del(key);  
            }  
        });  
    }  

    @SuppressWarnings({"unchecked", "rawtypes"})
    public byte[] get(final byte[] key) {
        return (byte[]) redisTemplateSerializable.execute(new RedisCallback() {
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(key);
            }
        });
    }
    
    /**
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(final byte[] key, final byte[] value, final long liveTime) {
        redisTemplateSerializable.execute(new RedisCallback<Object>() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(key, value);
                if (liveTime > 0) {
                    connection.expire(key, liveTime);
                }
                return 1L;
            }
        });
    }

}