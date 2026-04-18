class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // para otimizar o uso de 2 pointers, vou ordenar o array de entrada
        // depois vou criar laços encadeados e comparar as extremidades com o item atual
        // se encontrar matches, salvo na resposta
        Arrays.sort(nums);
        List<List<Integer>> threeSum = new ArrayList<>();
        Set<String> seenSums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int a = nums[i];
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                int sum = a + b + c;
                if (sum == 0) {
                    List<Integer> validSum = List.of(a, b, c);
                    String key = String.format("%d%d%d", a, b, c);
                    System.out.println("key:" + key);
                    if (!seenSums.contains(key)) {
                        seenSums.add(key);
                        threeSum.add(validSum);
                    }
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return threeSum;
    }
}
