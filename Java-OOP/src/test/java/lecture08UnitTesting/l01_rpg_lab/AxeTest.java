package lecture08UnitTesting.l01_rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;
    private static final int DEFAULT_ATTACK = 10;
    private static final int DEFAULT_DURABILITY = 100;
    private static final int DEFAULT_DUMMY_HEALTH = 100;
    private static final int DEFAULT_DUMMY_XP = 100;

    @Before
    public void setUp() {
        axe = new Axe(DEFAULT_ATTACK, DEFAULT_DURABILITY);
        brokenAxe = new Axe(DEFAULT_ATTACK, 0);
        dummy = new Dummy(DEFAULT_DUMMY_HEALTH, DEFAULT_DUMMY_XP);
    }

    @Test
    public void testAxeLosesDurabilityAfterEachAttack() {
        axe.attack(dummy);
        Assert.assertEquals(DEFAULT_DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test (expected = IllegalStateException.class)
    public void testAxeThrowsExceptionIfAttackingWithBrokenWeapon() {
        brokenAxe.attack(dummy);
    }
}
