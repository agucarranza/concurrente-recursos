package tareas;

public class T1 extends Tarea {

	public T1() {
	}

	public void run() {
		while (true) {		
			
			
			Tarea.y1 = Tarea.y2 + 1;
			
			Tarea.cantidad +=1;
			
			
			while ((!(Tarea.y2 == 0) && !(Tarea.y1 <= Tarea.y2))) {
				// try {
				// 	Thread.sleep(0);
				// } catch (InterruptedException e) {
				// 	// TODO Auto-generated catch block
				// 	e.printStackTrace();
				// }
					
				}

			Tarea.critical++;	
			Tarea.critical--;
			
			Tarea.y1 = 0;

					
			if (Tarea.critical != 0){
				System.out.println("--------Valor CRITICAL desde T1 = " + (Tarea.critical));
				System.out.println("--------Valor Y1 desde T1 = " + (Tarea.y1));
				System.out.println("--------Valor Y2 desde T1 = " + (Tarea.y2));
			}
			// System.out.println("Cantidad"+(Tarea.cantidad));
			
		}		
	}

}







//System.out.println("------");
//9		int i = 0;
// 12 Tarea.y1 += Tarea.y2 + 1;
// 13 //System.out.println("Desde 1 Valor de Y1"+Tarea.y1+" Valor de
// Y2"+Tarea.y2);
// 16 // while (!((y2 == 0) || (y1 <= y2))) {}
// 22 Tarea.critical = Tarea.critical + 1;
// 23 Tarea.critical = Tarea.critical - 1;
// 27 // }
// 28 // System.out.println("Valor de Y1 = " + (Tarea.y1));
// 31 // System.out.println("ssssssssssssssss");
// 35 // public static Tarea creo(){
// 36 // return new T1();
// 37 // }

//System.out.println("Desde 1 valor de i " + i++);
//System.out.println("Desde 1 Valor de Y1" + Tarea.y1 + " Valor de Y2" + Tarea.y2);
