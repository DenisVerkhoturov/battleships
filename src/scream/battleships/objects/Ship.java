package scream.battleships.objects;

import java.util.ArrayList;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Ship
{
    private ArrayList<Deck> decks = new ArrayList<>();

    public Ship(Sector[] sectors)
    {
        for (Sector sector : sectors)
            this.decks.add(new Deck(sector));
    }

    /**
     * Проверяет, остались ли целые палубы.
     * @return - если все палубы разбиты возвращает true
     */
    public boolean isDefeated()
    {
        for (Deck deck : decks) {
            if (deck.isIntact())
                return false;
        }

        return true;
    }

    /**
     * Палуба
     */
    private class Deck
    {
        private Sector sector;
        private boolean intact;

        public Deck(Sector sector)
        {
            this.sector = sector;
            this.intact = sector.isShoot();
        }

        public boolean isIntact()
        {
            return this.intact;
        }
    }
}
