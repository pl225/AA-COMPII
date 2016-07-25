package view;


public enum Ocupacao {
	
	ADMINISTRATOR(0), ARTIST(1), DOCTOR(2), EDUCATOR(3), ENGINEER(4),
	ENTERTAINMENT(5), EXECUTIVE(6), HEALTHCARE(7), HOMEMAKER(8),
	LAWYER(9), LIBRARIAN(10), MARKETING(11), NONE(12), OTHER(13), PROGRAMMER(14),
	RETIRED(15), SALESMAN(16), SCIENTIST(17), STUDENT(18), TECHNICIAN(19), WRITER(20);
	
	private int valor;
	
	Ocupacao(int indice){
		this.valor = indice;		
	}
	
	public int getValor() {
		return valor;
	}	

}
