package Less_24_HW_StreamAPI.StreamAndMyOwnClasses.MySuperHero;

import java.util.Objects;

public class SuperHero {
    private String nameOfHero;
    private int ageOfHero;

    public SuperHero(String nameOfHero, int ageOfHero) {
        this.nameOfHero = nameOfHero;
        this.ageOfHero = ageOfHero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperHero superHero = (SuperHero) o;
        return ageOfHero == superHero.ageOfHero &&
               Objects.equals(nameOfHero, superHero.nameOfHero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfHero, ageOfHero);
    }

    @Override
    public String toString() {
        return "SuperHero: [" +
                "nameOfHero= '" + nameOfHero + '\'' +
                ", ageOfHero= " + ageOfHero +
                ']';
    }

    public String getNameOfHero() {
        return nameOfHero;
    }

    public int getAgeOfHero() {
        return ageOfHero;
    }
}
