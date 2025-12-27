class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {

        // 1. Sort by employee, then by time
        Collections.sort(access_times, (a, b) -> {
            if (a.get(0).equals(b.get(0))) {
                return Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1));
            }
            return a.get(0).compareTo(b.get(0));
        });

        Set<String> resultSet = new HashSet<>();
        Queue<Integer> times = new LinkedList<>();

        String prevPerson = "";
        
        for (List<String> entry : access_times) {
            String person = entry.get(0);
            int currTime = Integer.parseInt(entry.get(1));

            // 2. New employee → reset queue
            if (!person.equals(prevPerson)) {
                times.clear();
                prevPerson = person;
            }

            // 3. Remove times older than 1 hour (100)
            while (!times.isEmpty() && currTime - times.peek() >= 100) {
                times.poll();
            }

            // 4. Add current time
            times.offer(currTime);

            // 5. If 3 or more accesses within 1 hour
            if (times.size() >= 3) {
                resultSet.add(person);
            }
        }

        return new ArrayList<>(resultSet);
    }
}
