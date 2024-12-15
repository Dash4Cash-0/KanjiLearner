import java.util.ArrayList;

public class CardDatabase implements CardInterface {

    private ArrayList<FlashCard> beginner;
    private ArrayList<FlashCard> basic;

    public CardDatabase() {
        beginner = new ArrayList<>();
        basic = new ArrayList<>();
        beginner.add(new FlashCard("Kanji: 日", new String[]{"Onyomi: ニチ、ジツ", "Kunyomi:　ひ、か", "Meaning: day, sun, Japan, counter for days"}));
        basic.add(new FlashCard("Kanji: 会", new String[]{"Onyomi:　カイ、エ","Kunyomi:　あう","Meaning:　meeting, meet, party, association, interview, join"}));

    }

    public ArrayList<FlashCard> getBasic() {
        return basic;
    }
    public ArrayList<FlashCard> getBeginner() {
        return beginner;
    }

    @Override
    public String printFront() {
        for(FlashCard c : beginner) {
            return c.getFront();
        }
        return null;
    }

    @Override
    public String printOn() {
        return beginner.get(0).getBack()[0];
    }

    @Override
    public String printKun() {
        return beginner.get(0).getBack()[1];
    }

    @Override
    public String printMeaning() {
        return beginner.get(0).getBack()[2];
    }
}
