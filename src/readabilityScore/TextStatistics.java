package readabilityScore;

public class TextStatistics {
    private final int words;
    private final int sentences;
    private final int characters;
    private final int syllables;
    private final int polysyllables;

    TextStatistics(int words, int sentences, int characters, int syllables, int polysyllables) {
        this.words = words;
        this.sentences = sentences;
        this.characters = characters;
        this.syllables = syllables;
        this.polysyllables = polysyllables;
    }

    void displayTextStatistics() {
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + characters);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllables);
    }

    int getSentences() {
        return sentences;
    }

    int getWords() {
        return words;
    }

    int getCharacters() {
        return characters;
    }

    int getSyllables() {
        return syllables;
    }

    int getPolysyllables() {
        return polysyllables;
    }
}
