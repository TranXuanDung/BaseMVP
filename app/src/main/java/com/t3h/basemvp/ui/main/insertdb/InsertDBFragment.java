package com.t3h.basemvp.ui.main.insertdb;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.t3h.basemvp.R;
import com.t3h.basemvp.ui.base.fragment.BaseMvpFragment;

/**
 * Created by dungtx on 8/15/17.
 */

public class InsertDBFragment extends BaseMvpFragment<IInsertDB.Presenter> implements IInsertDB.View, View.OnClickListener {

    private EditText edtName;
    private EditText edtBirth;
    private EditText edtAddress;
    private Button btnAdd;
    private IInsertDB mInterf;

    public void setInterf(IInsertDB interf){
        mInterf = interf;
    }

    @Override
    public int getLayoutMain() {
        return R.layout.fragment_demo_insert_dbwebservice;
    }

    @Override
    public void findViewByIds() {
        edtName = (EditText) getView().findViewById(R.id.edt_name);
        edtBirth = (EditText) getView().findViewById(R.id.edt_birth);
        edtAddress = (EditText) getView().findViewById(R.id.edt_address);
        btnAdd = (Button) getView().findViewById(R.id.btn_add);
    }

    @Override
    public void initComponents() {
        mPresenter = new InsertDBPresenter(this);
    }

    @Override
    public void setEvents() {
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void finishUpdateDB(String response) {
        showMessage("Success");
    }

    @Override
    public void errorUpdateDB(Throwable error) {
        showMessage("Success");
        if (mInterf != null){
            mInterf.finishInsert();
        }
        onBackRoot();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                doneAddDB();
                break;

            default:
                break;
        }
    }

    private void doneAddDB() {
        String name = edtName.getText().toString().trim();
        String birth = edtBirth.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();

        if (name.equals("") || birth.equals("") || address.equals("")){
            showMessage(R.string.Please_input_full_info);
            return;
        }

        mPresenter.insertDB(name, birth, address);
    }

    public interface IInsertDB{
        void finishInsert();
    }
}
