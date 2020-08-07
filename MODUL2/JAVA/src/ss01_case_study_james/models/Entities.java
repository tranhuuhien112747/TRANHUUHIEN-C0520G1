package ss01_case_study_james.models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Entities implements Serializable {
    private List<Noun> nounList = new LinkedList<>();
    private List<Adjective> adjectiveList = new LinkedList<>();
    private List<Verb> verbList = new LinkedList<>();
    private String synonymous;
    private String pronounce;

    public List<Noun> getNounList() {
        return nounList;
    }

    public void setNounList(List<Noun> nounList) {
        this.nounList = nounList;
    }

    public List<Adjective> getAdjectiveList() {
        return adjectiveList;
    }

    public void setAdjectiveList(List<Adjective> adjectiveList) {
        this.adjectiveList = adjectiveList;
    }

    public List<Verb> getVerbList() {
        return verbList;
    }

    public void setVerbList(List<Verb> verbList) {
        this.verbList = verbList;
    }

    public String getSynonymous() {
        return synonymous;
    }

    public void setSynonymous(String synonymous) {
        this.synonymous = synonymous;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    public void show() {
        System.out.println("-- pronoun:  " + this.pronounce);

        if (!adjectiveList.isEmpty()) {
            System.out.println("► Adjective .");
            for (Adjective adjective : adjectiveList) {
                System.out.println("--adjective define: " + adjective.getDefine());
                System.out.println("          - " + adjective.getSentence());
                System.out.println("         -->" + adjective.getSentenceMeaning());
            }
        }
        if (!nounList.isEmpty()) {
            System.out.println("► Noun .");
            for (Noun noun : nounList) {
                System.out.println("--noun define: " + noun.getDefine());
                System.out.println("          - " + noun.getSentence());
                System.out.println("         -->" + noun.getSentenceMeaning());;
            }
        }
        if (!verbList.isEmpty()) {
            System.out.println("► Verb .");
            for (Verb verb : verbList) {
                System.out.println("--verb define: " + verb.getDefine());
                System.out.println("          - " + verb.getSentence());
                System.out.println("         -->" + verb.getSentenceMeaning());
            }
        }
        System.out.println("Synonymous:");
        System.out.println(synonymous);

    }
}
