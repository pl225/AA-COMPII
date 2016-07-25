package view;

public class Usuario implements Comparable<Usuario>{
	
	private int idUsuario;
	private int idade;
	private char sexo;
	private Ocupacao ocupacao;
	private String senha;
    private boolean avaliou;
	
	public boolean isAvaliou() {
		return avaliou;
	}

	public void setAvaliou(boolean avaliou) {
		this.avaliou = avaliou;
	}

	public Usuario(int idUsuario, int idade, char sexo, Ocupacao ocupacao, String senha, boolean avaliou) {
		this.idUsuario = idUsuario;
		this.idade = idade;
		this.sexo = sexo;
		this.ocupacao = ocupacao;
		this.senha = senha;
                this.avaliou = avaliou;
	}
	
	public Usuario(){
		
	}
        
        public Usuario (int idUsuario) {
            this.idUsuario = idUsuario;
        }
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public Ocupacao getOcupacao() {
		return ocupacao;
	}
	public void setOcupacao(Ocupacao ocupacao) {
		this.ocupacao = ocupacao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

    @Override
    public int compareTo(Usuario o) {
        return Integer.compare(this.idUsuario, o.idUsuario);
    }

}