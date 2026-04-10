class Solution {
    public int maxArea(int[] heights) {
        // PROBLEM: cada posição no array de entrada representa a altura de uma barra
        // eu preciso calcular a área bidimensional (não o volume) do recipiente com
        // mais água. Para o cálculo, preciso avaliar a distância horizontal na base
        // entre as colunas (j-i ou right - left) e a altura do menor dos dois maiores pilares
        // INPUT: [1, 2, 3, 4, 5, 6] -> distância máxima: 5 (5- 0).
        // OUTPUT: área máxima: 5 (5-4 * 5)
        // EXAMPLE: [0, 2, 10, 3, 4, 5, 9, 1, 4]
        // PATTERN: two pointers
        // APPROACH: comparar a cada iteração a maior distância e os maiores pilares
        // a maior distância sozinha não quer dizer muita coisa, o array pode ser assim: [1, .........,1]
        // e as maiores colunas também não resolvem sozinhas, o array pode ser assim: [2, 5000, 4999, 5]
        // é preciso comparar simultaneamente os 2 eixos que compoem a área x (altura da menor das duas colunas), y (distância entre elas)
        // COMPLEXITY: vou começar com brute force O(N²) e tentar otimizar a partir daí
        // 9 min até agora
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int left = heights[i];
                int right = heights[j];
                // distância entre barras
                int xAxis = j - i;
                // altura da menor das barras
                int yAxis = Math.min(left, right);
                int currArea = xAxis * yAxis;
                maxArea = Math.max(currArea, maxArea);
            }
        }
        return maxArea;
    }
}
