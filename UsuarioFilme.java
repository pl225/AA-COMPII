package view;

import java.util.Calendar;

public class UsuarioFilme implements Comparable<UsuarioFilme>{
	
	private static int idNota;
	private Usuario usuario;
	private Filme filme;
	private int nota;
	private Calendar data;
	
	public UsuarioFilme() {
		this.usuario = new Usuario();
		this.data = Calendar.getInstance();
		this.filme = new Filme();
	}

	public UsuarioFilme(Usuario usuario, Filme filme, int nota, Calendar data) {
		this.usuario = usuario;
		this.filme = filme;
		this.nota = nota;
		this.data = data;
	}
	
	public static int getIdNota() {
		return idNota;
	}
	public static void setIdNota(int idNota) {
		UsuarioFilme.idNota = idNota;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}

    @Override
    public int compareTo(UsuarioFilme o) {
        return Integer.compare(this.filme.getIdFilme(), o.getFilme().getIdFilme());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	
	

}
