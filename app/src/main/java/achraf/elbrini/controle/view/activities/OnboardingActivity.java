package achraf.elbrini.controle.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import achraf.elbrini.controle.R;
import achraf.elbrini.controle.view.adapters.ScreenSlidePageAdapter;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager viewpager;
    Animation anim;
    private ScreenSlidePageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        // disable navbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        viewpager=findViewById(R.id.pager);
        pageAdapter=new ScreenSlidePageAdapter(getSupportFragmentManager());
        viewpager.setAdapter(pageAdapter);
        anim= AnimationUtils.loadAnimation(this,R.anim.o_b_anim);
        viewpager.startAnimation(anim);


    }
}