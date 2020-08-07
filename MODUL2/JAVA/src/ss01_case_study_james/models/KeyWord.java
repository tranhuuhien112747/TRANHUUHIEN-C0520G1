package ss01_case_study_james.models;

import java.io.Serializable;

public class KeyWord implements Serializable {
    private String keyWord;
    private Entities entities = new Entities();

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public void showDictionary() {
        System.out.println("█ Words : " + keyWord);
        entities.show();
    }
}
