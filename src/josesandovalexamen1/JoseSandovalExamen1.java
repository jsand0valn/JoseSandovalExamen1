package josesandovalexamen1;

import java.util.Scanner;

public class JoseSandovalExamen1 {

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("Digite una opcion");
            System.out.println("1- Ingresar Datos del Cliente");
            System.out.println("2- Estadisticas de Ventas");
            System.out.println("3- Salir del Programa");
            System.out.print("Digite su opcion: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    JoseSandovalExamen1.NuevaVenta();
                    break;
                case 2:
                    JoseSandovalExamen1.mostrarEstadisticas();
                    break;
                case 3:
                    System.out.println("Usted salio del Programa");
                    break;

                default:
                    System.out.println("Favor digite una opcion del menu valida");
            }
        } while (opcion != 3);
    }

    static Scanner leer = new Scanner(System.in);//PARA QUE EL PROGRAMA LEA LO DIGITADO POR EL USUARIO

    static String[] localidades = {"Sol Norte/Sur", "Sombra Este/Oeste", "Preferencial"};//LISTA DE LOCALIDADES
    static int[] precios = {10500, 20500, 25500};//LISTA DE LOCALIDADES
    static int[] cantidades = new int[10];//CANTIDAD MAXIMA 
    static int[] acumuladorDinero = new int[10];//CANTIDAD DE DINERO ACUMULADO
    private static int indice;

    public static void NuevaVenta() {//METODO PARA NUEVA VENTA DE ENTRADAS

        char continuar = 'n';// n es un NO
        do {
            if (indice > 10) {
                System.out.println("Lista esta llena");
                continuar = 'n';
            }

            System.out.print("Ingrese el numero de factura: ");
            int numFactura = leer.nextInt();//LEE EL NUMERO INGRESADO DE LA FACTURA

            System.out.print("Ingrese la cedula del cliente: ");
            String cedula = leer.next();//LEE EL NUMERO DE CEDULA INGRESADO DE LA FACTURA

            System.out.print("Ingrese el nombre del cliente: ");
            String nombre = leer.next();//LEE EL NOMBRE INGRESADO DEL CLIENTE

            System.out.println("Ingrese la localidad deseada:");
            for (int i = 0; i < localidades.length; i++) {//CICLO FOR PARA DETECTAR LAS LOCALIDADES 
                System.out.println((i + 1) + "- " + localidades[i]);
            }
            int opcion = leer.nextInt();//LEE LA OPCION INGRESADA POR EL USUARIO
            int indiceLocalidad = opcion - 1;//REDUCE LA OPCION A MENOS 1 PARA ALMACENAR EL INDICE DE LA LOCALIDAD

            System.out.print("Ingrese la cantidad de entradas (maximo 4): ");
            int cantidad = leer.nextInt();//LEE LA CANTIDAD DE ENTRADAS SOLICITADAS POR EL USUARIO

            if (cantidad < 1 || cantidad > 4) {//IF PARA VALIDAR QUE LAS ENTRADAS SEAN EN UN RANGO MAYOR A UNO PERO MENOR QUE 4
                System.out.println("Error: cantidad inválida");
                return;//FINALIZA LA VALIDACION DE CANTIDAD DE ENTRADAS 
            }

            int precioEntrada = precios[indiceLocalidad];//VARIABLE PARA ASOCIAR EL PRECIO DE LA ENTRADA CON LA LOCALIDAD
            int subtotal = cantidad * precioEntrada;//VARIABLE QUE ALMACENA EL SUBTOTAL DEL MONTO
            int cargosServicios = cantidad * 1000;//VARIABLE QUE MULTIPLICA LA CANTIDAD DE ENTRADAS POR EL CARGO POR SERVICIOS
            int totalPagar = subtotal + cargosServicios;//ALMACENA EL TOTAL A PAGAR POR EL CLIENTE 

            cantidades[indiceLocalidad] += cantidad;//REALIZA LA OPERACION DE SUMAR LA CANTIDAD DE ENTRADAS VENDIDAS POR LOCALIDAD
            acumuladorDinero[indiceLocalidad] += subtotal;//REALIZA LA OPERACION DE ACUMULAR EL DINERO REACAUDADO POR LOCALIDAD

            System.out.println("Numero de Factura: " + numFactura);
            System.out.println("Cedula: " + cedula);
            System.out.println("Nombre cliente: " + nombre);
            System.out.println("Localidad: " + localidades[indiceLocalidad]);
            System.out.println("Cantidad de Entradas: " + cantidad);
            System.out.println("Subtotal: " + subtotal);
            System.out.println("Cargos por Servicios: " + cargosServicios);
            System.out.println("Total a pagar: " + totalPagar);
            indice++;
            System.out.println("Desea ingresar otro cliente?  Si (s) No (n)");
            continuar = leer.next().charAt(0); //CONVIERTE UN STRING A CHAR
            
        } while (continuar != 'n');
    }

    public static void mostrarEstadisticas() {//METODO PARA MOSTRAR ESTADISTICAS DE VENTAS DE ENTRADAS

        for (int i = 0; i < localidades.length; i++) {
            System.out.println("Cantidad Entradas Localidad " + localidades[i] + ": " + cantidades[i]);
            System.out.println("Acumulado Dinero Localidad " + localidades[i] + ": " + acumuladorDinero[i]);
        }
    }

}
