package repositories;

import managers.DBConnectionManager;
import model.Boala;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DBBoalaRepository implements BoalaRepository  {

    @Override
    public void addBoala(Boala boala) {
        String sql = "INSERT INTO boli VALUES (NULL, ?, ?, ?)";

        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setString(1, boala.getNumeBoala());

            String medic = "";
            List<String> list1 = boala.getSimptome();
            for (int i= 0;i<list1.size();i++){
                medic = medic + list1.get(i)+",";
            }
            statement.setString(2,medic);

            String simpt = "";
            List<String> list = boala.getSimptome();
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
    public Optional<Boala> findBoalaById(int id) {
        String sql = "SELECT * FROM boli WHERE id = ?";

        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setInt(1, id);

            ResultSet set = statement.executeQuery(); // in RS avem randurile din tabela

            if (set.next()) {
                int idd = set.getInt("id");
                String num = set.getString("nume");
                String medic = set.getString("medicamente");
                String simp = set.getString("simptome");

                String [] attr = simp.split(",");

                List<String> simptome = new ArrayList<String>();

                for (int i = 3;i<attr.length;i++)
                    simptome.add(attr[i]);


                String [] attrr = medic.split(",");

                List<String> medicamente = new ArrayList<String>();

                for (int i = 3;i<attrr.length;i++)
                    medicamente.add(attrr[i]);

                return Optional.of(new Boala(idd, num, medicamente, simptome));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}