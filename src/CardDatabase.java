import java.util.ArrayList;

public class CardDatabase implements CardInterface {

    private ArrayList<FlashCard> beginner;
    private ArrayList<FlashCard> basic;

    public CardDatabase() {
        beginner = new ArrayList<>();
        basic = new ArrayList<>();
        beginner.add(new FlashCard("Kanji: 日", new String[]{"Onyomi: ニチ、ジツ", "Kunyomi:　ひ、か", "Meaning: day, sun, Japan, counter for days"}));
        beginner.add(new FlashCard("Kanji: 一", new String[]{"Onyomi:　イチ、イツ", "Kunyomi:　ひと、ひとつ", "Meaning:　one"}));
        beginner.add(new FlashCard("Kanji: 国", new String[]{"Onyomi:　コク", "Kunyomi:　くに", "Meaning:　country"}));
        basic.add(new FlashCard("Kanji: 会", new String[]{"Onyomi:　カイ、エ","Kunyomi:　あう","Meaning:　meeting, meet, party, association, interview, join"}));
        basic.add(new FlashCard("Kanji: 社", new String[]{"Onyomi:　シャ","Kunyomi:　やしろ","Meaning: company, firm, office, association, shrine"}));
        basic.add(new FlashCard("Kanji: 新", new String[]{"Onyomi:　シン","Kunyomi:　あたら、あら、にい","Meaning: new"}));

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
