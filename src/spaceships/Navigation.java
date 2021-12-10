package spaceships;

public interface Navigation {
    int moveUP(); //y
    int moveDOWN(); //y
    int moveLEFT(); //x
    int moveRIGHT(); //x
    void shoot();
}
