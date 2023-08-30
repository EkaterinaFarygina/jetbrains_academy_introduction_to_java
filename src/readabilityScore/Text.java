package readabilityScore;

public class Text {
    private final int words;
    private final int sentences;
    private final int characters;
    private final int syllables;
    private final int polysyllables;


    Text(String text) {
        words = calculateWords(text);
        sentences = calculateSentences(text);
        characters = calculateCharacters(text);
        syllables = calculateSyllables(text);
        polysyllables = calculatePolysyllables(text);
    }

    private int calculateWords(String text) {
        String[] words = text.split("[\\s]");
        return words.length;
    }

    private int calculateSentences(String text) {
        final String[] separateSentences = text.split("[!.?]");
        if ("\n".equals(separateSentences[separateSentences.length - 1])) {
            return separateSentences.length - 1;
        } else {
            return separateSentences.length;
        }
    }

    private int calculateCharacters(String input) {
        int characters = 0;
        for (char character : input.toCharArray()) {
            if (character != ' ' && character != '\n' && character != '\t'){
                characters++;
            }
        }
        return characters;
    }

    private int calculateVowels(String word) {
        String regexVowels = "[aeiouyAEIOUY]";
        word = word.replaceAll("[^a-zA-Z]", "");
        char[] wordCharacters = word.toCharArray();
        int vowelCounter = 0;
        for (int i = 0; i < wordCharacters.length; i++) {
            String currentCharacter = Character.toString(wordCharacters[i]);
            if (currentCharacter.matches(regexVowels)) {
                if (i == wordCharacters.length - 1) {
                    if ("e".equals(currentCharacter)) {
                        continue;
                    } else {
                        vowelCounter++;
                    }
                } else if (Character.toString(wordCharacters[i+1]).matches(regexVowels)) {
                    continue;
                } else {
                    vowelCounter++;
                }
            }
        }
        return vowelCounter;
    }

    private int calculateSyllables(String text) {
        int syllables = 0;
        String[] words = text.split("[\\s]");
        for (String word : words) {
            int vowelCounter = calculateVowels(word);
            if (vowelCounter == 0) vowelCounter = 1;
            syllables += vowelCounter;
        }
        return syllables;
    }

    private int calculatePolysyllables(String text) {
        int polysyllables = 0;
        String[] words = text.split("[\\s]");
        for (String word : words) {
            int vowelCounter = calculateVowels(word);
            if (vowelCounter > 2) polysyllables++;
        }
        return polysyllables;
    }

    void displayTextCharacteristics() {
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
