package com.t3h.basemvp.ui.main;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.t3h.basemvp.R;
import com.t3h.basemvp.ui.base.fragment.BaseFragment;
import com.t3h.basemvp.ui.base.fragment.OpenFragmentUltil;

/**
 * Created by dungtx on 8/17/17.
 */

public class FragmentMain extends BaseFragment implements View.OnClickListener {

    private TextView btnSignIn;
    private TextView btnSignUp;

    @Override
    public int getLayoutMain() {
        return R.layout.fragment_main;
    }

    @Override
    public void findViewByIds() {
        btnSignIn = (TextView) getView().findViewById(R.id.btn_sign_in);
        btnSignUp = (TextView) getView().findViewById(R.id.btn_sign_up);
    }

    @Override
    public void initComponents() {

    }

    @Override
    public void setEvents() {
        btnSignUp.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sign_in:
                OpenFragmentUltil.openSignIn(getBaseActivity(), FragmentMain.class);
                break;
            case R.id.btn_sign_up:
                OpenFragmentUltil.openSignUp(getBaseActivity(), FragmentMain.class);
                break;

            default:
                break;
        }
    }
}
