package servlets.dao.interfaces;

import servlets.model.Raid;

public interface RaidDao
{
    public void addRaid(Raid raid);

    public Raid getRaid(int id);

    public void emptyRaid();
}
