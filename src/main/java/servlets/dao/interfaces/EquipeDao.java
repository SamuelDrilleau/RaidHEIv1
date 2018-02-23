package servlets.dao.interfaces;

import servlets.model.Equipe;
import servlets.model.Participant;

import java.util.ArrayList;

public interface EquipeDao {

    public ArrayList<Equipe> getAllEquipe();

    public void addEquipe(Equipe equipe);
}
