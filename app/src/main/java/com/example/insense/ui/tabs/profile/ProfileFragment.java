package com.example.insense.ui.tabs.profile;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.insense.R;
import com.example.insense.databinding.FragmentProfileBinding;
import com.example.insense.ui.authentication.authentication.Login.LoginViewModel;
import com.firebase.ui.auth.AuthUI;


public class ProfileFragment extends Fragment {
    private FragmentProfileBinding fragmentProfileBinding;
    LoginViewModel viewModel = new LoginViewModel();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProfileBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false);

        fragmentProfileBinding = FragmentProfileBinding.inflate(inflater, container, false);
        fragmentProfileBinding.buttonToSettings2.setOnClickListener(v -> {
            AuthUI.getInstance().signOut(getContext());
            NavHostFragment.findNavController(ProfileFragment.this).navigate(R.id.action_profileFragment_to_starterFragment);
        });
        fragmentProfileBinding.buttonToSettings.setOnClickListener(v -> NavHostFragment.findNavController(ProfileFragment.this).navigate(R.id.action_profileFragment_to_settingsFragment));
        return fragmentProfileBinding.getRoot();
    }

}