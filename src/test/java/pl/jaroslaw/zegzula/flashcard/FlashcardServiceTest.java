package pl.jaroslaw.zegzula.flashcard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@ExtendWith(MockitoExtension.class)
class FlashcardServiceTest {

  @InjectMocks FlashcardService flashcardService;

  @Test
  void shouldCreateDeckFromGivenFile() throws IOException {
    // given
    String filePath = "src/main/java/pl/jaroslaw/zegzula/data/pytania — 2 kopia.txt";

    byte[] bytes = Files.readAllBytes(Paths.get(filePath));

    MockMultipartFile file =
        new MockMultipartFile("file", "pytania — 2 kopia.txt", "text/plain", bytes);

    // when
    FlashcardsDeck deck =
        flashcardService.createFlashcardsDeck(new MultipartToStringMapper(file).toListOfStrings());

    // then
    Assertions.assertEquals(9, deck.length());
  }
}
