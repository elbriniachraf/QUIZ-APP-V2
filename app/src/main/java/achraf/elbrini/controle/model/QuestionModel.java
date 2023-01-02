package achraf.elbrini.controle.model;

public class QuestionModel {
   public int num;
   public String question,rep1,rep2,rep3;
   public int numreponsejuste;

    public QuestionModel(int num, String question, String rep1, String rep2, String rep3, int numreponsejuste) {
        this.num = num;
        this.question = question;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.rep3 = rep3;
        this.numreponsejuste = numreponsejuste;
    }
}
