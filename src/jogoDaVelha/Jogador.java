package jogoDaVelha;

public class Jogador {

    private String simboloEscolhido;    //Var para o símbolo escolhido pelo jogador.
    private String posicao;     //Var para a posição escolhida do jogador.

    public String getSimboloEscolhido() {   //Método get para acessar e retornar a var Simbolo.
        return simboloEscolhido;
    }

    public void setSimboloEscolhido(String simboloEscolhido) {  //Método set para definir o Simbolo escolhido.
        this.simboloEscolhido = simboloEscolhido;
    }

    public String getPosicao() {    //Método get para acessar e retornar a var posição.
        return posicao;
    }

    public void setPosicao(String posicao) {    //Método set para definir a posição escolhida.
        this.posicao = posicao;
    }

}
