package repositories;

import managers.DBConnectionManager;
import model.Pacient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DBPacientRepository implements PacientRepository  {

    @Override
    public void addPacient(Pacient pacient) {
        String sql = "INSERT INTO pacienti VALUES (NULL, ?, ?, ?)";
        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setString(1, pacient.getnume());
            statement.setString(2, pacient.getprenume());

            String simpt = "";
            List<String> list = pacient.getSimptome();
            for (int i= 0;i<list.size();i++){
                simpt = simpt + list.get(i)+",";
            }
            statement.setString(3,simpt);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Pacient> findPacientById(int id) {
        String sql = "SELECT * FROM pacienti WHERE id = ?";

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
                String simp = set.getString("simptome");

                String [] attr = simp.split(",");

                List<String> simptome = new ArrayList<String>();

                for (int i = 3;i<attr.length;i++)
                    simptome.add(attr[i]);

                return Optional.of(new Pacient(idd, num, pre, simptome));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}