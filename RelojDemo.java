

public class RelojDemo{


	public static void main(String[] args) {
		Reloj hora1 = new Reloj();
		Reloj hora2 = new Reloj(10 , 20 , 30);

		System.out.println("hora1: " + hora1);
		System.out.println("hora: " + hora1.getHora());
		System.out.println("minutos: " + hora1.getMinutos());
		System.out.println("segundos: " + hora1.getSegundos());

		hora1.setHora(10);
		hora1.setMinutos(45);
		hora1.setSegundos(30);
		System.out.println("hora1: " + hora1);


		System.out.println("hora2: " + hora2);
		hora1.addReloj(hora2);
		System.out.println("hora1 despue1s de addReloj: " + hora1);

		hora2.tickDecrement();
		System.out.println("hora2 despues de tickdecrement" + hora2);

		hora2.tick();
		System.out.println("hora2 despues de tick()" + hora2);

		
		System.out.println("restaReloj(): " + hora1.restaReloj(hora2));
		System.out.println(hora1.verHoras());
	}
}