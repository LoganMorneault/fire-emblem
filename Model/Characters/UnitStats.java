package Model.Characters;


/* 

INVARIANT: Stats cannot be negative.
INVARIANT: c_hp cannot exceed m_hp.

*/


/**
 * Class representing a unit's stats.
 */
public class UnitStats {
    private int m_hp;
    private int c_hp;

    private int atk;
    private int m_atk;
    private int def;
    private int m_def;
    private int spd;

    private int mov;

    /**
     * Constructor for UnitStats
     * @param hp maximum hp value.
     * @param atk physical attack value.
     * @param m_atk magical attack value.
     * @param def physical defense value.
     * @param m_def magical defense value.
     * @param spd speed value.
     * @param mov move distance value.
     */
    public UnitStats(int hp, int atk, int m_atk, int def, int m_def, int spd, int mov) {
        this.m_hp = Math.max(hp, 0);
        this.c_hp = this.m_hp;
        this.atk = Math.max(atk, 0);
        this.m_atk = Math.max(m_atk, 0);
        this.def = Math.max(def, 0);
        this.m_def = Math.max(m_def, 0);
        this.spd = Math.max(spd, 0);
        this.mov = Math.max(mov, 0);
    }


    // Note: some variations of the stat names mentioned in the Javadoc are supported, 
    // but I think it would be confusing if that was mentioned in the Javadoc.

    /**
     * Gets the value of the requested stat.
     * @param stat one of: CHP, MHP, STRENGTH, MAGIC, DEFENSE, RESISTANCE, SPEED, MOVE.
     * @return the value of the requested stat
     * @throws IllegalArgumentException if the requested stat does not exist.
     */
    public int getStat(String stat) {
        // Find stat
        switch (stat.toUpperCase()) {
            case "CHP":
                return this.c_hp;
            case "MHP":
                return this.m_hp;
            case "STRENGTH":
            case "ATTACK":
            case "ATK":
            case "STR":
                return this.atk;
            case "MAGIC":
            case "MAG":
            case "MATK":
                return this.m_atk;
            case "DEFENSE":
            case "DEF":
                return this.def;
            case "RESISTANCE":
            case "RES":
            case "MDEF":
                return this.m_def;
            case "SPEED":
            case "SPD":
                return this.spd;
            case "MOV":
            case "MOVE":
            case "MOVESPEED":
                return this.mov;
            default:
                throw new IllegalArgumentException(String.format("Stat %s does not exist", stat));
        }
    }

    /**
     * Sets the requested stat to the given value
     * @param stat the stat to be updated; one of: CHP, MHP, STRENGTH, MAGIC, DEFENSE, RESISTANCE, SPEED, MOVE.
     * @param val the new value of the stat
     * @throws IllegalArgumentException if val is negative or if stat is not valid.
     */
    public void setStat(String stat, int val) {
        // stats cannot be negative
        if (val < 0) {
            throw new IllegalArgumentException("Stats cannot be less than 0.");
        }

        // Find stat and update
        switch (stat.toUpperCase()) {
            case "CHP":
                this.c_hp = val;
                break;
            case "MHP":
                this.m_hp = val;
                break;
            case "STRENGTH":
            case "ATTACK":
            case "ATK":
            case "STR":
                this.atk = val;
                break;
            case "MAGIC":
            case "MAG":
            case "MATK":
                this.m_atk = val;
                break;
            case "DEFENSE":
            case "DEF":
                this.def = val;
                break;
            case "RESISTANCE":
            case "RES":
            case "MDEF":
                this.m_def = val;
                break;
            case "SPEED":
            case "SPD":
                this.spd = val;
                break;
            case "MOV":
            case "MOVE":
            case "MOVESPEED":
                this.mov = val;
                break;
            default:
                throw new IllegalArgumentException(String.format("Stat %s does not exist", stat));
        }
    }
}
