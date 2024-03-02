package pl.jaroslaw.zegzula.flashcard;

import java.util.List;

public class FlashcardsDeck {
    public static final String DECK_HEADER = "\"Front\",\"Back\"";
    private final List<Flashcard> flashcards;


    public FlashcardsDeck(List<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    public String toApkgString() {
        return DECK_HEADER ;
    }
}
