package readabilityScore;

public class TextStatisticsCalculator {

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

    private int calculateCharacters(String text) {
        int characters = 0;
        for (char character : text.toCharArray()) {
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

    TextStatistics calculateStatistics(String text) {
        int words = calculateWords(text);
        int sentences = calculateSentences(text);
        int characters = calculateCharacters(text);
        int syllables = calculateSyllables(text);
        int polysyllables = calculatePolysyllables(text);
        return new TextStatistics(words, sentences, characters, syllables, polysyllables);
    }
}
