package dstudio.com.danapotplant.ui.profile.fragment.activityview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import dstudio.com.danapotplant.ui.profile.fragment.profilefragment.view.ProfileFragment;
import dstudio.com.danapotplant.ui.profile.fragment.reviewfragment.ReviewFragment;

/**
 * Created by janwelcris on 8/15/2017.
 */

public class ProfileViewPagerAdapter extends FragmentStatePagerAdapter {

    public ProfileViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        switch(pos) {

            case 0: return ProfileFragment.newInstance();
            case 1: return ReviewFragment.newInstance();
            default: return ProfileFragment.newInstance();
        }
    }
    @Override
    public int getItemPosition(Object object){
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public int getCount() {
        return 4;
    }

}