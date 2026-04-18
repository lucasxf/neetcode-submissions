class Solution {
    public boolean isValid(String s) {
        // eu recebo uma string com parênteses, chaves e colchetes '(), [], {}'
        // e retorno se ela é válida ou não
        // para ser válida, cada abertura de parêntese, chave ou colchete,
        // deve ter um par fechando devidamente
        // acho que 2 pointers é uma solução melhor do que stack 
        // (stack é a categoria deste problema no blind 75 do neetcode)
        // 2 pointers: na verdade, uma string "()()()(){}{{{}}}[[[]]]" embora válida, quebraria com 2 pointers.
        // abortei essa abordagem
        // de volta à stack: 5 min
        // 9 min, não sabia por onde começar, li as 3 dicas
        Stack<String> stack = new Stack<>();
        for (int i  = 0; i < s.length(); i++) {
            String curr = s.substring(i, i+1);
            if (curr.equals("(") || curr.equals("[") || curr.equals("{")) {
                stack.push(curr);
            } else if (stack.empty()) {
                return false;
            }
            else if (curr.equals(")")) {
                // se o topo da pilha não for o caracter de abertura, retorna falso
                if (!stack.peek().equals("(")) {
                    return false;
                }
                stack.pop();
            }
            else if (curr.equals("]")) {
                // se o topo da pilha não for o caracter de abertura, retorna falso
                if (!stack.peek().equals("[")) {
                    return false;
                }
                stack.pop();
            }
            else if (curr.equals("}")) {
                if (!stack.peek().equals("{")) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
