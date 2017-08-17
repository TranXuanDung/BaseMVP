package com.t3h.basemvp.ui.base.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.t3h.basemvp.common.Constants;
import com.t3h.basemvp.ui.base.activity.BaseActivity;
import com.t3h.basemvp.ui.base.animation.ScreenAnimation;
import com.t3h.basemvp.ui.main.editstudentdb.EditDBFragment;
import com.t3h.basemvp.ui.main.insertdb.InsertDBFragment;
import com.t3h.basemvp.ui.main.listmovie.OverviewMovieFragment;
import com.t3h.basemvp.ui.main.loginuser.LoginUserFragment;
import com.t3h.basemvp.ui.main.register.RegisterUserFragment;

/**
 * Created by dungtx on 8/9/17.
 */

public class OpenFragmentUltil {

    public static void openOverviewFragment(BaseActivity activity, String img, String name, String rate, String overview){
        FragmentManager manager = activity.getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(OverviewMovieFragment.class.getName());

        if (fragment != null && fragment.isVisible()){
            return;
        }

        Bundle bundle = new Bundle();
        bundle.putString(Constants.AVATAR, img);
        bundle.putString(Constants.NAME_MOVIE, name);
        bundle.putString(Constants.RATING, rate);
        bundle.putString(Constants.OVERVIEW, overview);

        FragmentTransaction transaction = manager.beginTransaction();

        BaseFragment.openFragment(manager, transaction, OverviewMovieFragment.class,
                ScreenAnimation.OPEN_FULL, bundle, false, true );
    }

    public static void openEditStudentDB(BaseActivity activity, String id, String name,
                                         String birth, String address, EditDBFragment.IEditDB interf,
                                         Class< ? extends BaseFragment> clazzHide){
        FragmentManager manager = activity.getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(EditDBFragment.class.getName());

        if (fragment != null && fragment.isVisible()){
            return;
        }

        Bundle bundle = new Bundle();
        bundle.putString(Constants.ID_DB, id);
        bundle.putString(Constants.NAME, name);
        bundle.putString(Constants.BIRTH, birth);
        bundle.putString(Constants.ADDRESS, address);

        FragmentTransaction transaction = manager.beginTransaction();
        BaseFragment.hideFragment(manager, transaction, clazzHide, ScreenAnimation.OPEN_FULL, false, false);
        EditDBFragment dbFragment = new EditDBFragment();
        dbFragment.setInterf(interf);
        dbFragment.setArguments(bundle);
        BaseFragment.openFragment(manager, transaction, dbFragment,  ScreenAnimation.OPEN_FULL, true, true);
    }

    public static void openInsertStudentDB(BaseActivity activity, InsertDBFragment.IInsertDB interf, Class<? extends BaseFragment> clazzHide){
        FragmentManager manager = activity.getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(InsertDBFragment.class.getName());

        if (fragment != null && fragment.isVisible()){
            return;
        }

        FragmentTransaction transaction = manager.beginTransaction();
        BaseFragment.hideFragment(manager, transaction, clazzHide, ScreenAnimation.OPEN_FULL, false, false);
        InsertDBFragment insertDBFragment = new InsertDBFragment();
        insertDBFragment.setInterf(interf);
        BaseFragment.openFragment(manager, transaction, insertDBFragment, ScreenAnimation.OPEN_FULL, true, true);
    }

    public static void openSignIn(BaseActivity activity, Class<? extends BaseFragment> clazzHide){
        FragmentManager manager = activity.getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(LoginUserFragment.class.getName());

        if (fragment != null && fragment.isVisible()){
            return;
        }

        FragmentTransaction transaction = manager.beginTransaction();
        BaseFragment.hideFragment(manager, transaction, clazzHide, ScreenAnimation.OPEN_FULL, false, false);
        LoginUserFragment loginUserFragment = new LoginUserFragment();
        BaseFragment.openFragment(manager, transaction, loginUserFragment, ScreenAnimation.OPEN_FULL, true, true);
    }

    public static void openSignUp(BaseActivity activity, Class<? extends BaseFragment> clazzHide){
        FragmentManager manager = activity.getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(RegisterUserFragment.class.getName());

        if (fragment != null && fragment.isVisible()){
            return;
        }

        FragmentTransaction transaction = manager.beginTransaction();
        BaseFragment.hideFragment(manager, transaction, clazzHide, ScreenAnimation.OPEN_FULL, false, false);
        RegisterUserFragment registerUserFragment = new RegisterUserFragment();
        BaseFragment.openFragment(manager, transaction, registerUserFragment, ScreenAnimation.OPEN_FULL, true, true);
    }
}
