import javax.xml.crypto.Data;
import java.io.*;

public class PrimitiveUTFchars {
    File archivo = new File("src/archivo1.txt");
    String cadea = "Está en casa";
    public void escribindo(){
        try(DataOutputStream escribir = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(archivo)))){
            //Primeira cadea
            escribir.writeUTF(cadea);
            System.out.println("writeUTF escribindo: Está en casa");
            System.out.println("cadea: "+escribir.size());

            //Segunda cadea
            escribir.writeChars(cadea);
            System.out.println("writeUTF escribindo: Está en casa");
            System.out.println("cadea: "+escribir.size());

            //Terceira cadea
            escribir.writeUTF(cadea);
            System.out.println("writeUTF escribindo: Está en casa");
            System.out.println("cadea: "+escribir.size());

        }catch (IOException e){
            System.out.println("Non foi posible escribir no arquivo");
        }
    }

    public void leendo (){
        try(DataInputStream leer = new DataInputStream(new BufferedInputStream(new FileInputStream(archivo)))){
            while (leer.available()>0);{
        System.out.println("quedan: "+leer.available()+" bytes por ler");
        System.out.println("cadea:"+leer.readChar());
        System.out.println("cadea: "+leer.readUTF());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
