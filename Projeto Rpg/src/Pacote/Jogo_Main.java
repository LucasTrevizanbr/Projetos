package Pacote;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class Jogo_Main {
	public static void main(String args[]) 
	{   String nome;
		int num;
		Scanner ler = new Scanner(System.in);
		Personagens character = new Heroi();
		Personagens inimigod = new MonstrosDg1();
		Batalha batlle= new Batalha(character, inimigod);
        
		System.out.println("Insira o tipo do seu personagem de 1 a 5");
		num = ler.nextInt();
		character.setTipo(num);
		System.out.println(character.getTipo());
		System.out.println("Insira seu nome: ");
		nome= ler.next();
		character.setNome(nome);
		batlle.iniciarBatalha();
		 
		
		}
		
		
	
}
