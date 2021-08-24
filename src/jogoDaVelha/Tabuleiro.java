package jogoDaVelha;

public class Tabuleiro {

    //Declarando matriz "baseTab" com 9 posições, cuja as mesmas, estão sendo atribuídas números de 1 a 9.
    //A matriz é do tipo String.
    public String[][] baseTab = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

    //Variáveis
    private int dificuldade = 0;    //Var para definir a dificuldade.

    //Getters e Setters
    public int getDificuldade() {   //Get para retornar a dificuldade.   
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {   //Set para acessar na variável e atribuir a ela algum valor.
        this.dificuldade = dificuldade;
    }

    //Método para mostrar o tabuleiro.
    public String mostrar() {
        //Percorrendo a matriz.
        for (int linha = 0; linha < baseTab.length; linha++) {
            for (int coluna = 0; coluna < baseTab.length; coluna++) {
                System.out.printf("|   " + baseTab[linha][coluna] + "  |");
            }
            System.out.println("\n");
        }
        return null;
    }

    //Método com parametros de posição e símbolo escolhido.
    public void jogada(String posicao, String simbolo) {

        //Condicionais para atribuir o símbolo nas posições escolhidas.
        if (posicao.equals("1")) {
            baseTab[0][0] = simbolo;
        } else if (posicao.equals("2")) {
            baseTab[0][1] = simbolo;
        } else if (posicao.equals("3")) {
            baseTab[0][2] = simbolo;
        } else if (posicao.equals("4")) {
            baseTab[1][0] = simbolo;
        } else if (posicao.equals("5")) {
            baseTab[1][1] = simbolo;
        } else if (posicao.equals("6")) {
            baseTab[1][2] = simbolo;
        } else if (posicao.equals("7")) {
            baseTab[2][0] = simbolo;
        } else if (posicao.equals("8")) {
            baseTab[2][1] = simbolo;
        } else if (posicao.equals("9")) {
            baseTab[2][2] = simbolo;
        }
    }

    //Método para validar a posição digitada, se a mesma estiver ocupada, retornará false, se não, true.
    public boolean validar(String posicao) { //Verificador de posição.
        for (int linha = 0; linha < baseTab.length; linha++) {
            for (int coluna = 0; coluna < baseTab.length; coluna++) {
                if (baseTab[linha][coluna].equals(posicao)) {
                    return true;    //Se for igual a posição, então retornará true.
                }
            }
        }
        return false;   //Se estiver ocupada, retornará false.
    }

    //Método para verificar o Vencedor.
    public String win(int jogada) {
        String[] vetor = new String[8]; //Declarando um vetor de 8 posições, pois existem 8 possibilidades de vitória.
        String resultado = "null";  //Inicializando a variável resultado.

        if (jogada == 9) {  //Se tiver 9 jogadas, então resultará em empate.
            resultado = "Empate";   //Atribuindo "Empate" para a variável resultado.
        }

        //Concatenando os símbolos das possíveis posições de vitórias dentro do vetor.
        vetor[0] = baseTab[0][0] + baseTab[0][1] + baseTab[0][2];
        vetor[1] = baseTab[1][0] + baseTab[1][1] + baseTab[1][2];
        vetor[2] = baseTab[2][0] + baseTab[2][1] + baseTab[2][2];

        vetor[3] = baseTab[0][0] + baseTab[1][0] + baseTab[2][0];
        vetor[4] = baseTab[0][1] + baseTab[1][1] + baseTab[2][1];
        vetor[5] = baseTab[0][2] + baseTab[1][2] + baseTab[2][2];

        vetor[6] = baseTab[0][0] + baseTab[1][1] + baseTab[2][2];
        vetor[7] = baseTab[0][2] + baseTab[1][1] + baseTab[2][0];

        //Percorrendo o vetor.
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals("XXX")) { //Se o vetor na posição em que o "for" está for igual a XXX, então o jogador venceu.
                resultado = "Jogador";  //Atribuindo "Jogador" para a variável resultado.

            } else if (vetor[i].equals("OOO")) {    //Se o vetor na posição "i" do "for" for igual a OOO, o vencedor será o PC.
                resultado = "Computador";   //Atribuindo "Computador" para a variável resultado.

            }
        }

        return resultado;   //Retornando o resultado para o metodo "win".
    }
}
