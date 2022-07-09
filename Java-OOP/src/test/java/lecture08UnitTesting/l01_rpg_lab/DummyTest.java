package lecture08UnitTesting.l01_rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class DummyTest {
    Dummy dummy;
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_XP = 100;
    private static final int DAMAGE = 10;

    @Before
    public void setUp() {
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }


    @Test
    public void testDummyLosesHealthWhenAttacked() {
        dummy.takeAttack(DAMAGE);
        Assert.assertEquals(DUMMY_HEALTH - DAMAGE, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsExceptionWhenAttacked() {
        dummy.takeAttack(DUMMY_HEALTH);
        dummy.takeAttack(DAMAGE);
    }

    @Test
    public void testDummyGivesXPWhenKilled() {
        dummy.takeAttack(DUMMY_HEALTH);
        Assert.assertEquals(DUMMY_XP, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testDummyDoesntGiveXPWhenAlive() {
        dummy.giveExperience();
    }

    @Test
    public void testDummyDropsAxe() {
        dummy = Mockito.mock(Dummy.class);
        when(dummy.isDead()).thenReturn(true);
        when(dummy.dropLoot()).thenReturn(LootFactory.getRandomAxe());
        Loot loot = dummy.dropLoot();
        Assert.assertEquals(Axe.class,loot.getClass());
    }

    @Test(expected = IllegalStateException.class)
    public void testDummyThrowsExceptionWhenLootedAlive() {
        dummy.dropLoot();
    }


}
