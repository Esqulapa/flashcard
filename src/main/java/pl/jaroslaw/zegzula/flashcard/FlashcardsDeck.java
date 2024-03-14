package pl.jaroslaw.zegzula.flashcard;

import java.util.List;
import java.util.stream.Collectors;

public class FlashcardsDeck {
  public static final String DECK_HEADER = "\"Front\",\"Back\"\n";
  private final List<Flashcard> flashcards;

  public FlashcardsDeck(List<Flashcard> flashcards) {
    this.flashcards = flashcards;
  }

  public String toApkgString() {
    return DECK_HEADER
        + flashcards.stream().map(Flashcard::toApkgString).collect(Collectors.joining());
  }

    public int length() {
      return this.flashcards.size();
    }
}
