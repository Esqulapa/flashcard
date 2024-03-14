package pl.jaroslaw.zegzula.flashcard;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class FlashcardService {

  public static final String ANSWER_REGEX = "\\s*\\[Odpowiedź\\]\\s";
  private final String QUESTION_PREFIX_REGEX = "\\s*\\[Pytanie\\]\\s";

  public FlashcardsDeck createFlashcardsDeck(List<String> questions) {
    return toFlashcardDeck(questions);
  }

  private FlashcardsDeck toFlashcardDeck(List<String> allLines) {

    String allQuestionsInLine =
        allLines.stream().filter(line -> !line.isEmpty()).collect(Collectors.joining(" "));

    List<String> questionsAndAnswersWithAnswerPrefix =
        Arrays.asList(allQuestionsInLine.split(QUESTION_PREFIX_REGEX));

    final List<Flashcard> flashcards =
        questionsAndAnswersWithAnswerPrefix.stream()
            .filter(line -> !line.isEmpty())
            .map(line -> line.split(ANSWER_REGEX))
            .map(questionAnswerPairArray ->
                    new Flashcard(questionAnswerPairArray[0], questionAnswerPairArray[1])).toList();
    return new FlashcardsDeck(flashcards);
  }

}
