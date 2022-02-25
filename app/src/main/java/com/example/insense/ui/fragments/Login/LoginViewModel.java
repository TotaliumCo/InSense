package com.example.insense.ui.fragments.Login;

import androidx.lifecycle.ViewModel;

import com.example.insense.services.authentification.FirebaseUserLiveData;

public class LoginViewModel extends ViewModel {
    enum AuthenticationState {
        AUTHENTICATED, UNAUTHENTICATED, INVALID_AUTHENTICATION
    }

    FirebaseUserLiveData authenticationState = FirebaseUserLiveData().map{
}