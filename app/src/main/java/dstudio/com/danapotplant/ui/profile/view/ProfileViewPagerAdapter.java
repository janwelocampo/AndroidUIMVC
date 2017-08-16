package dstudio.com.danapotplant.ui.profile.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import dstudio.com.danapotplant.R;
import dstudio.com.danapotplant.ui.profile.fragment.profilefragment.view.ProfileFragment;
import dstudio.com.danapotplant.ui.profile.fragment.reviewfragment.ReviewFragment;


/**
 * Created by janwelcris on 8/15/2017.
 */

public class ProfileViewPagerAdapter extends FragmentStatePagerAdapter {
    private Context context;

    public ProfileViewPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.context = context;
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
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.label_tab_profile);
            case 1:
            default:
                return context.getString(R.string.label_tab_review);
        }
    }

}