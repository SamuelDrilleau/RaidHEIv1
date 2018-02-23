package servlets.dao.impl;

import servlets.dao.interfaces.RaidDao;
import servlets.model.Raid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RaidDaoImpl implements RaidDao{

    @Override
    public void addRaid(Raid raid) {
        String query ="INSERT INTO Raid(id,annee) VALUES(0,?)";
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,raid.getAnnee());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delRaid() {
        String query = "DELETE FROM Raid WHERE id=0;";
        try{
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Raid getRaid(int id) {
        String query = "SELECT * FROM Raid WHERE id=0";
        try{
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Raid raid = new Raid(rs.getInt("annee"));
                return raid;
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}