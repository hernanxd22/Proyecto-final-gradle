package main;

import dao.DomicilioDAOImpl;
import dao.PersonaDAOImpl;
import org.example.entities.Domicilio;
import org.example.entities.Persona;

import java.sql.Connection;
import java.sql.SQLException;

import static config.DataBaseConnection.getConnection;

public class Main {
    public static void main(String[] args) {

        try {
            Domicilio domicilio = Domicilio.builder()
                    .calle("Augusto T. Vandor")
                    .numero(1542)
                    .build();

            DomicilioDAOImpl domicilioDAO = new DomicilioDAOImpl();
            domicilioDAO.guardar(domicilio);

            Persona persona = Persona.builder()
                    .nombre("Romano Nicolas")
                    .domicilio(domicilio)
                    .build();

            PersonaDAOImpl personaDAO = new PersonaDAOImpl();
            personaDAO.guardar(persona);

            System.out.println("Persona y Domicilio guardados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}