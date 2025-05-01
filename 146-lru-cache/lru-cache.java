class LRUCache {
  private final LinkedHashMap<Integer,Integer> cache;
  public LRUCache(int capacity) {
    this.cache = new LinkedHashMap<>(16, 0.75f, true) {
      @Override protected boolean removeEldestEntry(Map.Entry<Integer,Integer> e) {
        return size() > capacity;
      }
    };
  }
  public int get(int key) {
    return cache.getOrDefault(key, -1);
  }
  public void put(int key, int value) {
    cache.put(key, value);
  }
}
