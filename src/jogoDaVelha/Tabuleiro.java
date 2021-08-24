package jogoDaVelha;

public class Tabuleiro {

    //Declarando matriz "baseTab" com 9 posi��es, cuja as mesmas, est�o sendo atribu�das n�meros de 1 a 9.
    //A matriz � do tipo String.
    public String[][] baseTab = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

    //Vari�veis
    private int dificuldade = 0;    //Var para definir a dificuldade.

    //Getters e Setters
    public int getDificuldade() {   //Get para retornar a dificuldade.   
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {   //Set para acessar na vari�vel e atribuir a ela algum valor.
        this.dificuldade = dificuldade;
    }

    //M�todo para mostrar o tabuleiro.
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

    //M�todo com parametros de posi��o e s�mbolo escolhido.
    public void jogada(String posicao, String simbolo) {

        //Condicionais para atribuir o s�mbolo nas posi��es escolhidas.
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

    //M�todo para validar a posi��o digitada, se a mesma estiver ocupada, retornar� false, se n�o, true.
    public boolean validar(String posicao) { //Verificador de posi��o.
        for (int linha = 0; linha < baseTab.length; linha++) {
            for (int coluna = 0; coluna < baseTab.length; coluna++) {
                if (baseTab[linha][coluna].equals(posicao)) {
                    return true;    //Se for igual a posi��o, ent�o retornar� true.
                }
            }
        }
        return false;   //Se estiver ocupada, retornar� false.
    }

    //M�todo para verificar o Vencedor.
    public String win(int jogada) {
        String[] vetor = new String[8]; //Declarando um vetor de 8 posi��es, pois existem 8 possibilidades de vit�ria.
        String resultado = "null";  //Inicializando a vari�vel resultado.

        if (jogada == 9) {  //Se tiver 9 jogadas, ent�o resultar� em empate.
            resultado = "Empate";   //Atribuindo "Empate" para a vari�vel resultado.
        }

        //Concatenando os s�mbolos das poss�veis posi��es de vit�rias dentro do vetor.
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
            if (vetor[i].equals("XXX")) { //Se o vetor na posi��o em que o "for" est� for igual a XXX, ent�o o jogador venceu.
                resultado = "Jogador";  //Atribuindo "Jogador" para a vari�vel resultado.

            } else if (vetor[i].equals("OOO")) {    //Se o vetor na posi��o "i" do "for" for igual a OOO, o vencedor ser� o PC.
                resultado = "Computador";   //Atribuindo "Computador" para a vari�vel resultado.

            }
        }

        return resultado;   //Retornando o resultado para o metodo "win".
    }
}
