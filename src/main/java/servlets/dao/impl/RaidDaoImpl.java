package servlets.dao.impl;

import servlets.dao.interfaces.RaidDao;
import servlets.model.Raid;

import java.sql.*;

public class RaidDaoImpl implements RaidDao{

    @Override
    public void addRaid(Raid raid) {
        String query ="INSERT INTO Raid(id,debut,fin,changement,contactMail,contactTel,lieu,presentation,prixCaution,prixEtudiantE,prixEtudiantL,prixExterneE,prixExterneL,nomCom1,mailCom1,nomCom2,mailCom2,epreuveV1,epreuveV2,epreuveS1,epreuveS2,epreuveS3,epreuveD1,epreuveD2,equipeImg,plaquetteImg,ancienImg) VALUES(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setDate(1,raid.getDebut());
            stmt.setDate(2,raid.getFin());
            stmt.setDate(3,raid.getChangement());
            stmt.setString(4,raid.getContactMail());
            stmt.setString(5,raid.getContactTel());
            stmt.setString(6,raid.getLieu());
            stmt.setString(7,raid.getPrésentation());
            stmt.setInt(8,raid.getPrixCaution());
            stmt.setInt(9,raid.getPrixEtudiantE());
            stmt.setInt(10,raid.getPrixEtudiantL());
            stmt.setInt(11,raid.getPrixExterneE());
            stmt.setInt(12,raid.getPrixExterneL());
            stmt.setString(13,raid.getNomCom1());
            stmt.setString(14,raid.getMailCom1());
            stmt.setString(15,raid.getNomCom2());
            stmt.setString(16,raid.getMailCom2());
            stmt.setString(17,raid.getEpreuveV1());
            stmt.setString(18,raid.getEpreuveV2());
            stmt.setString(19,raid.getEpreuveS1());
            stmt.setString(20,raid.getEpreuveS2());
            stmt.setString(21,raid.getEpreuveS3());
            stmt.setString(22,raid.getEpreuveD1());
            stmt.setString(23,raid.getEpreuveD2());
            stmt.setString(24,raid.getEquipeImg());
            stmt.setString(25,raid.getPlaquetteImg());
            stmt.setString(26,raid.getAncienImg());
            stmt.executeUpdate();

        } catch (SQLException e) {
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
                Raid raid = new Raid(
                        rs.getInt("id"),
                        rs.getDate("debut"),
                        rs.getDate("fin"),
                        rs.getDate("changement"),
                        rs.getString("contactMail"),
                        rs.getString("contactTel"),
                        rs.getString("lieu"),
                        rs.getString("presentation"),
                        rs.getInt("prixCaution"),
                        rs.getInt("prixEtudiantE"),
                        rs.getInt("prixEtudiantL"),
                        rs.getInt("prixExterieurE"),
                        rs.getInt("prixExterieurL"),
                        rs.getString("nomCom1"),
                        rs.getString("mailCom1"),
                        rs.getString("nomCom2"),
                        rs.getString("mailCom2"),
                        rs.getString("epreuveV1"),
                        rs.getString("epreuveV2"),
                        rs.getString("epreuveS1"),
                        rs.getString("epreuveS2"),
                        rs.getString("epreuveS3"),
                        rs.getString("epreuveD1"),
                        rs.getString("epreuveD2"),
                        rs.getString("plaquetteImg"),
                        rs.getString("equipeImg"),
                        rs.getString("ancienImg"));
                return raid;
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void emptyRaid() {
        String query = "TRUNCATE raid";
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}