package Pacote;

import java.util.concurrent.TimeUnit;

public class Dungeon{
	Personagens inimigoD1 []= new MonstrosDg1[2];
	Personagens inimigoD2[]= new MonstrosDg2[2];
	Boss boss1 = new Boss("Florestoso");
	Boss boss2 = new Boss("x");
	Boss boss3 = new Boss("x");
	Personagens principal;
	
	
	public Dungeon(Personagens heroi) {
		principal = heroi;
		
	}
	
	public void sorteiaBatalhaDg1() throws InterruptedException {
		for(int i=0; i<2;i++) {
			inimigoD1[i] = new MonstrosDg1();
			Batalha batlle= new Batalha(principal,inimigoD1[i]);
			batlle.iniciarBatalha();
			if(i==0) {
				System.out.println("***************************************************************************************************");
				System.out.println();
				System.out.println("Uau, isso foi dificil, mas agora estamos um passo mais perto, eu posso sentir....");
			    System.out.println();
			    System.out.println("***************************************************************************************************");
			}
			if(i==1) {
				System.out.println("***************************************************************************************************");
				System.out.println();
				System.out.println("EI, O QUE É AQUILO, CUIDADO, PARECE SER MAIS PERIGOSO DO QUE TUDO QUE ENFRENTAMOS ATÉ AGORA!!!!");
		        System.out.println();
		        System.out.println("***************************************************************************************************");
			}
			TimeUnit.SECONDS.sleep(3);	
		}
	}
		
		public void sorteiaBatalhaDg2() throws InterruptedException {
			for(int i=0; i<2;i++) {
				inimigoD2[i] = new MonstrosDg2();
				Batalha batlle= new Batalha(principal,inimigoD2[i]);
				batlle.iniciarBatalha();
				if(i==0) {
					System.out.println("***************************************************************************************************");
					System.out.println();
					System.out.println("Uau, isso foi dificil, mas agora estamos um passo mais perto, eu posso sentir....");
				    System.out.println();
				    System.out.println("***************************************************************************************************");
				}
				if(i==1) {
					System.out.println("***************************************************************************************************");
					System.out.println();
					System.out.println("EI, O QUE É AQUILO, CUIDADO, PARECE SER MAIS PERIGOSO DO QUE TUDO QUE ENFRENTAMOS ATÉ AGORA!!!!");
			        System.out.println();
			        System.out.println("***************************************************************************************************");
				}
				TimeUnit.SECONDS.sleep(3);	
			}	
	}
	
	  public void curaPrincipal() {
		  System.out.println("Ei, você esta machucado, come isso\n VIDA RESTAURADA!!!!!");
		  principal.setVida(200);
	  }

      public void chamaBoss1() throws InterruptedException {
    	  boss1.constroiBoss1();
    	  System.out.println();
    	  System.out.println("Você veio até aqui só para pegar isso? esse maldito artefato? INÚTIL");
    	  System.out.println();
    	  TimeUnit.SECONDS.sleep(3);
    	  Batalha batlle= new Batalha(principal,boss1);
    	  batlle.iniciarBatalha();
    	  TimeUnit.SECONDS.sleep(3);
    	  System.out.println();
    	  System.out.println("Você conseguiu, mas eu disse, isso não muda nada, NADA!!!");
    	  System.out.println();
      }
      public void chamaBoss2() throws InterruptedException {
    	  boss2.constroiBoss2();
    	  System.out.println();
    	  System.out.println("pré conversa");
    	  System.out.println();
    	  TimeUnit.SECONDS.sleep(3);	
    	  Batalha batlle= new Batalha(principal,boss2);
    	  TimeUnit.SECONDS.sleep(3);
    	  System.out.println();
    	  System.out.println("frase de derrota");
    	  System.out.println();
      }
      public void chamaBoss3() throws InterruptedException {
    	  boss3.constroiBoss3();
    	  System.out.println();
    	  System.out.println("pré conversa");
    	  System.out.println();
    	  TimeUnit.SECONDS.sleep(3);	
    	  Batalha batlle= new Batalha(principal,boss3);
    	  TimeUnit.SECONDS.sleep(3);
    	  System.out.println();
    	  System.out.println("frase de derrota");
    	  System.out.println();
      }








}
