package com.t3h.basemvp.ui.main.editstudentdb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.t3h.basemvp.R;
import com.t3h.basemvp.common.Constants;
import com.t3h.basemvp.ui.base.fragment.BaseMvpFragment;

/**
 * Created by dungtx on 8/15/17.
 */

public class EditDBFragment extends BaseMvpFragment<IEditDB.Presenter> implements IEditDB.View, View.OnClickListener {

    private EditText edtName;
    private EditText edtBirth;
    private EditText edtAddress;
    private Bundle bundle;
    private Button btnAdd;
    private String id;
    private IEditDB mInterf;

    public void setInterf(IEditDB interf) {
        mInterf = interf;
    }

    @Override
    public int getLayoutMain() {
        return R.layout.fragment_edit_student;
    }

    @Override
    public void findViewByIds() {
        edtName = (EditText) getView().findViewById(R.id.edt_name);
        edtBirth = (EditText) getView().findViewById(R.id.edt_birth);
        edtAddress = (EditText) getView().findViewById(R.id.edt_address);
        btnAdd = (Button) getView().findViewById(R.id.btn_add);
        bundle = getArguments();
    }

    @Override
    public void initComponents() {
        id = bundle.getString(Constants.ID_DB);
        edtName.setText(bundle.getString(Constants.NAME));
        edtBirth.setText(bundle.getString(Constants.BIRTH));
        edtAddress.setText(bundle.getString(Constants.ADDRESS));

        mPresenter = new EditDBPresenter(this);
    }

    @Override
    public void setEvents() {
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void finishEditDB(String response) {
        showMessage("Success");
    }

    @Override
    public void errorEditDB(Throwable error) {
        showMessage("Error");
        if ( mInterf != null ) {
            mInterf.finishUpdate(bundle.getString(Constants.ID_DB),
                    edtName.getText().toString(), edtBirth.getText().toString(), edtAddress.getText().toString());
        }
        onBackRoot();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next:
                doneEditDB();
                break;

            default:
                break;
        }
    }

    private void doneEditDB() {
        String name = edtName.getText().toString().trim();
        String birth = edtBirth.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();

        if (name.equals("") || birth.equals("") || address.equals("")){
            showMessage(R.string.Please_input_full_info);
            return;
        }

        mPresenter.editDB(id, name, birth, address);
    }

    public interface IEditDB{
        void finishUpdate(String id,String name, String birthday, String address);
    }
}
