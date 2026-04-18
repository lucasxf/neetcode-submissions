class Solution {
    public int findMin(int[] nums) {
        // é um problema de binary search com array rotacionado
        // exemplos:
        // 1. array ordenado em ordem crescente original -> array rotacionado: [1, 2, 3, 4 , 5] -> [3, 4, 5, 1, 2]
        // são apenas itens únicos na entrada (sem duplicidade no array nums)
        // neste exercício, cada rotação "puxa" os N últimos números do array para o início dele
        // 3 rotações = os 3 últimos números do array são movidos para o começo
        // se o array tem tamanho N, ao rotacioná-lo N vezes, ele tornará à ordem original
        // o objetivo é retornar o menor número do array.
        // o desafio é fazê-lo em O(log N) time (do contrário a força bruta é só iterar o array até encontrar o menor número) -> O(N)
        // sem saber quantas rotações o array passou, tampouco o tamanho dele (até conferi-lo), não é possível afirmar se:
        // I - o menor número está ao início, II - o menor número está ao fim, III - o menor número está no meio do array
        // 8 min
        // observações:
        // A) se o array passou por 1 à N-1 rotações, onde N é o tamanho dele
        // é possível afirmar que [0] > [n-1] (o primeiro número do array será maior que o último se algum número de rotações
        // ocorreu, desde que este número seja inferior ao tamanho do array (ou não seja múltiplo dele: quantRotacoes % n != 0))
        // se nums[0] > nums[n-1] -> o array está ordenado e o o resultado é nums[0]
        // 11 min - ainda não codei
        // por mais que o array esteja em ordem crescente, eu não sei se os números são incrementados de 1 em 1
        // ele pode ser [0, 1000, 1001, 53000, 1_000_000, 1_000_002] ou [1, 2, 3, 4, 5]
        // se o array rotacionou (avaliado na observação A) e eu estou no índice do meio dele (bin search)
        // e nums[meio-1] < nums[meio] < nums[meio+1] (ex.: [2, 3, 4]), significa que o menor número está à direita do meio 
        // (corto pela metade meu universo de busca)
        // se nums[meio-1] >= nums[meio] && nums[meio] < nums[meio+1] ->
        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] -> [4, 5, 6, 7, 8, 9, 10, 1, 2, 3]
        // na verdade, preciso comparar se nums[meio] > nums[left].(8 > 4? => true)
        // se for, pesquiso à direita [8, 9, 10, 1, 2, 3]
        // [8, 9, 10, 1, 2, 3, 4, 5, 6, 7]
        // [0, 1, 02, 3, 4, 5, 6, 7, 8, 9]
        // se não for, pesquiso à esquerda: [3 > 8? => false]
        // [8, 9, 10, 1, 2]
        // 20 min, vou escrever o código
        int n = nums.length;
        int left = 0;
        int right = n -1;
        int min = Integer.MAX_VALUE;
        // nums = [4,5,0,1,2,3]
        if (nums[left] <= nums[n-1]) {
            return nums[left];
        }
        while (left < right) { // 0 < 6 | 0 < 2 | 0 < 1 | 2 < 1? -> false
            int mid = left + (right - left) / 2; //3-0=3 | 2-0=2 | 1-0=1
            int value = nums[mid]; // nums[3]=1 | nums[2]=0 | nums[1] = 5
            min = Math.min(min, value); // 1 | 0 | 0
            System.out.printf("left: %d | right: %d | mid: %d | value: %d | min: %d%n", left, right, mid, value, min);
            if (value > nums[left]) { // 1 > 4? -> false | 0 > 4? -> false | 5 > 4? -> true
                left = mid + 1; // 2
            } else {
                right = mid; // right=3-1=2 | right=(2-1)=1
            }
        }
        return min; // 0
    }
}
