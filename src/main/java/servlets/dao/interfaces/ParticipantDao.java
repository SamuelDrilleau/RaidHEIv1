package servlets.dao.interfaces;

import servlets.model.Participant;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface ParticipantDao {

    public void addParticipant(Participant participant);

    public ArrayList<Participant> getAllParticipant();

    public Participant participantByMail(String mail);

    public void delParticipant(String mail);

    public void updateAttestation(int value, String user);

    public void updateCertifMed(int value, String User);

    public void updateCertifSco(int value, String user);
}
