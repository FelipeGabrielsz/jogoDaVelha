package jogoDaVelha;

public class Jogador {

    private String simboloEscolhido;    //Var para o s�mbolo escolhido pelo jogador.
    private String posicao;     //Var para a posi��o escolhida do jogador.

    public String getSimboloEscolhido() {   //M�todo get para acessar e retornar a var Simbolo.
        return simboloEscolhido;
    }

    public void setSimboloEscolhido(String simboloEscolhido) {  //M�todo set para definir o Simbolo escolhido.
        this.simboloEscolhido = simboloEscolhido;
    }

    public String getPosicao() {    //M�todo get para acessar e retornar a var posi��o.
        return posicao;
    }

    public void setPosicao(String posicao) {    //M�todo set para definir a posi��o escolhida.
        this.posicao = posicao;
    }

}
