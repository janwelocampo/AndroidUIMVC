package dstudio.com.danapotplant.ui.profile.fragment.profilefragment.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dstudio.com.danapotplant.R;
import dstudio.com.danapotplant.model.Exam;
import dstudio.com.danapotplant.model.Profile;
import dstudio.com.danapotplant.model.Skill;

/**
 * Created by janwelcris on 8/16/2017.
 */

public class ProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> items;

    private final int EXAM = 0, SKILL = 1, TITLE = 2, BUTTON = 3;

    public ProfileAdapter(List<Object> items) {
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            case TITLE:
                View v1 = inflater.inflate(R.layout.layout_profile_title, parent, false);
                viewHolder = new ViewHolderTitle(v1);
                break;
            case EXAM:
                View v2 = inflater.inflate(R.layout.layout_profile_exam, parent, false);
                viewHolder = new ViewHolderExam(v2);
                break;
            case SKILL:
                View v3 = inflater.inflate(R.layout.layout_profile_skill, parent, false);
                viewHolder = new ViewHolderSkill(v3);
                break;
            case BUTTON:
                View v4 = inflater.inflate(R.layout.layout_profile_button, parent, false);
                viewHolder = new ViewHolderButton(v4);
                break;
            default:
                View v = inflater.inflate(R.layout.layout_profile_button, parent, false);
                viewHolder = new ViewHolderButton(v);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case TITLE:
                ViewHolderTitle viewHolderTitle = (ViewHolderTitle) viewHolder;
                configureViewHolderTitle(viewHolderTitle, position);
                break;
            case EXAM:
                ViewHolderExam viewHolderExam = (ViewHolderExam) viewHolder;
                configureViewHolderExam(viewHolderExam, position);
                break;
            case SKILL:
                ViewHolderSkill viewHolderSkill = (ViewHolderSkill) viewHolder;
                configureViewHolderSkill(viewHolderSkill, position);
                break;
            case BUTTON:
                ViewHolderButton viewHolderButton = (ViewHolderButton) viewHolder;
                configureViewHolderButton(viewHolderButton, position);
                break;

            default:
                ViewHolderButton defaultHolder = (ViewHolderButton) viewHolder;
                configureViewHolderButton(defaultHolder, position);
                break;
        }
    }

    private void configureViewHolderExam(ViewHolderExam vh, int position) {
        Exam exam = (Exam) items.get(position);
        vh.textExam.setText(exam.getName());
        vh.seekBar.setProgress(exam.getProgress());
    }

    private void configureViewHolderSkill(ViewHolderSkill vh, int position) {
        Skill skill = (Skill) items.get(position);
        vh.textSkill.setText(skill.getName());

    }

    private void configureViewHolderButton(ViewHolderButton vh, int position) {
        vh.buttonAddMore.setText("Add more");

    }

    private void configureViewHolderTitle(ViewHolderTitle vh, int position) {
        vh.textTitle.setText((CharSequence) items.get(position));
    }



    @Override
    public int getItemCount() {
        return  items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof String) {
            return TITLE;
        } else if (items.get(position) instanceof Exam) {
            return EXAM;
        }
        else if (items.get(position) instanceof Skill) {
            return SKILL;
        }
        else if (items.get(position) instanceof Integer) {
            return BUTTON;
        }
        return -1;
    }

    static class ViewHolderTitle extends RecyclerView.ViewHolder {
        @BindView(R.id.textview_title)
        TextView textTitle;


        public ViewHolderTitle(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

    static class ViewHolderExam extends RecyclerView.ViewHolder {
        @BindView(R.id.textview_exam)
        TextView textExam;

        @BindView(R.id.seekBar)
        SeekBar seekBar;

        public ViewHolderExam(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

    static class ViewHolderSkill extends RecyclerView.ViewHolder {
        @BindView(R.id.textview_skill)
        TextView textSkill;

        public ViewHolderSkill(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

    static class ViewHolderButton extends RecyclerView.ViewHolder {
        @BindView(R.id.button_add_more)
        Button buttonAddMore;

        public ViewHolderButton(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
