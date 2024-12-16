package Characters.Hero;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void selectWeapon() {
        InputStream input = new ByteArrayInputStream("Dugland".getBytes());
        System.setIn(input);
        Hero hero = new Hero();
         hero.selectWeapon();
    }

    @Test
    void attack() {
    }

    @Test
    void isAlive() {
    }
}