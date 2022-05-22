package com.example.insense.ui.tabs.profile;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.insense.R;
import com.example.insense.application.App;
import com.example.insense.databinding.FragmentProfileBinding;
import com.example.insense.repository.ActivityRepository;
import com.example.insense.repository.OccupationRepository;
import com.example.insense.repository.room.activityDB.Activity;
import com.example.insense.repository.room.occupationDB.Occupation;
import com.example.insense.repository.room.occupationDB.OccupationDAO;
import com.example.insense.ui.authentication.authentication.Login.LoginViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;


public class ProfileFragment extends Fragment {
    private FragmentProfileBinding fragmentProfileBinding;
    LoginViewModel viewModel = new LoginViewModel();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    ActivityRepository repository_activity = App.instance.getActivityRepository();
    OccupationRepository repository_occupation = App.instance.getOccupationRepository();
    List<Activity> all;

    OccupationRepository occupationRepository = App.instance.getOccupationRepository();
    List<Occupation> all_occup;
    OccupationDAO occupationDAO;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProfileBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false);


        fragmentProfileBinding = FragmentProfileBinding.inflate(inflater, container, false);
        fragmentProfileBinding.textViewProfileEmail.setText( user.getEmail());
        all = repository_activity.all_activities();
        fragmentProfileBinding.texViewNumberOfActivities.setText( "" +all.size());
        all_occup = occupationRepository.get_everything_from_occupations();


        int count_sport = 0;
        int count_music = 0;
        int count_study = 0;
        int count_work = 0;
        int count_hobby = 0;
        int count_family = 0;
        int count_other = 0;
        for(int i = 0; i < all_occup.size(); i++){
            for(int j = 0; j < all.size(); j++) {
                if(all.get(j).occupation.equals(all_occup.get(i).name)) {
                    switch (all_occup.get(i).category) {
                        case "спорт":
                            count_sport++;
                            break;
                        case "музыка":
                            count_music++;
                            break;
                        case "учеба":
                            count_study++;
                            break;
                        case "работа":
                            count_work++;
                            break;
                        case "хобби":
                            count_hobby++;
                            break;
                        case "семья":
                            count_family++;
                            break;
                        case "другое":
                            count_other++;
                            break;
                    }
                }
            }

        }
        fragmentProfileBinding.textViewSport.setText(" "+count_sport);
        fragmentProfileBinding.textViewMusic.setText(" "+count_music);
        fragmentProfileBinding.textViewStudy.setText(" "+count_study);
        fragmentProfileBinding.textViewWork.setText(" "+count_work);
        fragmentProfileBinding.textViewHobby.setText(" "+count_hobby);
        fragmentProfileBinding.textViewFamily.setText(" "+count_family);
        fragmentProfileBinding.textViewOther.setText(" "+count_other);

        fragmentProfileBinding.buttonToSettings2.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
        });

        return fragmentProfileBinding.getRoot();
    }

}