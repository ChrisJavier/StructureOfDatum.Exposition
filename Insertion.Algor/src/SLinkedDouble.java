import java.util.Random;

public class SLinkedDouble {
	
	protected int size=0;
	
	protected Node header, trailer;
	
	public SLinkedDouble()
	{
		size=0;
		header= new Node(null, null,0,0,null);
		trailer= new Node(null, null, 0,0,null);
		header.setNext(trailer);
	}

	public void addNode(String Name){
		
		Node New =  new Node(null,null,0,0,null);
		Node Last = new Node(null,null,0,0,null);
		Random rmd= new Random();
		if(IsEmpty()){
			New.setName(Name);
			New.setDisponibles(rmd.nextInt(10));
			header=New;
		}else{
			Node Aux=header;
			while(Aux.getNext()!=null){
				Aux=Aux.getNext();
			}
			if(size>=2){
				New.setName(Name);
				New.setDisponibles(rmd.nextInt(10));
				New.setNextLast(Aux);
				Aux.setNext(New);
				trailer=New;
			}else{
				Last=trailer;
				Last.setName(Name);
				New.setDisponibles(rmd.nextInt(10));
				Last.setNextLast(Aux);
				Aux.setNext(trailer);
				
			}	
		}
		size++;
			
	}
	public int Size(){return size;}
	
	public boolean IsEmpty(){return (size==0);}
	
	public Node getFirst() throws IllegalStateException {
		if(IsEmpty()) throw new IllegalStateException("La lista esta vacia");
		return header.getNext();
	}
	
	public Node getLast() throws IllegalStateException{
		if(IsEmpty()) throw new IllegalStateException("La lista esta vacia");
		return trailer.getNextLast();
	}
	
	public Node getPrev(Node v) throws IllegalStateException{
		if(v==header) throw new IllegalStateException("no se puede mover mas alla de Atras de la lista");
		return v.getNextLast();
	}
	
	public void addBefore(Node v, Node z) throws IllegalStateException{
		Node u= v.getNextLast();
		z.setNextLast(u);
		z.setNext(v);
		v.setNextLast(z);
		u.setNext(z);
		size++;
	}
	public void addAfter(Node v, Node z){
		Node w=v.getNext();
		z.setNextLast(v);
		z.setNext(w);
		w.setNextLast(z);
		v.setNext(z);
		size++;
	}
	public void addFirst(Node v){
		addAfter(header, v);
	}
	public void addLast(Node v){
		addBefore(trailer, v);
	}
	
	public boolean Search1(int Ci){
		 Boolean encontrado= null;
		 Node aux=header;
		while(aux !=null && encontrado!=true){
			
			if(aux.getCantidad()==Ci){
				encontrado=true;
				return encontrado;
				}else{
				aux=aux.getNext();
				}
		}
			return false;
	}
	public void AddFirst(int dato){
		
		if(IsEmpty())
			System.out.println("La Lista esta vacia");
		
		Node Aux=header;
		Node New= new Node (null, null,0,0,null);
		
		New.setCantidad(dato);
		New.setNext(Aux);
		Aux.setNextLast(New);
		header=New;
		size++;
		
	}
	
public void AddLast(int dato){
		
		if(IsEmpty())
			System.out.println("La Lista esta vacia");
		
		Node Aux=trailer;
		Node New= new Node (null, null,0,0,null);
		
		New.setCantidad(dato);
		New.setNextLast(Aux);
		Aux.setNext(New);
		trailer=New;
		
		size++;
	}
	public Node Search(int Ci){
		Node aux= new Node(null,null,0,0,null);
		Node Find=new Node(null,null,0,0,null);
		boolean encontrado=false;
		aux= header;
		while(aux !=null && encontrado!=true){
		
			if(aux.getCantidad()==Ci){
				Find=aux;
				encontrado=true;
				return Find;
				}else{
				aux=aux.getNext();
				}
		}
			return null;
		}
	public Node Searchind(int ind){
		Node aux= new Node(null,null,0,0,null);
		Node Find=new Node(null,null,0,0,null);
		aux= header;
		for(int i=0;i<size;i++){
		
			if(i==ind){
				Find=aux;
				return Find;
				}else{
				aux=aux.getNext();
				}
		}
			return null;
		}
		
	public Node FirstNode(Node Ref){
		Node First= new Node (null,null,0,0,null);
		First=Ref;
		for(int i=0;i<size;i++)
		{
			if(First.getNextLast()==null)
				return First;
			First=First.getNextLast();
		}
		return null;
	}
	public String Searchs(int dato){
		Node aux= new Node(null,null,0,0,null);
		aux= header;
		if(IsEmpty()){
			System.out.println("La lista esta vacia");
			return null;
		}
		
		for(int i=0;i<size;i++){
			
			if(i==dato){
				return aux.getName();
				}else{
				aux=aux.getNext();
				}
		}
			return null;
		}
	public void CleanList(){
		
		header.setNext(null);
		size=0;
		System.out.println("La Lista esta vacia");
	}
	public void Listar(){
		if(!IsEmpty()){
			Node Aux= header;
			int i=0;
			System.out.println("*********************Productos Comprados**************************");
			System.out.println("#Producto" +"  "+"[     Disponibles   ]"+ "[      Cantidad    ]"+"[   Descripcion   ]");
			while(i!=size){
				if(Aux.getCantidad()!=0){
					System.out.println(i +"-> "+"                  [ "+Aux.getDisponibles()+" ]" +"                  [ "+Aux.getCantidad()+" ]"+"        [ "+Aux.getName()+" ]"+"     Listo!!!");	
				}			
			Aux= Aux.getNext();
			i++;
			}
			i=0;
			Aux= header;
			System.out.println("*********************Productos Disponibles para la compra**************************");
			System.out.println("#Producto" +"  "+"[     Disponibles   ]"+ "[      Cantidad    ]"+"[   Descripcion   ]");
			while(i!=size){
				if(Aux.getCantidad()==0){
					System.out.println(i +"-> "+"                  [ "+Aux.getDisponibles()+" ]" +"                  [ "+Aux.getCantidad()+" ]"+"        [ "+Aux.getName()+" ]");	
					}			
			Aux= Aux.getNext();
			i++;
			}
		}}
	public void ListarAtras()
	{
		if(!IsEmpty()){
			Node Aux= trailer;
			int i=0;
			while(i!=size){
				System.out.println((size-i-1) +"-> "+ "["+Aux.getCantidad()+"]");
			Aux= Aux.getNextLast();
			i++;
			}
	}
	}
	
	public int SearchI(int dato)
	{
		Node Aux= new Node(null,null,0,0,null);
		Aux=header;
	
		if(IsEmpty()){
			System.out.println("La Lista esta vacia");
			return -1;
		}
			for(int i=0; i<size;i++){
				if(Aux.getCantidad()==dato){
					return i;}
				Aux= Aux.getNext();
			}
			return -1;
	}
	public void InsertNewElementPerRefBefore(int dato,int ref){
		
		Node New= new Node(null,null,0,0,null);
		Node Aux=header;
		Node Aux1=new Node(null,null,0,0,null);
		
		for(int i=0;i<size;i++)
			if(Aux.getCantidad()==ref){
				New.setCantidad(dato);
				New.setNextLast(Aux.getNextLast());
				New.setNext(Aux);
				Aux1.setNext(New);
				Aux.setNextLast(New);
				size++;
				return;
			}else{
				Aux1=Aux;
				Aux=Aux.getNext();
				
			}
				
	}
	public void InsertNewElementPerRefLast(int dato,int ref){
		
		Node New= new Node(null,null,0,0,null);
		Node Aux=header;
		
		for(int i=0;i<size;i++)
			if(Aux.getCantidad()==ref){
				New.setCantidad(dato);
				New.setNext(Aux.getNext());
				New.setNextLast(Aux);
				Aux.getNext().setNextLast(New);
				Aux.setNext(New);
				size++;
				return;
			}else{

				Aux=Aux.getNext();
				
			}
				
	}
	
	public void InsertionOrg(){
		
		Node Aux= new Node(null,null,0,0,null);
		Node Aux1= new Node(null,null,0,0,null);
		Node Aux2= new Node(null,null,0,0,null);
		Node Aux3= new Node(null,null,0,0,null);
		 int j;
	      Aux= header.getNext();
		 for (int i = 1; i < size; i++) {
				Aux2= new Node(null,null,0,0,null);
				Aux3= new Node(null,null,0,0,null);
				Aux1=Searchind(i-1);
		     for (j = i - 1; j >=0 &&  Aux.getName().compareToIgnoreCase(Aux1.getName())< 0; j--){
		      
		    	 Aux2=Aux1;
		    	 Aux1=Aux;
		    	 Aux=Aux2;
		    	 
		    	 Aux3.setNext(Aux.getNext());
		    	 Aux3.setNextLast(Aux.getNextLast());
		    	 
		    	 Aux.setNext(Aux1.getNext());
		    	 Aux.setNextLast(Aux1);
		    	 if(j>0)
		    	 (Aux.getNext()).setNextLast(Aux);
		    	 Aux1.setNext(Aux);
		    	 Aux1.setNextLast(Aux3.getNextLast());
		    	 if(j>0)
		    	 (Aux1.getNextLast()).setNext(Aux1);
		    	 //if(Aux1.getNextLast()==null)
		    		// header=Aux1;
		    	 header=FirstNode(Aux1);
		     }
		     Aux=Aux.getNext();
		 }
	
		}
	
	public void EditNode(int dato, int ref)
	{
		Node Aux=Search(ref);
		Aux.setCantidad(dato);
	}
	public void Comprar(int op , int cantidad){
		
		Node aux=Searchind(op);
		if(aux.getDisponibles()>=cantidad)
		{
			aux.setCantidad(cantidad);
		System.out.println("Articulo Comprado");
		}else{
			System.out.println("Sobrepasa la cantidad disponible");	
		}
		}
	public void Remove(int dato){
		
		Node aux= Search(dato);
		
		if(aux==null)
			System.out.println("no existe el dato");
		if(aux.getCantidad()==header.getCantidad()){
			header=header.getNext();
			aux.setNext(null);
			aux.setNextLast(null);
			size--;
			System.out.println("El elemento ha sido elimindado");
			return;
		}else if(aux==trailer){
			trailer=trailer.getNextLast();
			aux.setNextLast(null);
			aux.setNext(null);
			System.out.println("El elemento ha sido elimindado");
			size--;
			return;
		}else {
			Node Aux1= new Node(null,null,0,0,null);
			Node Aux2= new Node(null,null,0,0,null);
			Aux1=aux.getNextLast();
			Aux2=aux.getNext();
			aux.setNext(null);
			aux.setNextLast(null);
			Aux2.setNextLast(Aux1);
			Aux1.setNext(Aux2);
			size--;
		}
	
	}
	}