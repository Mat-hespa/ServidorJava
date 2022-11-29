/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author matheusah
 */
public class Servidor {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> solicitacoes = new ArrayList<>();
        List<String>[] arrayOfList = new List[50];
        int numero = 0;
        
        try {
            //Serviço de escuta
            ServerSocket servidor = new ServerSocket(3334);
            System.out.println("Servidor iniciado na porta 3334");
            
            //Canal de comunicação para o serviço
            Socket cliente = servidor.accept();
            System.out.println("Cliente do IP " + cliente.getInetAddress().getHostAddress());
            
            Scanner entrada = new Scanner(cliente.getInputStream());

            while(entrada.hasNextLine()) {
                solicitacoes.add(entrada.nextLine());
                arrayOfList[numero] = solicitacoes;
            }
            
            System.out.println(solicitacoes);
            System.out.println(Arrays.toString(arrayOfList));
            entrada.close();
            servidor.close();
            
        } catch (IOException ex) {
            System.out.println("Erro ao iniciar o servidor!");
        }
    }
    
}
