package Abstraction.cardsWithPower;

public class Card {
    private CardRanks cardRank;
    private CardSuits cardSuit;

    public Card(CardRanks cardRank, CardSuits cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public int getPower(){
        return cardRank.getRankPower() + cardSuit.getSuitPower();
    }
}
