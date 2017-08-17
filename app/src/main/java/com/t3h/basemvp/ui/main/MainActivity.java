package com.t3h.basemvp.ui.main;

import android.support.v4.app.FragmentManager;

import com.t3h.basemvp.R;
import com.t3h.basemvp.ui.base.activity.BaseActivity;
import com.t3h.basemvp.ui.base.animation.ScreenAnimation;
import com.t3h.basemvp.ui.base.fragment.BaseFragment;
import com.t3h.basemvp.ui.main.insertdb.InsertDBFragment;
import com.t3h.basemvp.ui.main.liststudent.ListStudentFragment;
import com.t3h.basemvp.ui.main.loginuser.LoginUserFragment;
import com.t3h.basemvp.ui.main.register.RegisterUserFragment;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutMain() {
        return R.layout.activity_main;
    }

    @Override
    public void findViewByIds() {

    }

    @Override
    public void initComponents() {
        FragmentManager manager = getSupportFragmentManager();
        BaseFragment.
                openFragment(manager,
                        manager.beginTransaction(),
                        FragmentMain.class,
                        ScreenAnimation.NONE, null, false, true);
    }

    @Override
    public void setEvents() {

    }
}
