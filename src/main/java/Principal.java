import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
    public static void main(String args[]){
        if(args.length==0) {
            System.out.println("Falta el nombre del archivo.");
            System.exit(1);
        }
        String fileName= args[0];
        FileReader filereader=null;
        try {
            filereader= new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("El nombre del archivo no es valido.");
            System.exit(2);
        }
        BufferedReader in=new BufferedReader(filereader);
        String textLine=null;
        int contador=0;
        while (true){
            try {
                if (!((textLine= in.readLine())!= null))
                    break;
            } catch (IOException e) {
                System.out.println("Error al leer el archivo de entrada.");
                System.exit(3);
            }
            contador++;
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("El archivo "+fileName+" tiene "+ contador+" lineas.");
    }
}
