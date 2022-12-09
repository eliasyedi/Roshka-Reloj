

public class Reloj{
	private int hora;
	private int minutos;
	private int segundos;



	public Reloj(){
		this.hora = 12;
		this.minutos = 0;
		this.segundos = 0;
	}


	public Reloj(int h , int m , int s){
		this.hora = h;
		this.minutos = m;
		this.segundos = s;
	}

	public Reloj(int segundosTrans){

		this.hora = segundosTrans/3600;
		segundosTrans -= this.hora*3600;
		this.minutos = segundosTrans/60;
		segundosTrans -= this.minutos*60;
		this.segundos = segundosTrans;

	}


	// **comprobar si los segundos indican mas de un dia ** por simplicidad nunca pasa de un dia
	public void setReloj(int segundosTrans){
		this.hora = segundosTrans/3600;
		segundosTrans -= this.hora*3600;
		this.minutos = segundosTrans/60;
		segundosTrans -= this.minutos*60;
		this.segundos = segundosTrans;		
	}


	public int getHora(){
		return this.hora;
	}

	public int getMinutos(){
		return this.minutos;
	}

	public int getSegundos(){
		return this.segundos;
	}


	public boolean setHora(int h){
		if(!inRange(h, 0 , 0))
			return false;
		this.hora = h;
		return true;
	}


	public boolean setMinutos(int m){
		if(!inRange(0, m , 0))
			return false;
		this.minutos = m;
		return true;
	}


	public boolean setSegundos(int s){
		if(!inRange(0 , 0 , s))
			return false;
		this.segundos = s;
		return true;
	}


	public void tick(){

		this.segundos ++;
		if(this.segundos>59){
			this.minutos ++;
			this.segundos=0;
			if(this.minutos>59){
				this.hora ++;
				this.minutos = 0;
				if(this.hora>23){
					this.hora = 0;
				}
			}
		}

	}


	public void addReloj(Reloj horaNueva){
		if(horaNueva == this)
			return;

		this.hora = horaNueva.getHora();
		this.minutos = horaNueva.getMinutos();
		this.segundos = horaNueva.getSegundos();
	}

	public String toString(){
		return String.format("[%02d:%02d:%02d]", this.hora , this.minutos , this.segundos);
	}



	public void tickDecrement(){

		this.segundos--;
		if(this.segundos<0){
			this.minutos --;
			this.segundos=59;
			if(this.minutos<0){
				this.hora --;
				this.minutos = 59;
				if(this.hora<0){
					this.hora = 23;
				}
			}
		}

	}




	public String restaReloj(Reloj aRestar){
		if(aRestar == this)
			return null;


		int horaAux = Math.abs((this.hora - aRestar.getHora()));
		int minutosAux = Math.abs((this.minutos - aRestar.getMinutos()));
		int segundosAux = Math.abs((this.segundos - aRestar.getSegundos()));

		return String.format("[%02d:%02d:%02d]", horaAux , minutosAux , segundosAux);
	}
	


	private boolean inRange(int h , int m, int s){

		if(h>24 || h<0)
			return false;
		if(m>60 || m<0)
			return false;
		if(s>59 || s<0)
			return false;

		return true;

	}
}