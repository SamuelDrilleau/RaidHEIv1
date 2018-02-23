package servlets.dao.interfaces;

import servlets.model.Photo;

import java.util.ArrayList;

public interface PhotoDao {
    public void addPhoto(Photo photo);

    public ArrayList<Photo> getAllPhoto(int annee);
}
