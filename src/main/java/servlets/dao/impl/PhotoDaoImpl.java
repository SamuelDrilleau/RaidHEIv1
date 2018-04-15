package servlets.dao.impl;

import servlets.dao.interfaces.PhotoDao;
import servlets.model.Equipe;
import servlets.model.Participant;
import servlets.model.Photo;

import java.sql.*;
import java.util.ArrayList;

public class PhotoDaoImpl implements PhotoDao {


    @Override
        /* Cette fonction permet d'ajouter une photo à la base de données */
    public Photo addPhoto(Photo photo) {
        String query = "INSERT INTO photo(id,annee,nom) VALUES(?,?,?)";
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, photo.getId());
            stmt.setInt(2, photo.getAnnee());
            stmt.setString(3, photo.getNom());
            stmt.executeUpdate();

            try(ResultSet ids =stmt.getGeneratedKeys()){
                if(ids.next()){
                    int generateId = ids.getInt(1);
                    photo.setId(generateId);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
        /* Cette fonction permet de récupérer les photos de la base de données */

    public ArrayList<Photo> getAllPhoto(int valeur) {
        ArrayList<Photo> listPhoto = new ArrayList<>();
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM photo");
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
