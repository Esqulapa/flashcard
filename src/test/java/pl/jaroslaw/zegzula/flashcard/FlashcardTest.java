package pl.jaroslaw.zegzula.flashcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlashcardTest {

  @Test
  void shouldCreateAFlashcardAndReturnItAsCompatibleApkgString() {
    // given
    String question = "What is the capital of France?";
    String answer =
        "Paris. It is also the largest city in France and serves as the country's economic and cultural center.";
    Flashcard flashcard = new Flashcard(question, answer);
    // when
    String apkgString = flashcard.toApkgString();
    // then
    String expected =
        "\"What is the capital of France?\",\"Paris. It is also the largest city in France and serves as the country's economic and cultural center.\"";
    assertEquals(expected, apkgString);
  }
}
