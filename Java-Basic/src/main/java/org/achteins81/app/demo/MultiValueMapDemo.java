package org.achteins81.app.demo;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

import java.util.*;

/**
 * 在Map中一个key对应多个value
 * HashMap - Single Key and Multiple Values
 *
 * @see <a href="https://dzone.com/articles/hashmap-%e2%80%93-single-key-and">Jagadeesh Motamarri and DZone</a>
 * @see <a href="https://java2blog.com/add-multiple-values-for-single-key-hashmap-java/">Java2Blog</a>
 * @see <a href="https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/How-to-make-multiple-values-per-key-in-a-Java-map-possible">TheServerSide</a>
 * @since 2023-04-19
 */
public class MultiValueMapDemo {
    public static void main(String[] args) {
        usingList();
        usingGuava();
        usingApacheCollections();
    }

    /**
     * HashMap - Single Key and Multiple Values using List
     *
     * @author Jagadeesh Motamarri
     */
    public static void usingList() {
        // create multimap to store
        Map<String, List<String>> map = new HashMap<>();

        // create list one to store values
        List<String> valSetOne = new ArrayList<>();
        valSetOne.add("Apple");
        valSetOne.add("Aeroplane");

        // create list two to store values
        List<String> valSetTwo = new ArrayList<>();
        valSetTwo.add("Bat");
        valSetTwo.add("Banana");

        // create list three to store values
        List<String> valSetThree = new ArrayList<>();
        valSetThree.add("Cat");
        valSetThree.add("Car");

        // put values into map
        map.put("A", valSetOne);
        map.put("B", valSetTwo);
        map.put("C", valSetThree);

        // iterate and display values
        System.out.println("Fetching keys and corresponding [Multiple] Values n");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            System.out.println("Key = " + key);
            System.out.println("Values = " + values + "n");
        }
    }

    /**
     * HashMap - Single Key and Multiple Values using Google Guava Collections
     *
     * @author Jagadeesh Motamarri
     */
    public static void usingGuava() {
        // create multimap to store key and values
        Multimap<String, String> multiMap = ArrayListMultimap.create();

        // put values into map for A
        multiMap.put("A", "Apple");
        multiMap.put("A", "Aeroplane");

        // put values into map for B
        multiMap.put("B", "Bat");
        multiMap.put("B", "Banana");

        // put values into map for C
        multiMap.put("C", "Cat");
        multiMap.put("C", "Car");

        // retrieve and display values
        System.out.println("Fetching keys and corresponding [Multiple] Values n");

        // get all the set of keys
        Set<String> keys = multiMap.keySet();

        // iterate through the key set and display key and values
        for (String key : keys) {
            System.out.println("Key = " + key);
            System.out.println("Values = " + multiMap.get(key) + "n");
        }
    }

    /**
     * HashMap - Single Key and Multiple Values using Apache Commons Collections
     *
     * @author Jagadeesh Motamarri
     */
    public static void usingApacheCollections() {
        // create multimap to store key and values
        MultiMap multiMap = new MultiValueMap();

        // put values into map for A
        multiMap.put("A", "Apple");
        multiMap.put("A", "Aeroplane");

        // put values into map for B
        multiMap.put("B", "Bat");
        multiMap.put("B", "Banana");

        // put values into map for C
        multiMap.put("C", "Cat");
        multiMap.put("C", "Car");

        // retrieve and display values
        System.out.println("Fetching keys and corresponding [Multiple] Values n");

        // get all the set of keys
        Set<String> keys = multiMap.keySet();

        // iterate through the key set and display key and values
        for (String key : keys) {
            System.out.println("Key = " + key);
            System.out.println("Values = " + multiMap.get(key) + "n");
        }
    }
}
