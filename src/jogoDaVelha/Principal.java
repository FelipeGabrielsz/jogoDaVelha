package jogoDaVelha;

import java.util.Scanner;   //Importando o Scanner para obter dados do usu�rios.
import java.util.Random;    //Importando o Random para n�meros aleat�rios.

									//Felipe Gabriel da Silva Souza - RU: 3350216

public class Principal {    //In�cio da classe.

    public static void main(String[] args) {    //In�cio do main.

        //Inst�ncias
        Random gerador = new Random();  //Importando o "random de senha".
        Scanner ler = new Scanner(System.in);   //Importando o Scanner, para obter dados do usu�rio.
        Tabuleiro tab = new Tabuleiro();    //Importando a classe tabuleiro.
        Jogador jg = new Jogador();     //Importando a classe jogador.
        Computador pc = new Computador();   //Importando a classe computador.
        ComputadorA pcA = new ComputadorA();    //Importando a classe extends ComputadorA.
        ComputadorB pcB = new ComputadorB();    //Importando a classe extends ComputadorB.
        ComputadorC pcC = new ComputadorC();    //Importando a classe extends ComputadorC.

        //Declara��es de vari�veis.
        int verificar = 0;  //Controle dos whiles.
        int numJogadas = 0; //Controle dos n�meros de jogada.

        //Informando ao usu�rio as instru��es.
        System.out.println("---------------------INSTRU��ES---------------------");
        System.out.println("As posi��es est�o sendo ocupadas por n�meros. ");
        System.out.println("Escolha um n�mero para sua respectiva posi��o.");
        System.out.println("----------------------------------------------------");

        //In�cio do while para controle do jogo.
        while (true) {
            //Informando o usu�rio as dificuldades.
            System.out.println("Escolha a dificuldade do jogo: \n1 para F�cil \n2 para Normal \n3 para Dif�cil");
            tab.setDificuldade(ler.nextInt());  //Lendo a dificuldade.

            //Condicionais para verificar a dificuldade.
            if (tab.getDificuldade() == 1) {
                System.out.printf("\nDificuldade '%d' definida! ", tab.getDificuldade());  //Retornando a dificuldade definida.
                pcA.contagem = 9;   //Caso 1, f�cil, setando "9" na contagem, para ser decrementado.
                break;  //Parando o loop
            } else if (tab.getDificuldade() == 2) {
                System.out.printf("\nDificuldade '%d' definida! ", tab.getDificuldade());  //Retornando a dificuldade definida.
                pcB.contagem = 1;   //Caso 2, normal, setando "1" na contagem, para ser acrescentado.
                break;  //Parando o loop.
            } else if (tab.getDificuldade() == 3) {
                System.out.printf("\nDificuldade '%d' definida! ", tab.getDificuldade());  //Retornando a dificuldade definida.
                pcC.posicaoRandom = 0;  //Caso 3, dif�cil, ir� ser atribu�do "0" na var random.
                break;  //Parando o loop.
            } else {    //Caso o usu�rio n�o digitar nenhuma das op��es acima, ser� apresentado uma mensagem o informando e voltar� ao loop.
                System.out.println("Comando n�o reconhecido! ");
                System.out.println("Tente novamente...");
                continue;   // Usando o "continue" para retornar ao loop.
            }

        }
        System.out.println("\n\n"); //Pulando linha.

        //Mostrando o tabuleiro atualizado.
        tab.mostrar();
        System.out.println();   //Pulando mais uma linha.

        while (true) {
            System.out.println("Vez do computador");    //Informando que � a vez do computador.
            pc.setSimbolo("O");  //Atribuindo o s�mbolo de "O" para o computador.

            if (tab.getDificuldade() == 1) {    //Se a dificuldade for 1 (F�cil), a var do pcC "random" ser� reaproveitada e atribu�da para a mesma a decrementa��o.

                pcC.posicaoRandom = pcA.contagem--; //Decrementa��o e atribui��o.

            } else if (tab.getDificuldade() == 2) { //Se a dificuldade for 2 (normal), a var  do pcC, "random", ser� reaproveitada atribuindo 1 a cada rodada.
                pcB.contagem++; //Var inicializada na classe extends ComputadorB, que � "filha" da classe Computador.                      
                pcC.posicaoRandom = pcB.contagem;   //Atribuindo para a var random da pcC.

            } else if (tab.getDificuldade() == 3) { //Se a dificuldade for 3 (Dif�cil), ir� ser atribu�do algum n�mero aleat�rio.
                pcC.posicaoRandom = gerador.nextInt(9) + 1; //O " (9) + 1 " serve para contar a partir do 1.
            }

            //----------------------------------Computador----------------------------------------
            do {    //Entrando no "do While" para primeiro ele executar o loop, e apenas depois, validar.

                //While para validar a posi��o, se a mesma tiver ocupada, ele ficar� repetindo at� atingir alguma que esteja vaga.
                // Integer.toString() para converter uma var int para String.
                while (tab.validar(Integer.toString(pcC.posicaoRandom)) == false) { //Se retornar false, ficar� no loop.

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

                    verificar = 0;  //Atribuindo " 0 " para a var que ir� controlar o "do while".
                }

                //Atribuindo o s�mbolo e a posi��o para o computador.
                tab.jogada(Integer.toString(pcC.posicaoRandom), pc.getSimbolo());
                pcA.contagem = 9;   //Resetando a var de contagem de posi��es do Computador A.
                pcB.contagem = 1;   //Resetando a var de contagem de posi��es do Computador A.
                verificar = 1;  //Var controladora sendo atribu�da o n�mero 1 para sair do loop.

            } while (verificar == 0);   //Enquanto a var "verificar" for 0, ele repetir�

            numJogadas++;   //Atribuindo os n�meros de jogadas, se atiginr 9, dar� empate.
            verificar = 0;  //Resetando a var verificar.
            tab.mostrar();

            //Condicional para verificar o ganhador.
            if (!tab.win(numJogadas).equals("null")) {    //Se for diferente de null, encerrar� o loop (jogo).
                break;  //Break para parar o while.
            }

            //----------------------------------Jogador----------------------------------------
            jg.setPosicao(""); //Zerando a posi��o que o jogador ir� escolher.

            do {    //Entrando no "do While" para primeiro ele inicar o loop e depois validar as condi��es.

                System.out.println("Digite uma posi��o: "); //Pedindo ao usu�rio uma posi��o.
                jg.setPosicao(ler.next());  //Lendo a posi��o e atribuindo a mesma diretamente no m�todo setPosicao.

                while (tab.validar(jg.getPosicao()) == false) { //Validando a posi��o, caso retornar false, ir� pedir novamente.
                    System.out.println("Jogada inv�lida, tente novamente! ");

                    System.out.println("Jogador, informe uma posi��o: ");
                    jg.setPosicao(ler.next());  //Atribuindo novamente essa posi��o.

                    verificar = 0;  //Resetando a vari�vel controladora.
                }

                jg.setSimboloEscolhido("X");  //Atribuindo o s�mbolo de "X" para o jogador.

                tab.jogada(jg.getPosicao(), jg.getSimboloEscolhido());   //Acessando o m�todo que ir� colocar o s�mbolo na posi��o.
                verificar = 1;  //Var controladora sendo atribu�da o n�mero 1 para sair do loop.

            } while (verificar == 0);   //Enquanto a var verificar for 0, ele repetir�.

            numJogadas++;   //Acrescentando mais 1 para o n�mero de rodadas.
            verificar = 0;  //Zerando a var verificar.
            tab.mostrar();  //Mostrando o tabuleiro atualizado.

            //Condicional para verificar o ganhador.
            if (!tab.win(numJogadas).equals("null")) {  //Se for diferente de null, encerrar� o loop (jogo).
                break;  //Break para parar o while.
            }

        } //Fim do While.

        if (tab.win(numJogadas).equals("Empate")) { //Verificando, se o m�todo "win" retornar "Empate, mostrar� Empate como resultado.
            System.out.println("Empate");   //Informando o usu�rio que deu empate.
        } else {    //Caso n�o retornar empate, ele mostrar� o vencedor.
            System.out.println("O " + tab.win(numJogadas) + " venceu! ");   //Informando o vencedor.
        }

    }   //Fim do main.
}   //fim da classe.
