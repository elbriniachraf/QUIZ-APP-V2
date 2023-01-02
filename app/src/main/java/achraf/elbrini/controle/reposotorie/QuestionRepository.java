package achraf.elbrini.controle.reposotorie;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


import achraf.elbrini.controle.model.DBUser;
import achraf.elbrini.controle.model.QuestionModel;
import achraf.elbrini.controle.model.result;

public class QuestionRepository {



    private String quizId;
    private MutableLiveData<ArrayList<QuestionModel>> mld=new MutableLiveData<>();
    private Application application;
    public static String quiz="";
    public static int score=0;
    public static int rightAnswer=0;
    public static int wrongAnswer=0;
    public static ArrayList<QuestionModel> listquestion=new ArrayList<>();
    public static ArrayList<Integer> reponsesIndex=new ArrayList<>();


    public QuestionRepository(Application application) {
        this.application = application;

    }

// get string from json file
    public String loadJSONFromAsset(String file) {
        String json_str = "";
        try {
            InputStream is = application.getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json_str = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json_str;
    }


    // convertir string json to an collections of question and add it in mutablelivedata
    public MutableLiveData<ArrayList<QuestionModel>> getQuestions(String quiz,int nb_question){
        ArrayList<QuestionModel> firstlistquestions=new ArrayList<>();
        String jsonStr;
        switch (quiz){
            case "android studio":{
                jsonStr=loadJSONFromAsset("androidstudio.json");
                break;
            }
            case "java":{
                jsonStr=loadJSONFromAsset("java.json");
                break;
            }
            case "kotlin":{
                jsonStr=loadJSONFromAsset("kotlin.json");
                break;
            }
            default :{
                jsonStr=null;
                break;
            }
        }
        try{
            JSONObject jsonObject=new JSONObject(jsonStr);
            JSONArray questions=jsonObject.getJSONArray("questions");
            for(int i=0;i<questions.length();i++){
                JSONObject question=questions.getJSONObject(i);
                String questionString=question.getString("question");
                String rep1=question.getString("rep1");
                String rep2=question.getString("rep2");
                String rep3=question.getString("rep3");
                int numreponsejuste=question.getInt("numreponsejuste");
                int num=question.getInt("num");
                firstlistquestions.add(
                        new QuestionModel(
                                num,
                                questionString,
                                rep1,
                                rep2,
                                rep3,
                                numreponsejuste
                        )
                );

            }

        }
        catch (JSONException e){
            e.printStackTrace();
        }
        // random of premier list;
        Collections.shuffle(firstlistquestions);
        // set the number of questions 15 30 40
        ArrayList<QuestionModel> Lastlistquestions=new ArrayList<>();
        for(int j=0;j<nb_question;j++){
            Lastlistquestions.add(firstlistquestions.get(j));
        }

        mld.postValue(Lastlistquestions);
        return mld;

    }





}