package com.t3h.basemvp.ui.main.register;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.t3h.basemvp.R;
import com.t3h.basemvp.module.ItemUser;
import com.t3h.basemvp.ui.base.fragment.BaseMvpFragment;

/**
 * Created by dungtx on 8/17/17.
 */

public class RegisterUserFragment extends BaseMvpFragment<IRegisterUser.Presenter> implements IRegisterUser.View, View.OnClickListener {

    private EditText edtUserName;
    private EditText edtPassword;
    private EditText edtConfirmPassword;
    private TextView tvSignin;

    @Override
    public int getLayoutMain() {
        return R.layout.fragment_register;
    }

    @Override
    public void findViewByIds() {
        edtUserName = (EditText) getView().findViewById(R.id.edt_username);
        edtPassword = (EditText) getView().findViewById(R.id.edt_password);
        edtConfirmPassword = (EditText) getView().findViewById(R.id.edt_confirm_password);
        tvSignin = (TextView) getView().findViewById(R.id.tv_signin);
    }

    @Override
    public void initComponents() {
        mPresenter = new RegisterUserPresenter(this);
    }

    @Override
    public void setEvents() {
        tvSignin.setOnClickListener(this);
    }

    @Override
    public void finishRegisterUser(ItemUser response) {

    }

    @Override
    public void errorRegisterUser(Throwable error) {
        showMessage("Success");
        onBackRoot();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_signin:
                doneRegister();
                break;

            default:
                break;
        }
    }

    private void doneRegister() {
        String username = edtUserName.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        String repeatPassword = edtConfirmPassword.getText().toString().trim();

        if (username.equals("") || password.equals("") || repeatPassword.equals("")){
            showMessage(R.string.Please_input_full_info);
            return;
        }

        if (!password.equals(repeatPassword)){
            showMessage(R.string.Password_does_not_match_the_confirm_password);
            return;
        }

        mPresenter.registerUser(username, password);
    }
}
