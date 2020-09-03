package com.programmergwin.gadsproject.controls;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.programmergwin.gadsproject.LearningLeadersFragment;
import com.programmergwin.gadsproject.SkillIQLeadersFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment;
        if(i==0){
            fragment  = new LearningLeadersFragment();
        }else {
            fragment  = new SkillIQLeadersFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return "Learning Leaders";
        else
            return "Skill IQ Leaders";
    }
}
