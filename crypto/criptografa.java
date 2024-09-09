package crypto;
/*
    Desafio de Criptografia - Seguraca da Informacao
    Autor: Nicolas Escobar - Aluno IFSC Gaspar

    Crie um pequeno projeto em java que implemente duas funções,
    uma para realizar a criptografia de Cesar e outra para
    a criptografia de Vigenere.

    As duas funções devem receber como parâmetros uma string representando
    o texto a ser criptografado e um número representando a chave escolhida.
    Para a cifra de Cesar, a chave é apenas um número inteiro, enquanto para
    a cifra de Vigenere a chave deve ser um vetor com 3 números inteiros.
 */
public class criptografa {

    public static void main(String[] args) {
//  Constantes para chave de criptografia
        final int[] keyVigenere = {5,2,7};
        final int   keyCesar = 4;
//  Texto de exemplo para criptografia
        String loremIpsum = "Teste aula Seguranca da Informacao";
//  Inicio de execucao
        System.out.println("Vamos testar as criptografias de Cesar e Vigenere");
//	Uso de funcoes para criptografia do texto
        String criptoCesar = cryptoCesar(loremIpsum, keyCesar);
        String criptoVigenere = cryptoVigenere(loremIpsum, keyVigenere);
//  Mostra ao usuario resultado da criptografia
        System.out.println("Criptografia de Cesar: " + criptoCesar
                + "\nCriptografia de Vigenere: " + criptoVigenere);
    }
    private static String cryptoVigenere(String texto, int[] chave) {
//  Define que a chave tenha pelo menos 3 caracteres
        if(chave.length < 2) {
            System.err.println("A Chave precisa de 3 numeros inteiros");
            return null;
        }
//  Index para a chave
        int idx=0;
//  Monta array de Caracteres para manipulacao de String
        char[] arrTexto = texto.toCharArray();
//  Percorre o array de Caracteres
        for (int i=0; i < arrTexto.length; i++) {
//  Altera o valor de cada caracter seguindo a chave definida
            arrTexto[i] = (char) (arrTexto[i] + chave[idx]);
//  Valida o indice da chave e reseta
            if(idx>1) idx=0;
            else idx++;
        }
//  Retorna o valor da String com os caracteres codificados
        return String.valueOf(arrTexto);
    }
    private static String cryptoCesar(String texto, int chave) {
//  Define array de caracteres
        char[] arrTexto = texto.toCharArray();
//  Percorre array para modificacao de String
        for (int i=0; i < arrTexto.length; i++) {
//  Altera caracter seguindo a chave definida
            arrTexto[i] = (char) (arrTexto[i] + chave);
        }
//  Retorna o valor da String apos criptografia
        return String.valueOf(arrTexto);
    }
}
