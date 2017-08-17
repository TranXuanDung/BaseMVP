package com.t3h.basemvp.ui.main.loginuser;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.t3h.basemvp.R;
import com.t3h.basemvp.module.ItemUser;
import com.t3h.basemvp.ui.base.fragment.BaseMvpFragment;

import java.util.List;

/**
 * Created by dungtx on 8/17/17.
 */

public class LoginUserFragment extends BaseMvpFragment<ILoginUser.Presenter> implements ILoginUser.View, View.OnClickListener {

    private EditText edtUsername;
    private EditText edtPassword;
    private TextView tvLogin;
    private List<ItemUser> itemUsers;

    @Override
    public int getLayoutMain() {
        return R.layout.fragment_login;
    }

    @Override
    public void findViewByIds() {
        edtUsername = (EditText) getView().findViewById(R.id.edt_username);
        edtPassword = (EditText) getView().findViewById(R.id.edt_password);
        tvLogin = (TextView) getView().findViewById(R.id.tv_login);
    }

    @Override
    public void initComponents() {
        mPresenter = new LoginUserPresenter(this);

    }

    @Override
    public void setEvents() {
        mPresenter.loginUser();
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void finishLoginUser(List<ItemUser> response) {
        itemUsers = response;
    }

    @Override
    public void errorLoginUser(Throwable error) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login:
                doneLogin();
                break;

            default:
                break;
        }
    }

    private void doneLogin() {
        if ( itemUsers == null ) {
            showMessage("null");
            return;
        }
        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        for (ItemUser user : itemUsers){
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())){
                showMessage("Success");

            }else {
                showMessage("Error");
            }
        }
    }
}
