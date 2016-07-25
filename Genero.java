package view;

/**
 *
 * @author seccim
 */
public enum Genero {
	
	UNKNOWN(0), ACTION(1), ADVENTURE(2), ANIMATION(3),
	CHILDREN(4), COMEDY(5), CRIME(6), DOCUMENTARY(7),
	DRAMA(8), FANTASY(9), FILM_NOIR(10), HORROR(11),
	MUSICAL(12), MYSTERY(13), ROMANCE(14), SCI_FI(15),
	THRILLER(16), WAR(17), WESTERN(18);
	
	private int valor;
        private int numeroUsuariosAssistiram;
        
        public void somaUsuario() {
            this.numeroUsuariosAssistiram++;
        }
        
        public int getNumeroUsuarioAssistiram () {
            return this.numeroUsuariosAssistiram;
        }
	
	Genero(int numero){
		
		this.valor = numero;
		
	}

	public int getValor() {
		return valor;
	}
	
	


}
