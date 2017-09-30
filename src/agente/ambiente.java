package agente;

import java.util.Random;

public class ambiente {
	public boolean existe = true;
	public int nrlinhas= 10;
	public int nrcolunas = 10;
	private int[][] tabuleiro = new int[nrlinhas][nrcolunas];
	tela tela;
	
	public ambiente(tela tela) {
		this.tela = tela;
		Random gerador = new Random();
		int nrobstaculos = 10;
		for (int i=0;i<nrlinhas;i++) {
			for (int j=0;j<nrcolunas;j++) {
				tabuleiro[i][j] = gerador.nextInt(2);
			}
		}
		//monta os obstaculos
		while(nrobstaculos>0) {
			int x = gerador.nextInt(10);
			int y = gerador.nextInt(10);
			tabuleiro[x][y] = 2;
			nrobstaculos --;
		}
	}
	
	public boolean existepedra() {
		for (int i=0;i<nrlinhas;i++) {
			for (int j=0;j<nrcolunas;j++) {
				if (tabuleiro[i][j] == 1) {
					this.existe = true;
					return true;
				}
			}
		}
		this.existe = false;
	return false;
	}
	
	public void remove(int linha,int coluna) {
		tabuleiro[linha][coluna] = 0;
	}
	
	public int tipo(int linha,int coluna) {
		return tabuleiro[linha][coluna];
	}
	
	public void desenha(int linhaagente,int colunaagente, int linhanave, int colunanave) {
		//Tipo de 
		//0 = local livre
		//1 = pedra
		//2 = obstáculo
		//3 = Agente
		//4 = Nave
		
		int [][] tabela = new int[nrlinhas][nrcolunas];  
		for (int i=0; i < nrlinhas; i++) {
			for (int j=0; j < nrcolunas; j++){
				tabela[i][j]=tabuleiro[i][j]; 
			}
		}
		tabela[linhaagente][colunaagente]= 4;
		tabela[linhanave][colunanave]= 5;
			
		try {
			this.tela.desenhar(tabela);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
