import java.util.*;

class TimeMap {
    private static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Pair>> kvds;

    public TimeMap() {
        this.kvds = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        kvds.putIfAbsent(key, new ArrayList<>());
        kvds.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!kvds.containsKey(key)) return "";

        List<Pair> list = kvds.get(key);
        int left = 0, right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}