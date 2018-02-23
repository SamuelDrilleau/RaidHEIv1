package servlets.dao.interfaces;

import servlets.model.Raid;

public interface RaidDao
{
    public void addRaid(Raid raid);

    public void delRaid();

    public Raid getRaid(int id);
}
