package projetoJogoDaVelha;

import java.util.Scanner;

public class jogoDaVelha{

	//método de verificação de vitória
	static boolean Venceu(String matriz[][]) { 
		return  (matriz[0][0]).equals(matriz[0][1]) && (matriz[0][0]).equals(matriz[0][2]) ||
				(matriz[1][0]).equals(matriz[1][1]) && (matriz[1][0]).equals(matriz[1][2]) ||
				(matriz[2][0]).equals(matriz[2][1]) && (matriz[2][0]).equals(matriz[2][2]) ||
				(matriz[0][0]).equals(matriz[1][0]) && (matriz[0][0]).equals(matriz[2][0]) ||
				(matriz[0][1]).equals(matriz[1][1]) && (matriz[0][1]).equals(matriz[2][1]) ||
				(matriz[0][2]).equals(matriz[1][2]) && (matriz[0][2]).equals(matriz[2][2]) ||
				(matriz[0][0]).equals(matriz[1][1]) && (matriz[0][0]).equals(matriz[2][2]) ||
				(matriz[0][2]).equals(matriz[1][1]) && (matriz[0][2]).equals(matriz[2][0]);
	}
	
	//método mostrar
	public static void Mostrar(String matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print("["+ matriz[i][j]+"]");
    		}
			System.out.println("");
		}
	}
	
	//método main
	public static void main(String[] args) {
		
		//declaração de variáveis
		int x = 1, opc, cont, partida = 0;
		String[] nomes = new String[2];
		String[] caractere = new String[2];
		
		//declaração da matriz já preenchida
		String[][] matriz = {{ "1", "2", "3"},{ "4", "5", "6"},{"7", "8", "9"}}; 
		
		//instanciação do Scanner
		Scanner ler = new Scanner(System.in);

		//impresão do cabeçalho
		System.out.println("##################################");
		System.out.println("~Bem vindo ao nosso jogo da Velha~");
		System.out.println("##################################");
		  
		//captura do nome dos players e atribuição a vetor
		for(x=0;x<nomes.length;x++) {
		System.out.println("Digite o nome do "+(x+1)+"° jogador: ");
		nomes[x] = ler.next();
		}
		
		//captura caractere do player 1
		System.out.println(nomes[0]+", você gostaria de usar X ou O para preencher?");
		caractere[0] = ler.next();
		
		//informa caractere do player 2
		if(caractere[0].equals("X")) {
			caractere[1] = "O";
			System.out.println(nomes[1]+" você usará o caractere O");
		}
		else {
			caractere[1] = "X";
			System.out.println(nomes[1]+" você usará o caractere X");
		}
		
		//primeira exibição da matriz
		Mostrar(matriz);
		
		//Execução das partidas
	    do {
	    
	    //execução das jogadas
	    	System.out.println(nomes[partida%2] +" digite qual posição deseja:");
			opc = ler.nextInt();
	    
		//zera o contador responsavel por identificar a posição
	    cont = 0;
	    
	    //varre a matriz ate contador ser igual a posição(opc)
		for(int l = 0; l<3; l++ ) {
			for(int c = 0; c<3; c++ ) {
				cont++;
				
				//verifica se posição é igual a contador
				if(opc == cont) {
					//verifica se a posição já está preenchida 
					if(matriz[l][c] == "X" || matriz[l][c] == "O"){
						System.out.println("já foi escolhido");
					}
					//atribui valor a posições vazias
					else {
						matriz[l][c]  = caractere[partida%2];
						partida++;
						
					}
				}
			}
		}
		
		//imprime a matriz após cada alteração
		Mostrar(matriz);
		
		//encerra o laço
	    }while(partida<9 && !Venceu(matriz)); 
	    
	    //encerramento do Scanner
	    ler.close();
	    
	    //imprime o resultado
	    if(partida == 9) {
	    	System.out.println("\nDeu velha!");
	    }
	    else {
	    	System.out.println("\nO vencedor foi: "+nomes[(partida-1)%2]);
	    }
	}
}
