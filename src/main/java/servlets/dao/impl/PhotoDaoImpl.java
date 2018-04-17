package servlets.dao.impl;

import servlets.dao.interfaces.PhotoDao;
import servlets.model.Equipe;
import servlets.model.Participant;
import servlets.model.Photo;

import java.sql.*;
import java.util.ArrayList;

public class PhotoDaoImpl implements PhotoDao{


    @Override
    public void addPhoto(Photo photo) {
        String query ="INSERT INTO photo(annee,nom) VALUES(?,?)";
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,photo.getAnnee());
            stmt.setString(2,photo.getNom());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Photo> getAllPhoto(int valeur) {
        ArrayList<Photo> listPhoto = new ArrayList<>();
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM photo WHERE annee=valeur");
            while (rs.next()) {
                Photo photo = new Photo(
                        rs.getInt("id"),
                        rs.getInt("annee"),
                        rs.getString("nom"));
                listPhoto.add(photo);
            }return listPhoto;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
