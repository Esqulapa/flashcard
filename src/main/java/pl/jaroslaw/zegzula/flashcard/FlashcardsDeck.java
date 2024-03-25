package pl.jaroslaw.zegzula.flashcard;

import java.util.List;
import java.util.stream.Collectors;

public class FlashcardsDeck {
  private final List<Flashcard> flashcards;

  public FlashcardsDeck(List<Flashcard> flashcards) {
    this.flashcards = flashcards;
  }

  public String deckToString() {
    return flashcards.stream().map(Flashcard::flashcardToString).collect(Collectors.joining());
  }

  public int length() {
    return this.flashcards.size();
  }
}
