import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a HashMap
        Map<String, Integer> hashMap = new HashMap<>();

        // Adding elements to the HashMap
        hashMap.put("Apple", 2);
        hashMap.put("Banana", 3);
        hashMap.put("Orange", 5);

        // Retreiving the value asociated to a specific key
        int apple_count = hashMap.get("Apple");
        System.out.println("Apple Count: " + apple_count);

        // Verifying if a keay is already in the HashMap
        boolean is_banana = hashMap.containsKey("Banana");
        System.out.println("Is Banana in the HashMap? " + is_banana);

        // Removing an element from the HashMap
        hashMap.remove("Orange");

        // Iterating through every key-value pair in the HashMap
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }
}
