package Characters;



// THIS NEEDS JAVADOC!!!!!

public interface IHero {
    String getName();

    int getStat(String stat);

    void move(int x, int y);

    void attack(IHero other);

    void takeDamage(int damage);
}
