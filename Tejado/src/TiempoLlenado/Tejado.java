package TiempoLlenado;

public class Tejado {
public static void main(String[] args){
		
		float baseC,longT,areaCanal,anchoT,angulo,
		areaT,radio,altura,VolumenTanque,x,areaTanque,Tiempo,
		areaTotal,VolumenLluvia;
		boolean validar=false;
		
		
		for(int i=0;i<args.length; i++) {
			if(Float.parseFloat(args[i])<0) {
				validar=true;
			}
		}
		if(validar!=true) {
		baseC=Float.parseFloat(args[0]);
			longT=Float.parseFloat(args[1]);
			anchoT=Float.parseFloat(args[2]);
			angulo=Float.parseFloat(args[3]);
			radio=Float.parseFloat(args[4]);
			altura=Float.parseFloat(args[5]);
			x=Float.parseFloat(args[6]);
			
			VolumenTanque=(float) (Math.PI*Math.pow(radio, 2)*altura);
			areaT=(float) (longT*(anchoT*Math.cos(angulo)));
			areaCanal=baseC*longT;
			areaTanque=VolumenTanque/100;
			areaTotal=areaT+areaCanal+areaTanque;
			VolumenLluvia=areaTotal*x;
			
			Tiempo=VolumenTanque*1000000/VolumenLluvia*3600;
			
			System.out.println(Tiempo);
		}
		else {
			System.out.println("El numero es menor que cero");
		}
	}
	

}
