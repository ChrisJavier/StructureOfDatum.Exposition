import java.util.Random;
import java.util.Scanner;

public class Application {
	
	public static SLinkedDouble ListDouble= new SLinkedDouble();
	static String Productos[]={"fideos","arroz","azucar","atun","jugo","mazanas","jabon","shampoo","crema","cepillo dental","pasta","aceite","carne","pescado"};
	public static Random rdm= new Random();
	public static void main(String[] args)
	{
		int op=0;
		Scanner scann=new Scanner(System.in);
		int dato,cont=0;
		
		
		
		System.out.println("*****************************Lista De Productos**************************");
		do{
		
			System.out.println("\n[1]-> Añadir Productos\n[2]-> Comprar Producto\n[3]-> Buscar Producto\n[4]-> Imprimir Lista\n[5]-> Ordenar Lista\n[0]-> Salir\nElija una opcion---->");
			op=scann.nextInt();
			switch(op){
			case 1:
				if(cont<=Productos.length-1){
					ListDouble.addNode(Productos[cont]);
					System.out.println("******Producto aniadido******");
					cont++;
				}else{
					System.out.println("Ya no hay mas productos");
				}
				break;
			case 2:
				System.out.println("Ingrese el indice de un producto ->");
				op=scann.nextInt();
				System.out.println("Ingrese una cantidad para producto ->");
				dato=scann.nextInt();
				ListDouble.Comprar(op,dato);
				break;
			case 3:
				
					ListDouble.Listar();
					System.out.println("Ingrese un Indice ->");
					dato=scann.nextInt();
					System.out.println("El producto en la posicion: "+dato+ " contiene  "+(ListDouble.Searchs(dato)!=null ? (" el producto :  "+ListDouble.Searchs(dato)+(ListDouble.Searchind(dato).getCantidad()!=0 ? "  y Ha sido comprado":" y esta Disponible para su compra")):"Ningun dato"));
				break;
			case 4:
				ListDouble.Listar();
				break;
                        case 5:
                                ListDouble.InsertionOrg();
			
			}
		}while(op!=0);
	}
	}
	
