package achraf.elbrini.controle.reposotorie;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import achraf.elbrini.controle.R;
import achraf.elbrini.controle.model.QuizModel;

public class QuizListReposotory {
    MutableLiveData<ArrayList<QuizModel>> mutablelivedataquiz;
    public QuizListReposotory() {
        this.mutablelivedataquiz = new MutableLiveData<>();
    }

    public MutableLiveData<ArrayList<QuizModel>> loaddata(){
        ArrayList<QuizModel> listquiz=new ArrayList<>();
        listquiz.add(new QuizModel(1, R.raw.androidstudio,"android studio",40));
        listquiz.add(new QuizModel(2, R.raw.java,"java",40));
        listquiz.add(new QuizModel(3, R.raw.kotlin,"kotlin",40));
        listquiz.add(new QuizModel(4, R.raw.flutter,"flutter",40));

        this.mutablelivedataquiz.postValue(listquiz);
        return this.mutablelivedataquiz;
    }
}
