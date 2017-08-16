package dstudio.com.danapotplant.ui.profile.view;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dstudio.com.danapotplant.R;
import dstudio.com.danapotplant.dagger.applications.App;
import dstudio.com.danapotplant.model.Profile;
import dstudio.com.danapotplant.ui.profile.presenter.ProfilePresenter;

public class ProfileActivity extends AppCompatActivity implements ProfileView, TabLayout.OnTabSelectedListener{

    @Inject
    ProfilePresenter presenter;

    @BindView(R.id.profile_progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tab)
    TabLayout tabLayout;

    @BindView(R.id.text_name)
    TextView textName;

    @BindView(R.id.text_shadow_name)
    TextView textShadowName;

    @BindView(R.id.image_prof_pic)
    ImageView imageProfilePic;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.floating_save_profile)
    FloatingActionButton floatingSaveProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getAppComponent(this).inject(this);

        ButterKnife.bind(this);

        presenter.setView(this);

        presenter.getProfileData();

        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.profile_menu);

        tabLayout.addOnTabSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, ""+errorMessage,Toast.LENGTH_LONG).show();
    }


    @Override
    public void showProfileData(Profile profile) {
        Picasso.with(this)
                .load(profile.getAvatar())
                .into(imageProfilePic);

        textName.setText(profile.getUsername());
        textShadowName.setText(profile.getUsername());

        viewPager.setAdapter(new ProfileViewPagerAdapter(this,getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab.getText().toString().equals(getString(R.string.label_tab_profile))){
            floatingSaveProfile.setVisibility(View.VISIBLE);
        }
        else
        {
            floatingSaveProfile.setVisibility(View.GONE);
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
