package Pacote;

import java.util.concurrent.TimeUnit;
import java.util.*;

public class Historia {
     Personagens principal = new Heroi();
     
     public Historia(Personagens heroi) {
    	 principal = heroi;
    	 
     }
 Scanner ler = new Scanner(System.in);	
     
     
     
     public int pular() {
    	 int opc;
    	 System.out.println("Deseja pular história?\n1 para sim\n2 para não");
    	 opc = ler.nextInt();
    	 return opc;	 
     }
     
     
     public void introHistoria() throws InterruptedException {
		System.out.println(principal.getNome()+" Você precisa me ajudar, a muito tempo atrás antes mesmo do tempo sequer existir nosso destino ja havia sido traçado");
		TimeUnit.SECONDS.sleep(4);
		System.out.println("Nosso mundo esta preso em um loop infinito, por incontáveis eras a humanidade repete o ciclo de se auto degradar e destruir");
		TimeUnit.SECONDS.sleep(4);
		System.out.println("No início vivemos pacificamente com os elementos e a natureza, porém a ganancia da humanidade nos leva a um caminho destrutivo");
		TimeUnit.SECONDS.sleep(4);
		System.out.println("Então quando chegamos no ápice da destruição do nosso planeta, o tempo simplesmente reseta. "+principal.getNome()
		+" ,somente nos dois podemos quebrar esse ciclo e salvar a humanidade");
		TimeUnit.SECONDS.sleep(4);
		System.out.println("A propósito meu nome é Ícari, e eu consigo viajar pelo tempo, de algum modo eu sei que nós podemos encontrar respostas no passado, VAMOS");
		TimeUnit.SECONDS.sleep(4);
		System.out.println();
		System.out.println("Chegamos, estamos em algum lugar do tempo quando o mundo ainda era jovem, ali, naquela floresta tem algo que pode nos ajudar");
		System.out.println();
	}
     
}
