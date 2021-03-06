package hu.petrik.zita.feladat;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Szerver {
    public static void main(String[] args){
        System.out.println("Szerver indul...");
        try{
            ServerSocket socket=new ServerSocket(8080);
            Socket kapcsolat =socket.accept();

            DataInputStream ugyfeltol = new DataInputStream(kapcsolat.getInputStream());
            DataOutputStream ugyfelnek =new DataOutputStream(kapcsolat.getOutputStream());
            InetAddress ugyfel = kapcsolat.getInetAddress();
            System.out.println("Az ügyfél neve: "+ugyfel.getHostName());
            System.out.println("Az ügyfél címe: "+ugyfel.getHostAddress());
            while (true){
                int sugar= ugyfeltol.readInt();
                double kerulet =2*sugar*Math.PI;
                ugyfelnek.writeDouble(kerulet);
                double terulet = Math.pow(sugar, 2)*Math.PI;
                ugyfelnek.writeDouble(terulet);

            }
        }catch (IOException ex){
            System.out.println(ex);
        }
    }
}
