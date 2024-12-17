import java.util.ArrayList;


public class CardDatabase {

    private ArrayList<FlashCard> beginner;
    private ArrayList<FlashCard> basic;
    private Level level;

    public CardDatabase() {
        beginner = new ArrayList<>();
        basic = new ArrayList<>();
        beginner.add(new FlashCard("Kanji: 日", new String[]{"Onyomi: ニチ、ジツ", "Kunyomi:　ひ、か", "Meaning: day, sun, Japan, counter for days"}));
        beginner.add(new FlashCard("Kanji: 一", new String[]{"Onyomi:　イチ、イツ", "Kunyomi:　ひと、ひとつ", "Meaning:　one"}));
        beginner.add(new FlashCard("Kanji: 国", new String[]{"Onyomi:　コク", "Kunyomi:　くに", "Meaning:　country"}));
        basic.add(new FlashCard("Kanji: 会", new String[]{"Onyomi:　カイ、エ","Kunyomi:　あう","Meaning:　meeting, meet"}));
        basic.add(new FlashCard("Kanji: 社", new String[]{"Onyomi:　シャ","Kunyomi:　やしろ","Meaning: company, firm, shrine"}));
        basic.add(new FlashCard("Kanji: 新", new String[]{"Onyomi:　シン","Kunyomi:　あたら、あら、にい","Meaning: new"}));

    }

    public ArrayList<FlashCard> getList(Level level) {
        this.level = level;
        if(level == Level.BEGINNER) {
            return beginner;
        }else if(level == Level.BASIC) {
            return basic;
        }
        return null;
    }

    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }

}
