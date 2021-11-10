package com.jhzz.cs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @PACKAGE_NAME: com.jhzz
 * @author: JHZZ
 * @date: 2021/11/3 11:41
 * @PROJECT_NAME: JavaProjects
 */
//拓展HashMap类，要求value不可重复
public class CrazyitMap<K,V> extends HashMap<K,V> {
    //根据value删除指定项
    public void removeByValue(Object value) {
        for (Object key : keySet()){
            if (get(key) == value) {
                remove(key);
                break;
            }
        }
    }
    //获取所有的value组成的Set集合
    public Set<V> valueSet() {
        Set<V> result = new HashSet<V>();
        //遍历所有的key组成的集合
        for (V value : values()) {
            //将每个key对应的value添加到result集合中
            result.add(value);
        }
        return result;
    }
    //根据value查找key
    public K getKeyByValue(V value) {
        //遍历所有key组成的集合
        for (K key : keySet()){
            //如果指定key对应的value与被搜索的value相同
            //则返回对应key
            if (get(key).equals(value) && get(key) == value){
                return key;
            }
        }
        return null;
    }
    //重写HashMap的put方法，不允许添加重复value
    public V put(K key,V value){
        //遍历所有的value集合
        for (V val : valueSet()){
            //如果指定的value与试图放入的集合value重复
            //则抛出一个RuntimeException异常
            if (val.equals(value) && val.hashCode() == value.hashCode()){
                throw new RuntimeException("MyMap不许添加重复value!");
            }
        }
        return super.put(key,value);
    }
}
