package edu.dosw.lab;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.dosw.lab.agilismo.src.reto3.SesionPlanningPoker;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número de integrantes del equipo: ");
        int numIntegrantes = Integer.parseInt(sc.nextLine());

        SesionPlanningPoker.ejecutarReto3(numIntegrantes);
        sc.close();
    }
}
