package javacollection_tree_and_map.practice;

import java.util.*;

public class HashMapAndHashSet {
    public static void main(String[] args) {
//        Student student1 = new Student("Hien", "DN", 20);
//        Student student2 = new Student("Ban", "HN", 22);
//        Student student3 = new Student("Phuong", "PY", 30);
//        Student student4 = new Student("Toan", "H", 40);
//        Student student5 = new Student("Khai", "QN", 25);
        Map<String, Integer> hashmap = new HashMap<>();
        hashmap.put("Hien", 20);
        hashmap.put("Hien2", 24);
        hashmap.put("Hien3", 30);
        hashmap.put("Hien4", 40);
        hashmap.put("Hien5", 250);
        hashmap.put("Hien6", 60);
        System.out.println("-------------------------------HASHMAP---------------------");
//        for (Map.Entry<String,Integer> student : hashmap.entrySet()) {
//            System.out.println(student);
//        }

        Set<String> keySet = hashmap.keySet();
        for (String key : keySet) {
            System.out.println("key " +key+ "-->" + hashmap.get(key));
        }
        System.out.println("--------------------LinkedHashMap-------------------------------");
        Map<String,Integer> linkedhashmap = new LinkedHashMap<>();
       linkedhashmap.put("Hien", 20);
        linkedhashmap.put("Hien2", 24);
        linkedhashmap.put("Hien3", 30);
        linkedhashmap.put("Hien4", 40);
        linkedhashmap.put("Hien5", 250);
        linkedhashmap.put("Hien6", 60);
        for (Map.Entry<String,Integer> student : linkedhashmap.entrySet()) {
            System.out.println(student);
        }
    }
}
