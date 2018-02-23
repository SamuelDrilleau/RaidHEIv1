package servlets.dao.impl;

import servlets.dao.interfaces.ParticipantDao;
import servlets.model.Participant;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ParticipantDaoImpl implements ParticipantDao {
    @Override
    public void addParticipant(Participant participant) {
        String query ="INSERT INTO Participant(mail,mdp,nom,prenom,sexe,tel,statut,nomEnt,nomUrg,telUrg,bds,vtt,bus,tshirt,fftri,nomEquipe,certifMed,certifSco,attestation) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1,participant.getMail());
            stmt.setString(2,participant.getMdp());
            stmt.setString(3,participant.getNom());
            stmt.setString(4,participant.getPrenom());
            stmt.setString(5,participant.getSexe());
            stmt.setString(6,participant.getTel());
            stmt.setString(7,participant.getStatut());
            stmt.setString(8,participant.getNomEnt());
            stmt.setString(9,participant.getNomUrg());
            stmt.setString(10,participant.getTelUrg());
            stmt.setString(11,participant.getBds());
            stmt.setString(12,participant.getVtt());
            stmt.setString(13,participant.getBus());
            stmt.setString(14,participant.getTshirt());
            stmt.setString(15,participant.getFftri());
            stmt.setString(16,participant.getNomEquipe());
            stmt.setString(17,"NON");
            stmt.setString(18,"NON");
            stmt.setString(19,"NON");
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Participant> getAllParticipant() {
        ArrayList<Participant> listParticipant = new ArrayList<>();
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Participant JOIN Equipe ON Participant.nomEquipe = Equipe.nom");
            while (rs.next()) {
                Participant participant = new Participant(
                        rs.getString("mail"),
                        rs.getString("mdp"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("sexe"),
                        rs.getString("tel"),
                        rs.getString("statut"),
                        rs.getString("nomEnt"),
                        rs.getString("nomUrg"),
                        rs.getString("telUrg"),
                        rs.getString("bds"),
                        rs.getString("vtt"),
                        rs.getString("bus"),
                        rs.getString("tshirt"),
                        rs.getString("fftri"),
                        rs.getString("nomEquipe"),
                        rs.getString("certifMed"),
                        rs.getString("certifSco"),
                        rs.getString("attestation"));
                listParticipant.add(participant);
            }return listParticipant;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Participant participantByMail (String mail) {
        String query ="SELECT * FROM Participant WHERE mail=?";
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, mail);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Participant(
                        rs.getString("mail"),
                        rs.getString("mdp"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("sexe"),
                        rs.getString("tel"),
                        rs.getString("statut"),
                        rs.getString("nomEnt"),
                        rs.getString("nomUrg"),
                        rs.getString("telUrg"),
                        rs.getString("bds"),
                        rs.getString("vtt"),
                        rs.getString("bus"),
                        rs.getString("tshirt"),
                        rs.getString("fftri"),
                        rs.getString("nomEquipe"),
                        rs.getString("certifMed"),
                        rs.getString("certifSco"),
                        rs.getString("attestation"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delParticipant(String mail) {
        String query = "DELETE FROM participants WHERE mail=?;";
        try{
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, mail);
            ResultSet rs = statement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /*

    @Override
    public void addContenu(Participant contenu) {
        String query ="INSERT INTO contenu(contenu_id,titre,date_diffusion,heure,user_pseudo,duree,types) VALUES(?,?,?,?,?,?,?)";
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,contenu.getId());
            stmt.setString(2,contenu.getTitre());
            stmt.setDate(3, Date.valueOf(contenu.getLocalDate()));
            stmt.setTime(4,Time.valueOf(contenu.getLocalTime()));
            stmt.setString(5,contenu.getUser_pseudo());
            stmt.setInt(6,contenu.getDuree());
            stmt.setString(7,contenu.getTypes());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Participant> getAllContenu() {
        ArrayList<Participant> listContenu = new ArrayList<>();
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM contenu JOIN users ON contenu.user_pseudo = users.pseudo");
            while (rs.next()) {
                Participant contenu = new Participant(
                        rs.getInt("contenu_id"),
                        rs.getString("titre"),
                        LocalDate.parse(rs.getString("date_diffusion")),
                        LocalTime.parse(rs.getString("heure")),
                        rs.getString("user_pseudo"),
                        rs.getInt("duree"),
                        rs.getString("types"));
                listContenu.add(contenu);
            }return listContenu;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    */
}
