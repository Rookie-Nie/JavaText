package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("语文",99);
        map.put("英语",95);
        map.put("数学",98);
        map.put("物理",97);
        map.put("化学",96);
        System.out.println(map);

        /*遍历所有的key
        Set keySet()
        将当前Map中所有的key以一个Set集合形式返回
         */
        Set<String> keySet = map.keySet();
        for (String key : keySet){
            System.out.println("key:"+key);
        }

        Set<Map.Entry<String,Integer>>  entrySet = map.entrySet();
        for (Map.Entry<String,Integer> e : entrySet){
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+":"+value);
        }

        Collection<Integer> values = map.values();
        for (Integer value : values){
            System.out.println("value:"+value);
        }

        map.forEach((k,v)-> System.out.println(k+":"+v));


    }
}
