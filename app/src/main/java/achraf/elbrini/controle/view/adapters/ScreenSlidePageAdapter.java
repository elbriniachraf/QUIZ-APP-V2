package achraf.elbrini.controle.view.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import achraf.elbrini.controle.view.fragements.Onboardingfragement1;
import achraf.elbrini.controle.view.fragements.Onboardingfragement2;
import achraf.elbrini.controle.view.fragements.Onboardingfragement3;

public class ScreenSlidePageAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES=3;
    public ScreenSlidePageAdapter(@NonNull FragmentManager fm){
        super(fm);
    }
    @Nullable
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:{
                Onboardingfragement1 tab1=new Onboardingfragement1();
                return tab1;
            }
            case 1:{
                Onboardingfragement2 tab2=new Onboardingfragement2();
                return tab2;
            }
            case 2:{
                Onboardingfragement3 tab3=new Onboardingfragement3();
                return tab3;
            }

        }
        return null;
    }

    public int getCount(){
        return NUM_PAGES;
    }
}
