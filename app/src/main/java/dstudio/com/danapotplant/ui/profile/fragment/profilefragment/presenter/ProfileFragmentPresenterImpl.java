package dstudio.com.danapotplant.ui.profile.fragment.profilefragment.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dstudio.com.danapotplant.dagger.applications.App;
import dstudio.com.danapotplant.model.AddMore;
import dstudio.com.danapotplant.model.Exam;
import dstudio.com.danapotplant.model.Skill;
import dstudio.com.danapotplant.ui.profile.fragment.profilefragment.view.ProfileFragmentView;
import dstudio.com.danapotplant.util.DanaPotPlantUtils;
import dstudio.com.danapotplant.util.ObjectManager;

/**
 * Created by janwelcris on 8/15/2017.
 */

public class ProfileFragmentPresenterImpl implements ProfileFragmentPresenter, DanaPotPlantUtils {

    @Inject
    ObjectManager objectManager;

    private ProfileFragmentView view;

    public ProfileFragmentPresenterImpl(Context context) {
        ((App) context).getAppComponent(context).inject(this);

    }


    @Override
    public void setView(ProfileFragmentView view) {
        this.view = view;
    }

    @Override
    public void getProfileTabData() {

        ArrayList<Object> items = new ArrayList<>();



        String skillString = objectManager.getString(SKILLS);

        String examString = objectManager.getString(EXAMS);

        if (skillString != null){
            items.add("My Skills");

            Type listType = new TypeToken<ArrayList<Skill>>(){}.getType();
            List<Skill> skillList = new Gson().fromJson(skillString, listType);

            for (int i = 0; i < skillList.size(); i++){
                items.add(skillList.get(i));
            }

            //dont know where to get data. Just add this value
            items.add(new AddMore("Add more skill (5/250)", 1));
        }

        if (examString != null){
            items.add("My Exams");

            Type listType = new TypeToken<ArrayList<Exam>>(){}.getType();
            List<Exam> examList = new Gson().fromJson(examString, listType);

            for (int i = 0; i < examList.size(); i++){
                items.add(examList.get(i));
            }

            //dont know where to get data. Just add this value
            items.add(new AddMore("Take more Class", 2));
        }

        view.showProfileTabData(items);
    }
}
