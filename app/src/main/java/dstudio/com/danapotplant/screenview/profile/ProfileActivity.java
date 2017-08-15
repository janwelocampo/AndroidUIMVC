package dstudio.com.danapotplant.screenview.profile;

import android.support.design.widget.TabLayout;
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
import dstudio.com.danapotplant.model.Profile;
import dstudio.com.danapotplant.dagger.applications.ProfileApplication;

public class ProfileActivity extends AppCompatActivity implements ProfileView{

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ProfileApplication) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);

        presenter.setView(this);

        presenter.getProfileData();

        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.profile_menu);
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

        //Toast.makeText(this, ""+profile.getUsername(),Toast.LENGTH_LONG).show();
    }
}
