package dstudio.com.danapotplant.ui.profile.fragment.reviewfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import dstudio.com.danapotplant.R;

/**
 * Created by janwelcris on 8/15/2017.
 */

public class ReviewFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_review, container, false);
        ButterKnife.bind(this, v);

        //Don't know what to do here.
        // API Response says nothing about it. For now I just set the layout static

        return v;
    }

    public static ReviewFragment newInstance() {
        ReviewFragment f = new ReviewFragment();

        return f;
    }
}