package heroRepository;

import org.junit.Assert;
import org.junit.Test;

public class HeroRepositoryTests {
    @Test
    public void createValidating() {
        HeroRepository repository = new HeroRepository();
        Hero hero = new Hero("Franco", 1);
        Assert.assertEquals("Successfully added hero Franco with level 1", repository.create(hero));
    }

    @Test
    public void sizeTesting() {
        HeroRepository repository = new HeroRepository();
        Hero hero = new Hero("Selena", 4);
        Hero hero1 = new Hero("Miya", 8);
        repository.create(hero);
        repository.create(hero1);
        Assert.assertEquals(2, repository.getCount());
    }

    @Test
    public void removeChecking2() {
        HeroRepository repository = new HeroRepository();
        Hero hero = new Hero("Franco", 4);
        repository.create(hero);
        repository.remove("Franco");
        Assert.assertEquals(0, repository.getCount());
    }


    @Test
    public void removeChecking() {
        HeroRepository repository = new HeroRepository();
        Hero hero = new Hero("Franco", 7);
        repository.create(hero);
        Assert.assertTrue(repository.remove("Franco"));
    }


    @Test(expected = IllegalArgumentException.class)
    public void equalNamesEx() {
        HeroRepository repository = new HeroRepository();
        Hero hero = new Hero("Franco", 7);
        Hero hero2 = new Hero("Franco", 9);
        repository.create(hero);
        repository.create(hero2);
    }

    @Test
    public void levelsTesting() {
        HeroRepository repository = new HeroRepository();
        Hero hero = new Hero("Franco", 1);
        Hero hero1 = new Hero("Miya", 2);
        repository.create(hero);
        repository.create(hero1);
        Assert.assertEquals(hero1, repository.getHeroWithHighestLevel());
    }

    @Test
    public void heroValidating() {
        HeroRepository repository = new HeroRepository();
        Hero hero = new Hero("Franco", 7);
        repository.create(hero);
        Assert.assertEquals(hero, repository.getHero("Franco"));
    }

    @Test
    public void testingConstr() {
        HeroRepository repository = new HeroRepository();
        Assert.assertEquals(0, repository.getCount());
    }
}
