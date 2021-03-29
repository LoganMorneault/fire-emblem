package Model.Characters.Testing;

import Model.Characters.UnitStats;

public class TestUnitStats {

    public static void testGetStat() {
        UnitStats us = new UnitStats(1, 2, 3, 4, 5, 6, 7);

        assert(us.getStat("CHP") == 1);
        assert(us.getStat("MHP") == 1);

        assert(us.getStat("STRENGTH") == 2);
        assert(us.getStat("ATTACK") == 2);
        assert(us.getStat("ATK") == 2);
        assert(us.getStat("STR") == 2);

        assert(us.getStat("MAGIC") == 3);
        assert(us.getStat("MAG") == 3);
        assert(us.getStat("MATK") == 3);

        assert(us.getStat("DEFENSE") == 4);
        assert(us.getStat("DEF") == 4);
       
        assert(us.getStat("RESISTANCE") == 5);
        assert(us.getStat("RES") == 5);
        assert(us.getStat("MDEF") == 5);

        assert(us.getStat("SPEED") == 6);
        assert(us.getStat("SPD") == 6);

        assert(us.getStat("MOV") == 7);
        assert(us.getStat("MOVE") == 7);
        assert(us.getStat("MOVESPEED") == 7);

        System.out.println("UnitStats: TestGetStat successful");
    }

    public static void testSetStat() {
        UnitStats us = new UnitStats(1, 2, 3, 4, 5, 6, 7);

        us.setStat("CHP", 0);
        us.setStat("MHP", 10);
        assert(us.getStat("CHP") == 0);
        assert(us.getStat("MHP") == 10);

        us.setStat("STRENGTH", 8);
        assert(us.getStat("STRENGTH") == 8);
        assert(us.getStat("ATTACK") == 8);
        assert(us.getStat("ATK") == 8);
        assert(us.getStat("STR") == 8);

        us.setStat("MAGIC", 9);
        assert(us.getStat("MAGIC") == 9);
        assert(us.getStat("MAG") == 9);
        assert(us.getStat("MATK") == 9);

        us.setStat("DEFENSE", 11);
        assert(us.getStat("DEFENSE") == 11);
        assert(us.getStat("DEF") == 11);
       
        us.setStat("RESISTANCE", 12);
        assert(us.getStat("RESISTANCE") == 12);
        assert(us.getStat("RES") == 12);
        assert(us.getStat("MDEF") == 12);

        us.setStat("SPEED", 13);
        assert(us.getStat("SPEED") == 13);
        assert(us.getStat("SPD") == 13);

        us.setStat("MOVE", 14);
        assert(us.getStat("MOV") == 14);
        assert(us.getStat("MOVE") == 14);
        assert(us.getStat("MOVESPEED") == 14);

        System.out.println("UnitStats: TestSetStat successful");
    }

}