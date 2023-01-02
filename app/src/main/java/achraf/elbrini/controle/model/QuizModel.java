package achraf.elbrini.controle.model;

public class QuizModel {
    private int quizId,image;
    private String title;
    private int nb_questions;

    public QuizModel() {
    }
    public QuizModel(int quizId, int image, String title, int nb_questions) {
        this.quizId = quizId;
        this.image = image;
        this.title = title;
        this.nb_questions = nb_questions;
    }

    // les getters et setters

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNb_questions() {
        return nb_questions;
    }

    public void setNb_questions(int nb_questions) {
        this.nb_questions = nb_questions;
    }
}
