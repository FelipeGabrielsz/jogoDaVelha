package jogoDaVelha;

import java.util.Random;

public class Computador {

    Random gerador = new Random();  //Instanciando o "Random" para gerar uma posi��o aleat�ria.
    private String simbolo; //Declarando a var simbolo.

    //Declarando a var "posi��o" e atribuindo uma posi��o aleat�ria.
    public int posicao = gerador.nextInt(9) + 1;    //Gerando n�meros de 1 a 9.

    public String getSimbolo() {    //Acessando e retornando a var "s�mbolo".
        return simbolo; //
    }

    public void setSimbolo(String simbolo) {    //Acessando e atribuindo o s�mbolo para a var "s�mbolo".
        this.simbolo = simbolo;
    }

}
