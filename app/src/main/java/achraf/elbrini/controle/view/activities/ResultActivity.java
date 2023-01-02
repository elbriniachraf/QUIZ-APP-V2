package achraf.elbrini.controle.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import achraf.elbrini.controle.R;
import achraf.elbrini.controle.view.fragements.RegisterFragement;
import achraf.elbrini.controle.view.fragements.ResultFragement;
import achraf.elbrini.controle.view.fragements.ReviewFragement;
import achraf.elbrini.controle.viewmodel.QuestViewModel;

public class ResultActivity extends AppCompatActivity {
    QuestViewModel viewmodel;
    LinearLayout review_tab,result_tab;
    TextView tab1_tit,tab2_tit;
    ImageView im1,im2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        review_tab=findViewById(R.id.review_tab);
        result_tab=findViewById(R.id.result_tab);
        tab1_tit=findViewById(R.id.tab_title_reponse);
        tab2_tit=findViewById(R.id.tab_title_review);
        im1=findViewById(R.id.img_result);
        im2=findViewById(R.id.img_review);
        review_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView4, ReviewFragement.class,null)
                        .commit();
                tab2_tit.setVisibility(View.VISIBLE);
                tab1_tit.setVisibility(View.GONE);
                result_tab.setBackgroundColor(Color.TRANSPARENT);
                im1.setImageResource(R.drawable.ic_baseline_cloud_done_24);
                im2.setImageResource(R.drawable.ic_baseline_reviews_24_v2);
                review_tab.setBackgroundColor(R.color.colorToolbarStart);


            }
        });
        result_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView4, ResultFragement.class,null)
                        .commit();
                tab2_tit.setVisibility(View.GONE);
                tab1_tit.setVisibility(View.VISIBLE);
                review_tab.setBackgroundColor(Color.TRANSPARENT);
                im1.setImageResource(R.drawable.ic_baseline_cloud_done_24_v2);
                im2.setImageResource(R.drawable.ic_baseline_reviews_24);
                result_tab.setBackgroundColor(R.color.colorToolbarStart);


            }
        });

    }
}