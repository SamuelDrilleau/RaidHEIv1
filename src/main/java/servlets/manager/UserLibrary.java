package servlets.manager;

import servlets.dao.impl.ParticipantDaoImpl;
import servlets.dao.impl.EquipeDaoImpl;
import servlets.dao.impl.PhotoDaoImpl;
import servlets.dao.impl.RaidDaoImpl;
import servlets.dao.interfaces.ParticipantDao;
import servlets.dao.interfaces.EquipeDao;
import servlets.dao.interfaces.PhotoDao;
import servlets.dao.interfaces.RaidDao;
import servlets.model.Participant;
import servlets.model.Equipe;
import servlets.model.Photo;
import servlets.model.Raid;

import java.util.ArrayList;

public class UserLibrary {

    private static class UserLibraryHolder{
        private final static UserLibrary instance = new UserLibrary();
    }

    public static UserLibrary getInstance(){return UserLibraryHolder.instance;}

    private EquipeDao EquipeDao = new EquipeDaoImpl();
    private ParticipantDao ParticipantDao = new ParticipantDaoImpl();
    private RaidDao RaidDao = new RaidDaoImpl();
    private PhotoDao PhotoDao = new PhotoDaoImpl();

    private UserLibrary(){}

    public void addParticipant(Participant participant){ParticipantDao.addParticipant(participant);}

    public ArrayList<Participant> getAllParticipant (){return ParticipantDao.getAllParticipant();}

    public void addEquipe(Equipe equipe){EquipeDao.addEquipe(equipe);}

    public ArrayList<Equipe> getAllEquipe (){return EquipeDao.getAllEquipe();}

    public Participant participantByMail(String mail){return ParticipantDao.participantByMail(mail);}

    public void delParticipant(String mail){ParticipantDao.delParticipant(mail);}

    public void addRaid(Raid raid){RaidDao.addRaid(raid);}

    public void delRaid(){RaidDao.delRaid();}

    public Raid getRaid(){return RaidDao.getRaid(0);}

    public void addPhoto(Photo photo){PhotoDao.addPhoto(photo);}

    public ArrayList<Photo> getAllPhoto(int annee){return PhotoDao.getAllPhoto(annee);}

    public void updateAttestation(int valeur, String user){ParticipantDao.updateAttestation(valeur,user);}

    public void updateCertifMed(int valeur, String user){ParticipantDao.updateCertifMed(valeur,user);}

    public void updatCertifSco(int valeur, String user){ParticipantDao.updateCertifSco(valeur,user);}

}
