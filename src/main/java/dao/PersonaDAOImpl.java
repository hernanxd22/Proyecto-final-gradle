package dao;


import config.DataBaseConnection;
import org.example.entities.Domicilio;
import org.example.entities.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOImpl implements PersonaDAO {

    private final DomicilioDAO domicilioDAO = new DomicilioDAOImpl();

    @Override
    public void guardar(Persona persona) throws SQLException {
        // Primero guardar domicilio si no es null y no tiene id
        Domicilio dom = persona.getDomicilio();
        if (dom != null && dom.getId() == 0) {
            domicilioDAO.guardar(dom);
        }

        String sql = "INSERT INTO persona (nombre, domicilio_id) VALUES (?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, persona.getNombre());
            if (dom != null) {
                ps.setLong(2, dom.getId());
            } else {
                ps.setNull(2, Types.BIGINT);
            }

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                persona.setId(rs.getLong(1));
            }
        }
    }

    @Override
    public void actualizar(Persona persona) throws SQLException {
        // Actualizar domicilio si corresponde
        Domicilio dom = persona.getDomicilio();
        if (dom != null && dom.getId() != 0) {
            domicilioDAO.actualizar(dom);
        }

        String sql = "UPDATE persona SET nombre=?, domicilio_id=? WHERE id=?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, persona.getNombre());
            if (dom != null) {
                ps.setLong(2, dom.getId());
            } else {
                ps.setNull(2, Types.BIGINT);
            }
            ps.setLong(3, persona.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(long id) throws SQLException {
        String sql = "DELETE FROM persona WHERE id=?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Persona buscarPorId(long id) throws SQLException {
        String sql = "SELECT p.id, p.nombre, d.id AS dom_id, d.calle, d.numero " +
                "FROM persona p LEFT JOIN domicilio d ON p.domicilio_id = d.id WHERE p.id=?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Domicilio domicilio = null;
                long domId = rs.getLong("dom_id");
                if (!rs.wasNull()) {
                    domicilio = Domicilio.builder()
                            .id(domId)
                            .calle(rs.getString("calle"))
                            .numero(rs.getInt("numero"))
                            .build();
                }

                return Persona.builder()
                        .id(rs.getLong("id"))
                        .nombre(rs.getString("nombre"))
                        .domicilio(domicilio)
                        .build();
            }
        }
        return null;
    }

    @Override
    public List<Persona> buscarTodos() throws SQLException {
        String sql = "SELECT p.id, p.nombre, d.id AS dom_id, d.calle, d.numero " +
                "FROM persona p LEFT JOIN domicilio d ON p.domicilio_id = d.id";

        List<Persona> lista = new ArrayList<>();
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Domicilio domicilio = null;
                long domId = rs.getLong("dom_id");
                if (!rs.wasNull()) {
                    domicilio = Domicilio.builder()
                            .id(domId)
                            .calle(rs.getString("calle"))
                            .numero(rs.getInt("numero"))
                            .build();
                }

                Persona p = Persona.builder()
                        .id(rs.getLong("id"))
                        .nombre(rs.getString("nombre"))
                        .domicilio(domicilio)
                        .build();

                lista.add(p);
            }
        }
        return lista;
    }
}

