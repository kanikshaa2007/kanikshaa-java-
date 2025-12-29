class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        // content -> list of file paths
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            // Split directory and files
            String[] parts = path.split(" ");
            String dir = parts[0];

            // Process each file
            for (int i = 1; i < parts.length; i++) {
                String file = parts[i];

                int idx = file.indexOf('(');
                String fileName = file.substring(0, idx);
                String content = file.substring(idx + 1, file.length() - 1);

                String fullPath = dir + "/" + fileName;

                map.computeIfAbsent(content, k -> new ArrayList<>())
                   .add(fullPath);
            }
        }

        // Collect duplicates
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : map.values()) {
            if (group.size() > 1) {
                result.add(group);
            }
        }

        return result;
    }
}
