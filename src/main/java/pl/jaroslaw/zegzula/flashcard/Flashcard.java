package pl.jaroslaw.zegzula.flashcard;

public class Flashcard {

    private final String question;
    private final String answer;

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String toApkgString() {
        return "\"" + question + "\""+ ",\"" + answer + "\"";
    }
}
