package view;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Arquivo {
    
        void ordena_bolha(ArrayList<Genero> generos)
{
        
	int i,j;
	Genero temp;
	for (i = 0; i < generos.size(); i++)
	{
		for (j = 1; j < generos.size()-i; j++)
			if (generos.get(j-1).getNumeroUsuarioAssistiram() > generos.get(j).getNumeroUsuarioAssistiram())
			{
				temp = generos.get(j-1);
				generos.set(j-1, generos.get(j));
				generos.set(j, temp);
			}
	}

}
	
	public FileReader abreArquivoUsuarioFilme () throws FileNotFoundException {
		FileReader fr = new FileReader ("u.data.txt");
		return fr;
	}
	
	public FileReader abreArquivoUsuario () throws FileNotFoundException {
		FileReader fr = new FileReader ("u.user.txt");
		return fr;
	}
	
	public FileReader abreArquivoFilme() throws FileNotFoundException{
		
		FileReader fr = new FileReader("u.item.txt");		
		return fr;			
		
	}
        
        public FileReader abreArquivoAdmin() throws FileNotFoundException{
		
		FileReader fr = new FileReader("admin.txt");		
		return fr;			
		
	}
        
        public ArrayList<Administrador> leArquivoAdmin () {
		ArrayList<Administrador> admins = new ArrayList<Administrador>();
		try {
			
			FileReader fr = this.abreArquivoAdmin();
			Scanner scan = new Scanner (fr).useDelimiter("\\||\\n");
			String nick;
			String senha;

			while (scan.hasNext()) {
				
				Administrador a = new Administrador();
                                nick = scan.next();
				senha = scan.next();                               
				a.setNickName(nick);
                                a.setSenha(senha);
                                admins.add(a);
				
			}
			scan.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.toString());
		}
		return admins;
	}
        
	public ArrayList<UsuarioFilme> lerArquivoUsuarioFilme () {
		ArrayList<UsuarioFilme> usuarios = new ArrayList<UsuarioFilme>();
		try {
			
			FileReader fr = this.abreArquivoUsuarioFilme();
			Scanner scan = new Scanner (fr);
			String userid;
			String itemid;
			String rating;
			String timestamp;
			int i=0;
			while (scan.hasNext()) {
				
				UsuarioFilme uf = new UsuarioFilme();
				userid = scan.next();
				itemid = scan.next();
				rating = scan.next();
				timestamp = scan.next();
				uf.getUsuario().setIdUsuario(Integer.parseInt(userid));
				uf.getFilme().setIdFilme(Integer.parseInt(itemid));
				uf.setNota(Integer.parseInt(rating));
				uf.getData().setTimeInMillis(Long.parseLong(timestamp));
				usuarios.add(uf);
				
			}
			scan.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.toString());
		}
		return usuarios;
	}
	
	public ArrayList<Usuario> leArquivoUsuario () {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			
			FileReader fr = this.abreArquivoUsuario();
			Scanner scan = new Scanner (fr).useDelimiter("\\||\\n");
			String id;
			String idade;
			String sexo;
			String ocupacao;
			String senha;
			String avaliou;
			int i=0;
			while (scan.hasNext()) {
				
				Usuario u = new Usuario();
				id = scan.next();
				idade = scan.next();
				sexo = scan.next();
				ocupacao = scan.next();
				senha = scan.next();
                                avaliou = scan.next();
				
				u.setIdUsuario(Integer.parseInt(id));
				u.setIdade(Integer.parseInt(idade));
				u.setSexo(sexo.charAt(0));
				u.setOcupacao(Ocupacao.valueOf(ocupacao.toUpperCase()));
				u.setSenha(senha);
				if (avaliou.contains("true")) {
                                    u.setAvaliou(true);
                                } else {
                                    u.setAvaliou(false);
                                }
				usuarios.add(u);
				
			}
			scan.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.toString());
		}
		return usuarios;
	}
	
	public ArrayList<Filme> lerArquivoFilme(){
		
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		try{
			
			FileReader fr = this.abreArquivoFilme();
			Scanner scan = new Scanner (fr).useDelimiter("\\||\\n");
			String movieId;
			String movieTitle;
			String dataLancamento;
			String urlIMDB;
			Filme f ;
			ArrayList<Genero> g ;
			
			while (scan.hasNext()) {
				f = new Filme();
				g = new ArrayList<Genero>();
				movieId = scan.next();
				movieTitle = scan.next();
				dataLancamento = scan.next();
				scan.next();
				urlIMDB = scan.next();
				for (int i=0;i<19;i++) {
					if (scan.next().equals("1")) {
						g.add(Genero.values()[i]);
					}
				}
				f.setIdFilme(Integer.parseInt(movieId));
				f.setTitulo(movieTitle);
				f.setDataLancamento(dataLancamento);
				f.setUrlIMDB(urlIMDB);
				f.setGeneros(g);
				filmes.add(f);
			}
		}
		
		catch(FileNotFoundException fnfe){
			System.out.println(fnfe.toString());
		}
				
		return filmes;
		
	}
        
        public static void adicionaNoArquivoUser(Usuario u) {
            
            String linha;
            linha = u.getIdUsuario()+"|"+u.getIdade()+"|"+u.getSexo()+"|"+u.getOcupacao().toString()+"|"+u.getSenha()+"|"+u.isAvaliou();
            try {
                BufferedWriter bf;
                bf = new BufferedWriter(new FileWriter("u.user.txt", true));
                bf.write(linha);
                bf.newLine();
                bf.close();
            } catch (IOException e) {
                System.out.println("Arquivo não encontrado!");
            }          
        }
        
        public static void adcionaNoArquivoUsuarioFilme (UsuarioFilme uf) {
            String linha;
            linha = uf.getUsuario().getIdUsuario()+" "+uf.getFilme().getIdFilme()+" "+uf.getNota()+" "+uf.getData().getTimeInMillis();
            try {
                
                BufferedWriter bf;
                bf = new BufferedWriter(new FileWriter("u.data.txt", true));
                bf.write(linha);
                bf.newLine();
                bf.close();
            } catch (IOException e) {
                System.out.println("Arquivo não encontrado!");
            }
        }
        
        public static void reescreveArquivoUsuario (ArrayList<Usuario> usuario) throws IOException {
            String linha;
            BufferedWriter bf;
            bf = new BufferedWriter(new FileWriter("u.user.txt", false));
            for (int i=0;i<usuario.size();i++) {
                 try {
                    linha = usuario.get(i).getIdUsuario()+"|"+usuario.get(i).getIdade()+"|"+usuario.get(i).getSexo()+"|"+usuario.get(i).getOcupacao().toString()+"|"+usuario.get(i).getSenha()+"|"+usuario.get(i).isAvaliou();
                    bf.write(linha);
                    bf.newLine();
                 
                } catch (IOException e) {
                    System.out.println("Arquivo não encontrado!");
                }
            }
            bf.close();			
        }
        
        public static void reescreveArquivoUsuarioFilme (ArrayList<UsuarioFilme> uf) throws IOException {
            String linha;
            BufferedWriter bf;
            bf = new BufferedWriter(new FileWriter("u.data.txt", false));
            for (int i=0;i<uf.size();i++) {
                 try {
                    linha = uf.get(i).getUsuario().getIdUsuario()+" "+uf.get(i).getFilme().getIdFilme()+" "+uf.get(i).getNota()+" "+uf.get(i).getData().getTimeInMillis();
                    bf.write(linha);
                    bf.newLine();
                   
                } catch (IOException e) {
                    System.out.println("Arquivo não encontrado!");
                }
            }
            bf.close();
        }
        
        public ArrayList<Filme> exibeListaDeFilmesAssistida (Usuario u) {
            ArrayList<UsuarioFilme> uf = this.lerArquivoUsuarioFilme();
            ArrayList<Filme> filmesAssistidos = new ArrayList<Filme>();
            ArrayList<Filme> todosFilmes = this.lerArquivoFilme();
            int indice;
            
            for (int i=0;i<uf.size();i++) {
                if (u.getIdUsuario()==uf.get(i).getUsuario().getIdUsuario()) {
                    indice = Collections.binarySearch(todosFilmes, uf.get(i).getFilme());
                    filmesAssistidos.add(todosFilmes.get(indice));
                }
            }
            
            return filmesAssistidos;
        }
        
        public ArrayList<Filme> filmesMaisVotados() {
            
            ArrayList <Filme> filmesMaisVotados = new ArrayList<Filme>();
            ArrayList <Filme> todosFilmes = this.lerArquivoFilme();
            ArrayList <UsuarioFilme> registroFilmes = this.lerArquivoUsuarioFilme();
            int indiceFilmeAtual;
            
            for (int i=0;i<registroFilmes.size();i++) {
                indiceFilmeAtual = Collections.binarySearch(todosFilmes, registroFilmes.get(i).getFilme());
                todosFilmes.get(indiceFilmeAtual).somaUsuario();
                todosFilmes.get(indiceFilmeAtual).somaClassificacao(registroFilmes.get(i).getNota());
            }
            
            for (int i=0;i<todosFilmes.size();i++) {
                todosFilmes.get(i).calculaNotaFinal();
            }
            
            Collections.sort(todosFilmes, new ComparatorFilme());
            
            for (int i=0;i<10;i++) {
                filmesMaisVotados.add(todosFilmes.get(i));
            }
            
            Collections.sort(filmesMaisVotados, new ComparatorFilmeFinal());
            
            return filmesMaisVotados;
        }
        
        public ArrayList<Filme> sugerirFilmes (Usuario u) {
            ArrayList<Filme> filmesAssistidos  = this.exibeListaDeFilmesAssistida(u);
            ArrayList<UsuarioFilme> uff = this.lerArquivoUsuarioFilme();
            
            if (filmesAssistidos.size()==0) {
                return null;
            }
            
            double mediaGeral=0;
            
            for (UsuarioFilme uf:uff) {
                mediaGeral+=uf.getNota();
            }
            
            mediaGeral/=uff.size();
            
            ArrayList<Genero> generos = new ArrayList<Genero>();
            for (Genero g:Genero.values()) {
                generos.add(g);
            }
            
            for (Filme f:filmesAssistidos) {
                for (Genero g:f.getGeneros()) {
                    generos.get(g.getValor()).somaUsuario();
                }
            }
            
            this.ordena_bolha(generos);
            
            ArrayList<Filme> filmes = this.lerArquivoFilme();
            
            int indiceFilmeAtual;
            
            for (int i=0;i<uff.size();i++) {
                indiceFilmeAtual = Collections.binarySearch(filmes, uff.get(i).getFilme());
                filmes.get(indiceFilmeAtual).somaUsuario();
                filmes.get(indiceFilmeAtual).somaClassificacao(uff.get(i).getNota());
            }
            
            for (int i=0;i<filmes.size();i++) {
                filmes.get(i).calculaNotaFinal();
            }
            
            ArrayList<Filme> filmesRecomendados = new ArrayList<Filme>();
            
            for (Filme f:filmes) {
                for (Genero g:f.getGeneros()) {
                    if (generos.get(g.getValor()).getNumeroUsuarioAssistiram()>0) {
                        if (f.getNotaFinal()>4) {
                            filmesRecomendados.add(f);
                            break;
                        }
                    }
                }
            }
            
            return filmesRecomendados;
        }

}