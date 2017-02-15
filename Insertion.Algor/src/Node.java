public class Node {
 Node adelante;
 Node atras;
 int Cantidad;
 int Disponibles;
 String Name;
 
 public Node(int entrada){
	 
	 this.Cantidad=entrada;
	 this.adelante=atras=null;
	 
 }

 public Node (Node adelante_, Node atras_, int dato, int Disponible_, String Name_)
 {
	 this.adelante=adelante_;
	 this.atras=atras_;
	 this.Cantidad=dato;
	 this.Name=Name_;
	 this.Disponibles=Disponible_;
 }
 public int getDisponibles() {
	return Disponibles;
}

public void setDisponibles(int disponibles) {
	Disponibles = disponibles;
}

public Node ()
 {
	 this.adelante=null;
	 this.atras=null;
	 this.Cantidad=0;
	 this.Name=null;
 }
public Node getNext() {
	return adelante;
}


public void setNext(Node adelante) {
	this.adelante = adelante;
}


public Node getNextLast() {
	return atras;
}


public void setNextLast(Node atras) {
	this.atras = atras;
}


public int getCantidad() {
	return Cantidad;
}


public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public void setCantidad(int dato) {
	this.Cantidad = dato;
}



}