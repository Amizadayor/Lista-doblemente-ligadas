import java.util.Scanner; // Importamos la libreria java.util.Scanner para facilitar la lectura de nuestros datos. //
import javax.swing.JOptionPane; // Importamos la librería javax.swing.JOptionPane que nos permitira facilitar la aparición de un cuadro de diálogo estándar que solicitara a los usuarios un valor o les informa algo. //

class Lista{ // Creamos la clase Lista. //
  private Nodo Primero, Final;
  private int pos;
  private Scanner t = new Scanner (System.in); // Declaramos la variable t como el capturador de entrada de datos. //

  public Lista (){
    Primero = null; // Creamos la funcion Primero apuntando a null. //
    Final = null;   // Creamos la funcion Final apuntando a null. //
    pos = 0;
  }
  private void mensaje(String cad){
    System.out.println (cad);
  }
  private int Leer(){
    mensaje ("-----------------------------------------------");
    mensaje ("|              INGRESE EL DATO :               "); // Mostramos un mensaje para pedir los datos a agregar. //
    mensaje ("-----------------------------------------------");
    return t.nextInt();
  }
  private boolean esVacia(){
    return Primero==null;
  }

  private void insertaPrimero(int dato){
    Nodo nuevo = new Nodo (dato);
    Primero = nuevo;
    Final = nuevo;
    pos++;
  }
  private void insertaInicio(){  // En esta sección se realizara las funciones para insertar los datos ingresados al inicio de la lista. //
    int v; // v : validación
    int dato;
      do{
          try{ // En esta parte va la validacion, en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.//
            v=0;
            dato = Leer();
            if (esVacia()) // Hacemos la comparación, si es vacia, insertamos al dato al inicio. //
            insertaPrimero(dato);
              else{
                Nodo nuevo = new Nodo (dato);
                Primero.setIzq(nuevo);
                nuevo.setDer(Primero);
                Primero = nuevo;
                pos++;
              }
            JOptionPane.showMessageDialog (null," DATO INSERTADO AL INICIO DE LA LISTA. "); // Mostramos un mensaje cuando el dato se haya insertado correctamente al inicio de la lista. //
          }catch(Exception e){
            JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando el usuario ingrese caracteres no validos //
            v=1;
            t.nextLine();
            pos--;
          }
      }while(v != 0); // Final de la validación. //
  }
  private void insertaFinal(){ // En esta sección se realizara las funciones para insertar los datos ingresados al final de la lista. //
    int v; // V: validacion. //
    int dato;
      do{
          try{  // Inicio de la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.//
            v=0;
            dato = Leer();
            if (esVacia()) // Hacemos la comparación, si es vacia, insertamos al dato al inicio. //
            insertaPrimero(dato);
              else{
                Nodo nuevo = new Nodo (dato);
                Final.setDer (nuevo);
                nuevo.setIzq (Final);
                Final = nuevo;
                pos++;
              }
            JOptionPane.showMessageDialog (null," DATO INSERTADO AL FINAL DE LA LISTA. "); // Mostramos un mensaje cuando el dato se haya insertado correctamente al final de la lista. //
          }catch(Exception e){
            JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando el usuario ingrese caracteres no validos //
            v=1;
            t.nextLine();
            pos--;
          }
      }while (v !=0); // Final de la validacion. //
  }
  private void insertaEN(){
    /*int dato;
    Nodo anterior;
    {
      Nodo nuevo;
      nuevo = new Nodo(dato);
      nuevo.adelante = anterior.adelante;
      if (anterior.adelante != null)
      anterior.adelante.atras = nuevo;
      anterior.adelante = nuevo;
      nuevo.atras = anterior;
      return;
    }*/
  }

  private void eliminaInicio(){ // En esta sección se realizara las funciones para eliminar el dato del inicio de la lista. //
    if (esVacia())
    JOptionPane.showMessageDialog (null, " LISTA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando la lista este vacia. //
      else{
        Primero = Primero.getDer();
        pos--;
        JOptionPane.showMessageDialog(null, " DATO ELIMINADO ");  // Mostramos un mensaje cunado el dato se haya eliminado correctamente. //
      }
  }
  private void eliminaFinal(){ // En esta sección se realizara las funciones para eliminar el dato del final de la lista. //
    if (esVacia())
    JOptionPane.showMessageDialog (null, " LISTA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando la lista este vacia. //
      else{
        Final = Final.getIzq();
        Final.setDer(null);
        pos--;
      }
    JOptionPane.showMessageDialog(null," DATO ELIMINADO "); // Mostramos un mensaje cunado el dato se haya eliminado correctamente. //
  }
  private void eliminaEN(){ // En esta sección se realizara las funciones para eliminar el dato de una posición en especifica. //
    int v; // v: validacion. //
    int b;
    Nodo c = Primero;
    Nodo d = null;
      do{
          try{  // Inicio de la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.//
            v=0;
            if (esVacia()) // Hacemos la comparación, si es vacia, mandamos un mensaje de error, si no, se realiza las siguientes funciones. //
            JOptionPane.showMessageDialog (null, " LISTA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando la lista este vacia. //
              else{
                mensaje (" ----------------------------------------------");
                mensaje ("|      INGRESE EL DATO QUE DESEA ELIMINAR.     "); // Mostramos un mensaje para pedir el dato que se vaya a eliminar. //
                mensaje (" ----------------------------------------------");
                b = t.nextInt();
                while (c != null && c.getInfo()!=b){
                      d = c;
                      c=c.getDer();
                }
                if (c !=null){
                    if(c==Primero){
                      Primero=c.getDer();
                    }else{
                      d.setDer(c.getDer());
                        if(c==Final){
                          Final = d;
                        }
                    }
                  JOptionPane.showMessageDialog(null," DATO ELIMINADO "); // Mostramos un mensaje cunado el dato se haya eliminado correctamente. //
                }else{
                  JOptionPane.showMessageDialog(null," DATO NO ENCONTRADO "," ERROR ",JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cunado no se haya encontrado el dato a eliminar dentro de la lista. //
                }
              }
          }catch(Exception e){
            JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando el usuario ingrese caracteres no validos //
            v=1;
            t.nextLine();
            pos--;
          }
      }while (v !=0); // final de la validacion. //
  }
  private void editar(){ // En esta sección se realizara las funciones para poder editar algun dato dentro de la lista. //
    int v; // V:validacion. //
    int p,c,d;
      do{
          try{  // Inicio de la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.//
            v=0;
            if (esVacia()) // Hacemos la comparación, si es vacia, mandamos un mensaje de error, si no, se realiza las siguientes funciones. //
            JOptionPane.showMessageDialog (null, " LISTA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando la lista este vacia. //
              else{
                mensaje (" ----------------------------------------------");
                mensaje ("|     INGRESE LA POSICION DEL DATO A EDITAR:   "); // Mostramos un mensaje para pedir la posición del dato que vaya a modificar. //
                mensaje (" ----------------------------------------------");
                p = t.nextInt();
                mensaje (" ----------------------------------------------");;
                mensaje ("|           INGRESE EL NUEVO VALOR             "); // Mostramos un mensaje para pedir el nuevo valor del dato que se va a modificar. //
                mensaje (" ----------------------------------------------");
                d = t.nextInt();
                Nodo n;
                n=Primero;
                c=1;
                  while (n!=null){
                      if (c==p){
                        n.setInfo(d);
                        JOptionPane.showMessageDialog(null, " EL DATO SE HA EDITADO "); // Mostramos un mensaje cuando el dato se haya modficado correctamente. //
                        return;
                      }
                    n=n.getDer();
                    c++;
                  }
              }
          }catch(Exception e){
            JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando el usuario ingrese caracteres no validos //
            v=1;
            t.nextLine();
            pos--;
          }
      }while (v != 0); //Final de la validacion. //
  }
  private void listadoInicio(){ // En esta sección se realizara la funcion para listar  los datos desde el inico hasta el final de la lista. //
            if (esVacia()) // Hacemos la comparacio, si nuestra lista es vacia, mostramos un mensaje de error, si no , pasamos a listar los elementos de la lista //
            JOptionPane.showMessageDialog (null, " LISTA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando nuestra lista se encuentre vacia. //
              else{
                Nodo n;
                n = Primero;
                int c = 1;
                  while (n!= null){        // n!= null: sea distinto
                    mensaje ("-----------------------------------------------");
                    mensaje ("   POSICION  ---> [" + c + "]  VALOR = " + n.getInfo());  // Mostramos la posicion y el valor de nuestro dato. //
                    mensaje ("-----------------------------------------------");
                    n = n.getDer();
                    c++;
                  }
                mensaje ("************** LISTADO TERMINADO **************"); // Mostramos un mensaje cuando el listado haya terminado. //
              }
  }
  private void listadoFinal(){ // En esta sección se realizara la funcion para listar  los datos desde el Final hasta el Inicio de la lista. //
    if (esVacia()) // Hacemos la comparacion, si la lista esta vacia, mostramos un mensaje de error. //
    JOptionPane.showMessageDialog (null, " LISTA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando nuestra lista se encuentre vacia. //
      else{
        Nodo n;
        n = Final;
        int c = 1;
          while (n!=null){
            mensaje ("-----------------------------------------------");
            mensaje ("   POSICION  ---> [" + c + "]  VALOR = " + n.getInfo()); // Mostramos la posicion y valor de los datos //
            mensaje ("-----------------------------------------------");
            n = n.getIzq();
            c++;
          }
        mensaje ("************** LISTADO TERMINADO **************"); // Mostramos un mensaje cuando el listado se haya terminado. //
      }
  }
  public void menu(){ // En esta seccion se realizara el Menu de opciones y las funciones que realizara. //
    int v; // V: validacion. //
    int op;
    do{
       try{ // Inicio de la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.//
          v=0;
            do{
              mensaje (" _____________________________________________ "); // Mostramos el menu cuando el programa se haya ejecutado. //
              mensaje ("|                                             |");
              mensaje ("|              MENU DE OPCIONES               |");
              mensaje ("|                                             |");
              mensaje ("|    1. -----> INSERTAR AL INICIO             |");
              mensaje ("|    2. -----> INSERTAR AL FINAL              |");
              mensaje ("|    3. -----> INSERTAR ENTRE NODOS           |");
              mensaje ("|    4. -----> ELIMINAR AL INICIO             |");
              mensaje ("|    5. -----> ELIMINAR AL FINAL              |");
              mensaje ("|    6. -----> ELIMINAR ENTRE NODOS           |");
              mensaje ("|    7. ----->      EDITAR                    |");
              mensaje ("|    8. -----> LISTAR DESDE EL INICIO         |");
              mensaje ("|    9. -----> LISTAR DESDE EL FINAL          |");
              mensaje ("|   10. -----> SALIR                          |");
              mensaje ("|_____________________________________________|");
              mensaje ("|                                             |");
              mensaje ("|              INGRESE SU OPCION :            |");  // Mostramos un mensaje para pedir la opción del menu a realizar. //
              mensaje ("|_____________________________________________|");
              op = t.nextInt();
                switch (op){ //A quí creamos un switch para especificar las funciones de cada opción. //
                  case 1 : insertaInicio();
                  break;
                  case 2 : insertaFinal();
                  break;
                  case 3 : insertaEN();
                  break;
                  case 4 : eliminaInicio();
                  break;
                  case 5 : eliminaFinal();
                  break;
                  case 6 : eliminaEN();
                  break;
                  case 7 : editar();
                  break;
                  case 8 : listadoInicio();
                  break;
                  case 9 : listadoFinal();
                  break;
                  case 10 :
                  break;
                  default :  JOptionPane.showMessageDialog(null, " NO EXISTE ESA OPCION", " ERROR ",JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando la opcion que haya insertado el usuario no exista en el menu de opciones . //
                  break; // insertamos un break para finalizar una secuencia de la instrucción de cada opción. //
                }
            }while (op!=10);
        }catch(Exception e){
          JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando el usuario no haya ingresado caracteres validos //
          v=1;
          t.nextLine();
        }
    }while(v != 0); // Final de la validacion. //
  }
  public static void main(String a[]){
    Lista l = new Lista();
    l.menu();
  }
}
//StackOverflowError: error de desbordamiento de pilas//



// OJEDA ROSALES JUAN AMIZADAY //
