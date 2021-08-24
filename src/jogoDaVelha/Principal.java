package jogoDaVelha;

import java.util.Scanner;   //Importando o Scanner para obter dados do usuários.
import java.util.Random;    //Importando o Random para números aleatórios.

									//Felipe Gabriel da Silva Souza - RU: 3350216

public class Principal {    //Início da classe.

    public static void main(String[] args) {    //Início do main.

        //Instâncias
        Random gerador = new Random();  //Importando o "random de senha".
        Scanner ler = new Scanner(System.in);   //Importando o Scanner, para obter dados do usuário.
        Tabuleiro tab = new Tabuleiro();    //Importando a classe tabuleiro.
        Jogador jg = new Jogador();     //Importando a classe jogador.
        Computador pc = new Computador();   //Importando a classe computador.
        ComputadorA pcA = new ComputadorA();    //Importando a classe extends ComputadorA.
        ComputadorB pcB = new ComputadorB();    //Importando a classe extends ComputadorB.
        ComputadorC pcC = new ComputadorC();    //Importando a classe extends ComputadorC.

        //Declarações de variáveis.
        int verificar = 0;  //Controle dos whiles.
        int numJogadas = 0; //Controle dos números de jogada.

        //Informando ao usuário as instruções.
        System.out.println("---------------------INSTRUÇÕES---------------------");
        System.out.println("As posições estão sendo ocupadas por números. ");
        System.out.println("Escolha um número para sua respectiva posição.");
        System.out.println("----------------------------------------------------");

        //Início do while para controle do jogo.
        while (true) {
            //Informando o usuário as dificuldades.
            System.out.println("Escolha a dificuldade do jogo: \n1 para Fácil \n2 para Normal \n3 para Difícil");
            tab.setDificuldade(ler.nextInt());  //Lendo a dificuldade.

            //Condicionais para verificar a dificuldade.
            if (tab.getDificuldade() == 1) {
                System.out.printf("\nDificuldade '%d' definida! ", tab.getDificuldade());  //Retornando a dificuldade definida.
                pcA.contagem = 9;   //Caso 1, fácil, setando "9" na contagem, para ser decrementado.
                break;  //Parando o loop
            } else if (tab.getDificuldade() == 2) {
                System.out.printf("\nDificuldade '%d' definida! ", tab.getDificuldade());  //Retornando a dificuldade definida.
                pcB.contagem = 1;   //Caso 2, normal, setando "1" na contagem, para ser acrescentado.
                break;  //Parando o loop.
            } else if (tab.getDificuldade() == 3) {
                System.out.printf("\nDificuldade '%d' definida! ", tab.getDificuldade());  //Retornando a dificuldade definida.
                pcC.posicaoRandom = 0;  //Caso 3, difícil, irá ser atribuído "0" na var random.
                break;  //Parando o loop.
            } else {    //Caso o usuário não digitar nenhuma das opções acima, será apresentado uma mensagem o informando e voltará ao loop.
                System.out.println("Comando não reconhecido! ");
                System.out.println("Tente novamente...");
                continue;   // Usando o "continue" para retornar ao loop.
            }

        }
        System.out.println("\n\n"); //Pulando linha.

        //Mostrando o tabuleiro atualizado.
        tab.mostrar();
        System.out.println();   //Pulando mais uma linha.

        while (true) {
            System.out.println("Vez do computador");    //Informando que é a vez do computador.
            pc.setSimbolo("O");  //Atribuindo o símbolo de "O" para o computador.

            if (tab.getDificuldade() == 1) {    //Se a dificuldade for 1 (Fácil), a var do pcC "random" será reaproveitada e atribuída para a mesma a decrementação.

                pcC.posicaoRandom = pcA.contagem--; //Decrementação e atribuição.

            } else if (tab.getDificuldade() == 2) { //Se a dificuldade for 2 (normal), a var  do pcC, "random", será reaproveitada atribuindo 1 a cada rodada.
                pcB.contagem++; //Var inicializada na classe extends ComputadorB, que é "filha" da classe Computador.                      
                pcC.posicaoRandom = pcB.contagem;   //Atribuindo para a var random da pcC.

            } else if (tab.getDificuldade() == 3) { //Se a dificuldade for 3 (Difícil), irá ser atribuído algum número aleatório.
                pcC.posicaoRandom = gerador.nextInt(9) + 1; //O " (9) + 1 " serve para contar a partir do 1.
            }

            //----------------------------------Computador----------------------------------------
            do {    //Entrando no "do While" para primeiro ele executar o loop, e apenas depois, validar.

                //While para validar a posição, se a mesma tiver ocupada, ele ficará repetindo até atingir alguma que esteja vaga.
                // Integer.toString() para converter uma var int para String.
                while (tab.validar(Integer.toString(pcC.posicaoRandom)) == false) { //Se retornar false, ficará no loop.

                    //Iniciando novamente as condicionais para setar as dificuldades.
                    if (tab.getDificuldade() == 1) {

                        pcA.contagem--;
                        pcC.posicaoRandom = pcA.contagem;
                    } else if (tab.getDificuldade() == 2) {
                        pcB.contagem++;
                        pcC.posicaoRandom = pcB.contagem;

                    } else if (tab.getDificuldade() == 3) {
                        pcC.posicaoRandom = gerador.nextInt(9) + 1;
                    }

                    verificar = 0;  //Atribuindo " 0 " para a var que irá controlar o "do while".
                }

                //Atribuindo o símbolo e a posição para o computador.
                tab.jogada(Integer.toString(pcC.posicaoRandom), pc.getSimbolo());
                pcA.contagem = 9;   //Resetando a var de contagem de posições do Computador A.
                pcB.contagem = 1;   //Resetando a var de contagem de posições do Computador A.
                verificar = 1;  //Var controladora sendo atribuída o número 1 para sair do loop.

            } while (verificar == 0);   //Enquanto a var "verificar" for 0, ele repetirá

            numJogadas++;   //Atribuindo os números de jogadas, se atiginr 9, dará empate.
            verificar = 0;  //Resetando a var verificar.
            tab.mostrar();

            //Condicional para verificar o ganhador.
            if (!tab.win(numJogadas).equals("null")) {    //Se for diferente de null, encerrará o loop (jogo).
                break;  //Break para parar o while.
            }

            //----------------------------------Jogador----------------------------------------
            jg.setPosicao(""); //Zerando a posição que o jogador irá escolher.

            do {    //Entrando no "do While" para primeiro ele inicar o loop e depois validar as condições.

                System.out.println("Digite uma posição: "); //Pedindo ao usuário uma posição.
                jg.setPosicao(ler.next());  //Lendo a posição e atribuindo a mesma diretamente no método setPosicao.

                while (tab.validar(jg.getPosicao()) == false) { //Validando a posição, caso retornar false, irá pedir novamente.
                    System.out.println("Jogada inválida, tente novamente! ");

                    System.out.println("Jogador, informe uma posição: ");
                    jg.setPosicao(ler.next());  //Atribuindo novamente essa posição.

                    verificar = 0;  //Resetando a variável controladora.
                }

                jg.setSimboloEscolhido("X");  //Atribuindo o símbolo de "X" para o jogador.

                tab.jogada(jg.getPosicao(), jg.getSimboloEscolhido());   //Acessando o método que irá colocar o símbolo na posição.
                verificar = 1;  //Var controladora sendo atribuída o número 1 para sair do loop.

            } while (verificar == 0);   //Enquanto a var verificar for 0, ele repetirá.

            numJogadas++;   //Acrescentando mais 1 para o número de rodadas.
            verificar = 0;  //Zerando a var verificar.
            tab.mostrar();  //Mostrando o tabuleiro atualizado.

            //Condicional para verificar o ganhador.
            if (!tab.win(numJogadas).equals("null")) {  //Se for diferente de null, encerrará o loop (jogo).
                break;  //Break para parar o while.
            }

        } //Fim do While.

        if (tab.win(numJogadas).equals("Empate")) { //Verificando, se o método "win" retornar "Empate, mostrará Empate como resultado.
            System.out.println("Empate");   //Informando o usuário que deu empate.
        } else {    //Caso não retornar empate, ele mostrará o vencedor.
            System.out.println("O " + tab.win(numJogadas) + " venceu! ");   //Informando o vencedor.
        }

    }   //Fim do main.
}   //fim da classe.
