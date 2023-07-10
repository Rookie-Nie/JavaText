package map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map 查找表
 * Map是java集合框架的一员 ，但Map和Collection不存在继承关系！！！
 *
 * Map体现的结构是一个多行两列的表格，左列称为key，右列称为value
 * Map总是以key-value对的形式保存数据
 * Map总是根据key获取对应的value
 * Map要求key不允许重复(重复的依据是equals方法)
 *
 * Map是一个接口，下面有常用的实现类:
 * java.util.HashMap:散列表，哈希表。是使用散列算法实现的Map
 * java.util.TreeMap:使用二叉树算法实现的Map
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        Integer value = map.put("语文",99);
        System.out.println(value);
        map.put("英语",95);
        map.put("数学",98);
        map.put("物理",97);
        map.put("化学",96);
        System.out.println(map);

        value = map.put("英语",32);
        System.out.println("value:"+value);
        System.out.println(map);
        //根据key值返回value（查找）
        value = map.get("数学");
        System.out.println("数学："+value);
        value = map.get("体育");
        System.out.println("体育："+value);
        //根据key值删除元素
        value = map.remove("英语");
        System.out.println("被删除的key对应的value是："+value);
        System.out.println(map);
        //获取map的元素个数
        int size = map.size();
        System.out.println("size:"+size);
        //判断map是否包含指定的可以或value
        boolean ck = map.containsKey("物理");
        boolean cv = map.containsValue(97);
        System.out.println("是否包含key："+ck);
        System.out.println("是否包含value："+cv);
        //清空map
        map.clear();
        System.out.println(map);
    }
}
