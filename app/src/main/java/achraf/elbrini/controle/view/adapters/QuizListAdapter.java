package achraf.elbrini.controle.view.adapters;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

import achraf.elbrini.controle.R;
import achraf.elbrini.controle.model.QuizModel;
import achraf.elbrini.controle.view.activities.MainActivity;
import achraf.elbrini.controle.view.activities.QuizActivity;
import achraf.elbrini.controle.viewmodel.QuestViewModel;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.QuizListViewHolder> {

    private ArrayList<QuizModel> listQuiz;

    public QuizListAdapter(ArrayList<QuizModel> listQuiz) {
        this.listQuiz = listQuiz;
    }

    @NonNull
    @Override
    public QuizListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.one_quiz,parent,false);
        return new QuizListViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull QuizListViewHolder holder, int position) {
        QuizModel q=listQuiz.get(position);
        holder.tv.setText(q.getTitle());
        holder.image.setAnimation(q.getImage());
        holder.constraintLayout.setContentDescription(q.getTitle());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quiz=v.getContentDescription().toString();
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(holder.itemView.getContext());
                alertDialog.setTitle("AlertDialog");
                String[] items = {"select the number of questions","15 questions","30 questions","40 questions"};
                int checkedItem = 0;
                alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int nb_questions;
                        Intent intent=new Intent(holder.itemView.getContext(), QuizActivity.class);
                        intent.putExtra("quiz",quiz);
                        switch (which) {
                            case 1:
                                intent.putExtra("nbquestion",15);
                                holder.itemView.getContext().startActivity(intent);


                                break;
                            case 2:
                                intent.putExtra("nbquestion",30);
                                holder.itemView.getContext().startActivity(intent);
                                break;
                            case 3:
                                intent.putExtra("nbquestion",40);
                                holder.itemView.getContext().startActivity(intent);
                                break;
                        }

                    }
                });
                AlertDialog alert = alertDialog.create();
                alert.setCanceledOnTouchOutside(false);
                alert.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listQuiz.size();
    }

    public class QuizListViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        private LottieAnimationView image;
        private ConstraintLayout constraintLayout;
        public QuizListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.titlequiz);
            image=itemView.findViewById(R.id.lottiequiz);
            constraintLayout=itemView.findViewById(R.id.constraintlayout);


        }
    }
}
