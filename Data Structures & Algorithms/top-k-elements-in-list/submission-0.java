class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // PROBLEM: encontrar os elementos mais frequentes de um array e retorna-los agrupados num array
        // INPUT: array e K elementos (onde K são os TOP elementos), OUTPUT: array com os elementos
        // PATTERN: já vi esse número antes? Se sim, incremento o número de ocorrências dele. 
        // Ao final, ordeno pelos K elementos com mais ocorrências, removo duplicidades e retorno um array a saída
        // APPROACH: para contagem de elementos únicos um Set/Map devem me ajudar.
        // COMPLEXITY: O(N * log N * k) time, O(N) space
        // 4 min para escrever até aqui
        Map<Integer, Integer> frequencyPerNumber = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            frequencyPerNumber.merge(key, 1, Integer::sum); // increment frequency
        }
        List<Integer> values = new ArrayList<>();
        for (Integer key : frequencyPerNumber.keySet()) {
            Integer value = frequencyPerNumber.get(key);
            values.add(value); // create separate frequency list
        }
        values.sort(Comparator.reverseOrder()); // sort in descending order
        List<Integer> topKElements = new ArrayList();
        System.out.println("values: " + values);
        for (int i = 0; i < k; i++) {
            topKElements.add(values.get(i)); // add top K most frequent elements
        }
        System.out.println("top k: " + topKElements);
        System.out.println("Frequency/number: " + frequencyPerNumber);
        int j = 0;
        int[] result = new int[k];
        for (Integer key : frequencyPerNumber.keySet()) {
            Integer value = frequencyPerNumber.get(key);
            // when top element is found
            if (topKElements.contains(value)) {
                // store its key (the original num which frequency was being tracked) in result array, increment index for next iteration
                result[j++] = key;
            }
            if (j == k) {
                // stop earlier if array is full and top K elements are found
                break;
            }
        }
        return result;
    }
}
