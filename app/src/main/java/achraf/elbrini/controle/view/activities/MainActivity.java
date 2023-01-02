package achraf.elbrini.controle.view.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import achraf.elbrini.controle.R;
import achraf.elbrini.controle.model.QuizModel;
import achraf.elbrini.controle.model.User;
import achraf.elbrini.controle.view.adapters.QuizListAdapter;
import achraf.elbrini.controle.viewmodel.AuthViewModel;
import achraf.elbrini.controle.viewmodel.QuizViewModel;

public class MainActivity extends AppCompatActivity {
    public QuizViewModel viewmodel;
    RecyclerView rv;
    QuizListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        rv.setLayoutManager(layoutManager);
        viewmodel = new ViewModelProvider(this).get(QuizViewModel.class);


        // get all quiz data from viewmodel and make it in recycler view
        viewmodel.getdata().observe(MainActivity.this, new Observer<ArrayList<QuizModel>>() {
            @Override
            public void onChanged(ArrayList<QuizModel> quizModels) {
                if(quizModels.size()>0){
                    adapter=new QuizListAdapter(quizModels);
                    rv.setAdapter(adapter);

                }
            }
        });





    }

    public void afficher(View view){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("AlertDialog");
        String[] items = {"15 questions","30 questions","40 questions"};
        int checkedItem = 1;
        alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Toast.makeText(MainActivity.this, "Clicked on java", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Clicked on android", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Clicked on Data Structures", Toast.LENGTH_LONG).show();
                        break;

                }
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }

}