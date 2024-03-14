package pl.jaroslaw.zegzula.flashcard;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlashcardsDeckTest {

  @Test
  void shouldCrateAFlashCardDeckAndReturnItAsCompatibleApkgString() {
    // given
    List<Flashcard> flashcards =
        List.of(
            new Flashcard(
                "What is the capital of France?",
                "Paris. It is also the largest city in France and serves as the country's economic and cultural center."),
            new Flashcard(
                "What is the capital of Germany?",
                "Berlin. It is the largest city in Germany and has a population of 3.7 million people."));
    FlashcardsDeck flashcardsDeck = new FlashcardsDeck(flashcards);

    // when
    String result = flashcardsDeck.toApkgString();
    // then
    String expected =
        """
                "Front","Back"
                "What is the capital of France?","Paris. It is also the largest city in France and serves as the country's economic and cultural center."
                "What is the capital of Germany?","Berlin. It is the largest city in Germany and has a population of 3.7 million people."
                """;
    assertEquals(expected, result);
  }
}
