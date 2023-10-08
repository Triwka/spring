package ru.chernykh.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class HelloController {

    private List<String> strings;
    private Integer counter = 0;
    private HashMap<Integer, String> hashMap;
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name) {
        return String.format("Hello, %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(required = false) String param) {
        if (strings == null) {
            strings = new ArrayList<>();
        }
        if (param == null) {
            return "Empty input";
        }
        strings.add(param);
        return String.format("Success, value %s is added to array", param);
    }

    @GetMapping("/show-array")
    public String showArrayList() {
        if (strings == null || strings.isEmpty()) {
            return "Array is empty!";
        }
        return strings.toString();
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "param") String param) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put(counter++, param);
        return hashMap.toString();
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        if (hashMap == null || hashMap.isEmpty()) {
            return "HashMap is empty!";
        }
        return hashMap.toString();
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        HashMap<String, Integer> lengths = new HashMap<>();
        if (strings != null) {
            lengths.put("ArrayList", strings.size());
        }
        if (hashMap != null) {
            lengths.put("HashMap", hashMap.size());
        }
        return lengths.toString();
    }
}