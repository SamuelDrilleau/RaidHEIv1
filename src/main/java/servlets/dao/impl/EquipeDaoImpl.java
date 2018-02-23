package servlets.dao.impl;

import servlets.dao.interfaces.EquipeDao;
import servlets.model.Equipe;

import java.sql.*;
import java.util.ArrayList;

public class EquipeDaoImpl implements EquipeDao {
    @Override
    public ArrayList<Equipe> getAllEquipe() {
        ArrayList<Equipe> listEquipe = new ArrayList<>();
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Equipe");
            while (rs.next()) {
                Equipe equipe = new Equipe(
                        rs.getString("nom"),
                        rs.getString("mdp"),
                        rs.getString("typeRaid"));
                listEquipe.add(equipe);
            }return listEquipe;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addEquipe(Equipe equipe) {
        String query ="INSERT INTO Equipe(nom,mdp,typeRaid) VALUES(?,?,?)";
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1,equipe.getNom());
            stmt.setString(2,equipe.getMdp());
            stmt.setString(3,equipe.getTypeRaid());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
