package achraf.elbrini.controle.model;

public class result {
    public int id_user;
    public String quiz;
    public int score;
    public int rightAnswer;
    public int wrongAnswer;
    public int time;

    public result(int id_user, String quiz, int score,int rightAnswer,int wrongAnswer , int time) {
        this.id_user = id_user;
        this.quiz = quiz;
        this.score = score;
        this.rightAnswer=rightAnswer;
        this.wrongAnswer=wrongAnswer;
        this.time=time;
    }
}

