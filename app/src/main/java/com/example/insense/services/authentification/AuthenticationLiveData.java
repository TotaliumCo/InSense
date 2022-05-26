package com.example.insense.services.authentification;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseUser;

final class LoginViewModel2$$special$$inlined$map$1 implements Function {
    public final Object apply(Object it) {
        FirebaseUser user = (FirebaseUser) it;
        return user != null ? AuthenticationLiveData.AuthenticationState.AUTHENTICATED : AuthenticationLiveData.AuthenticationState.UNAUTHENTICATED;
    }
}

public class AuthenticationLiveData extends ViewModel {
    public enum AuthenticationState {
        AUTHENTICATED, UNAUTHENTICATED, INVALID_AUTHENTICATION
    }
    public LiveData authenticationState = Transformations.map((LiveData) (new FirebaseUserLiveData()), (Function) (new LoginViewModel2$$special$$inlined$map$1()));
}