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
				Usuarios();
				break;
			case 2:
				contadorDigitos();
				break;
			case 3:
				mayorAMenor();
				break;
			case 4:
				promedio();
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
				System.out.println("Ingrese el tercer numero: ");
				medio = IngresoNum();
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

    

