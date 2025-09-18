package com.example.ispit.repository;

import com.example.ispit.entity.Polaznik;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcPolaznikRepository {
    private final JdbcTemplate jdbc;

    public JdbcPolaznikRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Polaznik> findAllUsingJdbc() {
        return jdbc.query("SELECT * FROM polaznik", (rs, rowNum) -> {
            Polaznik p = new Polaznik();
            p.setPolaznikID(rs.getLong("polaznikID"));
            p.setIme(rs.getString("ime"));
            p.setPrezime(rs.getString("prezime"));
            return p;
        });
    }
}
