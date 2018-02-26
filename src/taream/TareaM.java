/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taream;

/**
 *
 * @author admin
 */



import java.util.Scanner;

public class TareaM {
	private static Scanner teclado = new Scanner(System.in);	
	//Variables usuarios
	static String[] usuarios = new String[5];
	//Variables Digitos
	static int contDig = 1, numero;
	//Variables mayor a menor
	static int mayor, medio, menor;
	//Variables promedio
	static int[][] notas = new int[6][6];
	
	public static void main(String[] args) {
		for(int i = 0; i < 6; i++){ //For usado para declarar los ID de cada estudiante en prommedio
			notas[0][i] = i+1;
		}
		Menu(); //Llamada al método menu()
	}
	
	static void Menu(){ //Método menu, donde el usuario podrá elegir la opción que desee
		System.out.println("[IPC1]Tarea3_201708850\n");
		System.out.println("1. Usuarios");
		System.out.println("2. Contador de Digitos");
		System.out.println("3. Tres numeros de mayor a menor");
		System.out.println("4. Calcular promedio");
		System.out.println("5. Salir");
		switch(IngresoNum()){ //Switch usado para que se lleve a la opción que eligió el usuaio.
			case 1:
				Usuarios(); //Así se llama a los métodos de java.
				break;
			case 2:
				contadorDigitos(); //así se llama a los métodos de java.
				break;
			case 3:
				mayorAMenor();
				break;
			case 4:
				promedio();
				break;
		
                                case 5:
				System.exit(0); //Método predeterminado de Java para cerrar la aplicación.
				break;
                        default:
				System.out.println("No es una opción válida."); // Si el usuario no ingresa opciones válidas, se regresará al menú.
				Menu();
				break;
		}
	}
	
	static int IngresoNum(){ //Método para elegir una opción en los siguientes métodos.
		return teclado.nextInt();
	}
	
	static void Usuarios(){
		System.out.println("1. Ingresar usuarios");
		System.out.println("2. Mostrar usuarios ascendente");
		System.out.println("3. Mostrar usuarios descendente");
		System.out.println("4. Menu");
		
		switch(IngresoNum()){
			case 1: //Se ingresan los usuarios
				System.out.println("Ingrese los usuarios");
				teclado.nextLine();
				int a=0;
                                for(int i = 0; i < 5; i++){ //for utilizado para ingresar los usuarios al array usuarios.
					System.out.println("Ingrese el usuario " + (i+1)+ ":");
					usuarios[i] = teclado.nextLine();
				 //for utilizado para ingresar los usuarios al array usuarios.
				if(a>0){
                                for(int g=i;g>=0;g--){
                                    
                   if(g==0){}else{
while((usuarios[i]).equals(usuarios[g-1])){	
                                    System.out.println("Ingrese el usuario " + (i+1)+ " nuevamente:"); //Se hace la comprobación de que el usuario no exista
                                                                                                        //en el array
					usuarios[i] = teclado.nextLine();
}
                   
                   }
                                }
                                }
                                a=5;
                                }
                                
				ordenUsuarios(); //Se llama al método ordenusuarios, de esta manera cuando se de el case 2 y 3 los nombres ya tendrán 
				Usuarios();      //una posición númerica en el array, según su orden alfabético.
				break;
			case 2:
				for(int i = 0; i < 5; i++){ //Se imprimen los usuarios de manera ascendente.
					System.out.println(usuarios[i]);
				}
				Usuarios();
				break;
			case 3:
				for(int i = 4; i > -1; i--){ //Se imprimen los usuarios de manera descendente.
					System.out.println(usuarios[i]);
				}
				Usuarios();
				break;
			case 4:
				Menu();
				break;
			default:
				System.out.println("No es una opción válida.");
				Usuarios();
				break;
		}
	}
	
	static void ordenUsuarios(){ //Método utilzado para ordenar los usuarios por medio de la comparacion, tras comparar se asigna un valor mayor o
                                        //menor a la cadena en el array.
		  for(int j=0;j<4;j++) {
	             for(int i=0;i<4-j;i++) {
	                 if (usuarios[i].compareTo(usuarios[i+1])>0) {
	                     String aux;
	                     aux=usuarios[i];
	                     usuarios[i]=usuarios[i+1];
	                     usuarios[i+1]=aux;
	                 }
	             }
	         }
	}
	
	static void contadorDigitos(){ //Método para el contador de dígitos, aca se encuentran todos los proceso para contar los dígitos.
		System.out.println("1. Ingresar numero");
		System.out.println("2. Mostrar numero de digitos");
		System.out.println("3. Menu principal");
		
		
		switch(IngresoNum()){
			case 1: //Se ingresa el número al que se contaran los digitos.
				System.out.println("Ingrese el numero a comprobar: ");
				numero = IngresoNum();
				
				if((numero > 100000)|| (numero < 0)){
					System.out.println("No es una opción válida.");
				}else{
					while(numero >= 10){
						contDig++;
						numero /= 10;
					}
				}
				contadorDigitos(); //se llama al método para volver al menu.
				break;
			case 2:
				System.out.println("El numero tiene " + contDig + " digitos.");
				contadorDigitos();
				break;
			case 3:
				Menu();
				break;
			default:
				System.out.println("No es una opción válida.");
				contadorDigitos();
				break;
		}
	}
	
	static void mayorAMenor(){ //Método para ordenar 3 números de mayor a menor.
		System.out.println("1. Ingresar numeros");
		System.out.println("2. Mostrar ordenados");
		System.out.println("3. Menu principal");
		
		
		switch(IngresoNum()){ //Opción para ingresar los números
			case 1:
				System.out.println("Ingrese el primer numero: ");
				mayor = IngresoNum();
				System.out.println("Ingrese el segundo numero: ");
				medio = IngresoNum();
				if(medio > mayor){ //se ordenan los números dependiendo de los valores ingresados
					menor = mayor;
					mayor = medio;
				}else{
					menor = medio;
				}
				System.out.println("Ingrese el tercer numero: "); //Se agrega el tercer número y se compara con los otros dos valores
				medio = IngresoNum();                               //para ordenarlos de mayor a menor
				if(medio > mayor){
					int aux = mayor;
					mayor = medio;
					medio = aux;
				}else if(menor > medio){
					int aux = menor;
					menor = medio;
					medio = aux;
				}
				
				mayorAMenor(); //Se regresa al menú.
				break;
			case 2: //se imprimen los números ya ordenados.
				System.out.println("Los numeros ordenados de mayor a menor son: ");
				System.out.println(mayor + "\n" + medio + "\n" + menor);
				mayorAMenor();
				break;
			case 3:
				Menu();
				break;
			default:
				System.out.println("No es una opción válida.");
				mayorAMenor();
				break;
		}
	}

	static void promedio(){ //metodo para el promedio de 6 estudiantes
		int aux;
		for(int i = 0; i < 6; i++){ //se ingresan las 4 notas de cada estudiante, este for es para indicar de que estudiante son las notas
			System.out.println("Ingrese las notas del alumno no. " + (i+1));
			aux = 0;
			for(int j = 1; j < 5; j++){ //aca se ingresa la nota
				System.out.println("nota no. " + j);
				notas[j][i] = IngresoNum();
				aux += notas[j][i]; // se usa la variable aux para guardar las notas totales del estudiante.
			}
			notas[5][i] = aux/4; // se guarda el promedio de las notas en la ulitma columna de la matriz.
		}
		for(int i = 0; i < 6; i++){ //tras ingresar todas las notas, aca se imprime la mátriz.
			for(int j = 0; j < 6; j++){
				System.out.print(notas[j][i] + " ");
			}
			System.out.println("");
		}
	}
}

    

