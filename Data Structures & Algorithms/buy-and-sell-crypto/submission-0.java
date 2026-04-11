class Solution {
    public int maxProfit(int[] prices) {
        // eu recebo um array de preços onde cada índice do array
        // é o preço da ação naquele dia. Lê-se o array da esquerda para direita
        // então os primeiros dias estão no início, os últimos dias estão no fim:
        // o cálculo sempre virá do "futuro" (índices altos) para o "presente/passado" (índices baixos)
        // o lucro é calculado pelo fórmula: preço de venda - preço de compra.
        // se nenhum dia para transacionar se provar lucrativo, é possível retornar 0 (buy and hold rs)
        // ex: [1, 2, 10, 25] -> melhor dia para compra 1º dia (i=0) preço 1, melhor dia para venda 4º dia (i=3), preço 25.
        // lucro = 24 (25-1)
        // ex.: [10, 5, 1] -> retorno 0. Não há dias bons para venda com lucro, pois, os preços caem a cda dia
        // estratégia 1: brute force. comapra-se cada preço com os preços futuros para avaliar possível venda
        // estratégia 2: ainda não defini
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int buyPrice = prices[i];
                int sellPrice = prices[j];
                int balance = sellPrice - buyPrice;
                if (sellPrice > buyPrice) {
                    maxProfit = Math.max(maxProfit, balance);
                } else {
                    continue;
                }
            }
        }
        return maxProfit;
    }
}
