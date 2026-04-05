class Solution {

    public String encode(List<String> strs) {
        // PROBLEM: codificar uma lista/vetor de strings numa string única 
        // e depois ser capaz de converter de volta para uma lista de stirngs
        // INPUT: lista de strings // OUTPUT: string única codificada (ou vice-versa)
        // EXAMPLE: "["Bom", " dia", ",", " Lucas!"]" -> "Bom dia, Lucas!" (e vice-versa)
        // PATTERN: não sei
        // APPROACH: eu pensei em utilizar prefixos ou sufixos na string, mas para suportar quaisquer caracteres isso pode ser um problema
        // vou tentar utilizar regex
        // COMPLEXITY: nem desconfio
        String prefix = "#";
        StringBuilder builder = new StringBuilder();
        for (String s : strs) {
            int size = s.length();
            builder.append(size).append(prefix).append(s);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        int i = 0;
        int j = str.indexOf('#', i);
        while (i < str.length()) {
            String lengthStr = str.substring(i, j);
            int digits = lengthStr.length();
            int nextWordLength = Integer.parseInt(lengthStr);
            while (digits > 1) {
                digits -= 1;
            }
            decodedStrings.add(str.substring(j+1, nextWordLength + j + digits));
            i += nextWordLength + lengthStr.length() + 1;
            j = str.indexOf('#', i);
        }
        return decodedStrings;
    }
}