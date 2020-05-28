package repositories;

import managers.DBConnectionManager;
import model.Medicament;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DBMedicamentRepository implements MedicamentRepository  {

    @Override
    public void addMedicament(Medicament medicament) {
        String sql = "INSERT INTO medicamente VALUES (NULL, ?, ?, ?)";

        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setString(1, medicament.getNume());
            statement.setFloat(2,medicament.getPret());
            statement.setString(3,medicament.getDoza());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Medicament> findMedicamentById(int id) {
        String sql = "SELECT * FROM medicamente WHERE id = ?";

        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setInt(1, id);

            ResultSet set = statement.executeQuery(); // in RS avem randurile din tabela

            if (set.next()) {
                int idd = set.getInt("id");
                String num = set.getString("nume");
                float prez = set.getFloat("pret");
                String doz = set.getString("doza");

                return Optional.of(new Medicament(num,idd, prez, doz));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}