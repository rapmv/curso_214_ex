package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import entities.Candidato;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//pega o caminho do arquivo a ler lido
		System.out.print("Digite o caminho do arquivo: ");
		String arquivo = sc.nextLine();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))){
			
			//HashMap = ordenado alfabeticamente. Map declarado de acordo com a classe
			Map<String, Integer> eleicao = new HashMap<>();
			
			//leitura da primeira linha do arquivo
			String line = br.readLine();
			
			//enquanto tiver linhas no arquivo ele ira repetir
			while(line!=null) {
				
				//quebra linha em vetor em que cada pedaço e add numa posicao, sendo delimitado pela ","
				String[] fields = line.split(",");
				String nome = fields[0];
				
				//transformado a string num int
				int votos = Integer.parseInt(fields[1]);
				
				//verifica se existe a chave, nesse caso se existir eu vou somar o valor antigo com o novo
				//quem faz a verificação para ver se contem o elemento e o containsKey
				if(eleicao.containsKey(nome)) {	
					
					//o get nesse caso ele recupera o elemento
					int votosMais = eleicao.get(nome);
					//adiciona
					eleicao.put(nome, votos + votosMais);
				}
				else {
					eleicao.put(nome, votos);
				}	
				line = br.readLine();
			}
			
			//for para leitura do map
			for(String chave: eleicao.keySet()) {
				System.out.println(chave + ": " +eleicao.get(chave));
			}
			
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
