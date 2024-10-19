package Collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapCollection {
    private Map<String, Integer> hashMap;
    private Map<String, Integer> linkedHashMap;

    public MapCollection(){
        hashMap = new HashMap<>();
        linkedHashMap = new LinkedHashMap<>();
    }
    public void addToHashMap(String key,Integer value){
        hashMap.put(key,value);
    }
    public void addToLinkedHashMap(String key,Integer value){
        linkedHashMap.put(key,value);
    }
    public void removeHashMap(String key){
        hashMap.remove(key);
    }
    public void removeLinkedHashMap(String key){
        linkedHashMap.remove(key);
    }

    public void updateHash(String key,Integer value){
        hashMap.put(key,value);
    }

    public void loopHashMap(){
        System.out.println("Danh sách của HashMap:");
        for (Map.Entry< String,Integer> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(" Key: " + key + " Value: " + value);
        }
    }
    public void loopLinkedHashMap(){
        System.out.println("Danh sách của LinkHashMap:");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()){
            System.out.println("Key: " + entry.getKey() + "Value: " + entry.getValue());
        }
    }



    public static void main(String[] args) {
        MapCollection mapCollection = new MapCollection();
        mapCollection.addToHashMap("Java", 2 );
        mapCollection.addToHashMap("Python", 5 );
        mapCollection.addToHashMap("C#", 2 );
        mapCollection.addToHashMap("C++", 4 );

        mapCollection.loopHashMap();

        mapCollection.updateHash("Java", 4);
        mapCollection.loopHashMap();

        mapCollection.removeHashMap("Java");
        mapCollection.loopHashMap();
    }
}
