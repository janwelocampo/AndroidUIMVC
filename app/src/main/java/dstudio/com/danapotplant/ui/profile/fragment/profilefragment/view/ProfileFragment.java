package dstudio.com.danapotplant.ui.profile.fragment.profilefragment.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dstudio.com.danapotplant.R;
import dstudio.com.danapotplant.dagger.applications.App;
import dstudio.com.danapotplant.ui.profile.fragment.profilefragment.presenter.ProfileFragmentPresenter;

/**
 * Created by janwelcris on 8/15/2017.
 */

public class ProfileFragment extends Fragment implements ProfileFragmentView{

    @Inject
    ProfileFragmentPresenter presenter;

    @BindView(R.id.recycle_profile)
    RecyclerView recyclerViewProfile;

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getActivity().getApplication()).getAppComponent(getActivity()).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        ButterKnife.bind(this, v);

        presenter.setView(this);
        presenter.getProfileTabData();
        return v;
    }

    public static ProfileFragment newInstance() {

        ProfileFragment f = new ProfileFragment();
        return f;
    }

    @Override
    public void showProfileTabData(ArrayList<Object> items) {
        recyclerViewProfile.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewProfile.setAdapter(new ProfileAdapter(items));
    }
}