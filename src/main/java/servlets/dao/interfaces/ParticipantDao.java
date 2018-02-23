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
}
