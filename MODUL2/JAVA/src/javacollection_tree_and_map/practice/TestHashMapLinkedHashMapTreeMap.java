package javacollection_tree_and_map.practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestHashMapLinkedHashMapTreeMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("David", 10);
        hashMap.put("Michel", 12);
        hashMap.put("Stone", 13);
        hashMap.put("Join", 14);
        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\t");
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println(linkedHashMap);
        System.out.println("The age for " + "Lewis is " + linkedHashMap.get("Lewis"));
    }
}
