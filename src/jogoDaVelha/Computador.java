package jogoDaVelha;

import java.util.Random;

public class Computador {

    Random gerador = new Random();  //Instanciando o "Random" para gerar uma posição aleatória.
    private String simbolo; //Declarando a var simbolo.

    //Declarando a var "posição" e atribuindo uma posição aleatória.
    public int posicao = gerador.nextInt(9) + 1;    //Gerando números de 1 a 9.

    public String getSimbolo() {    //Acessando e retornando a var "símbolo".
        return simbolo; //
    }

    public void setSimbolo(String simbolo) {    //Acessando e atribuindo o símbolo para a var "símbolo".
        this.simbolo = simbolo;
    }

}
