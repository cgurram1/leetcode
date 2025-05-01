import java.util.*;

class TimeMap {
    private Map<String, TreeMap<Integer, String>> kvds;

    public TimeMap() {
        this.kvds = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        kvds.putIfAbsent(key, new TreeMap<>());
        kvds.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!kvds.containsKey(key)) return "";

        TreeMap<Integer, String> timeMap = kvds.get(key);
        Integer floorTimestamp = timeMap.floorKey(timestamp);

        return floorTimestamp != null ? timeMap.get(floorTimestamp) : "";
    }
}
