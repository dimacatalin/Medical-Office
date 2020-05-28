package repositories;

import managers.DBConnectionManager;
import model.Cabinet;
import model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DBDoctorRepository implements DoctorRepository  {

    @Override
    public void addDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctori VALUES (NULL, ?, ?, ?, ?, ?)";

        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setString(1, doctor.getnume());
            statement.setString(2, doctor.getprenume());

            statement.setString(3,doctor.getCabinet().getAdresa());
            statement.setString(4,doctor.getCabinet().getSpecializare());
            statement.setInt(5,doctor.getAniExperienta());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Doctor> findDoctorById(int id) {
        String sql = "SELECT * FROM doctori WHERE id = ?";

        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setInt(1, id);

            ResultSet set = statement.executeQuery(); // in RS avem randurile din tabela

            if (set.next()) {
                int idd = set.getInt("id");
                String num = set.getString("nume");
                String pre = set.getString("prenume");
                String unu = set.getString("adresa");
                String doi = set.getString("specializare");
                Cabinet cabi = new Cabinet(doi,unu);
                int aniXP = set.getInt("aniExperienta");

                return Optional.of(new Doctor(idd, num,pre,cabi, aniXP));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}