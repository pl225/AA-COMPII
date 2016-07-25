package view;

import java.util.ArrayList;
import java.util.Calendar;

public class Filme implements Comparable<Filme>{
	
	private int idFilme;
	private String titulo;
	private String dataLancamento;
	private String urlIMDB;
	private ArrayList<Genero> generos;
        private int totalUsuarios;
        private double somaClassificacao;
        private double notaFinal;
	
	public Filme() {

	}
        
        public Filme (int idFilme) {
            this.idFilme = idFilme;
        }

	public Filme(int idFilme, String titulo, String dataLancamento, String urlIMDB, ArrayList<Genero> generos) {
		this.idFilme = idFilme;
		this.titulo = titulo;
		this.dataLancamento = dataLancamento;
		this.urlIMDB = urlIMDB;
		this.generos = generos;
	}
	
	public int getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public String getUrlIMDB() {
		return urlIMDB;
	}
	public void setUrlIMDB(String urlIMDB) {
		this.urlIMDB = urlIMDB;
	}
	public ArrayList<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(ArrayList<Genero> generos) {
		this.generos = generos;
	}
        
        public int getTotalUsuarios() {
            return totalUsuarios;
        }

        public double getSomaClassificacao() {
            return somaClassificacao;
        }

        public double getNotaFinal() {
            return notaFinal;
        }
        
        public void somaUsuario () {
            this.totalUsuarios++;
        }
        
        public void somaClassificacao (double nota) {
            this.somaClassificacao += nota;
        }
        
        public void calculaNotaFinal () {
            if (this.totalUsuarios>0)
                this.notaFinal = this.somaClassificacao/this.totalUsuarios;
        }

        @Override
        public int compareTo(Filme filme) {
            return Integer.compare(this.getIdFilme(), filme.getIdFilme());
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
	
	

}
