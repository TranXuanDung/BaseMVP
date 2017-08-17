package com.t3h.basemvp.ui.main.liststudent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.t3h.basemvp.R;
import com.t3h.basemvp.common.Constants;
import com.t3h.basemvp.module.ItemStudent;
import com.t3h.basemvp.ui.base.dialog.MessageConfirmDialog;
import com.t3h.basemvp.ui.base.fragment.BaseMvpFragment;
import com.t3h.basemvp.ui.base.fragment.OpenFragmentUltil;
import com.t3h.basemvp.ui.main.editstudentdb.EditDBFragment;
import com.t3h.basemvp.ui.main.insertdb.InsertDBFragment;

import java.util.List;

/**
 * Created by dungtx on 8/15/17.
 */

public class ListStudentFragment extends BaseMvpFragment<IListStudent.Presenter> implements IListStudent.View, ListStudentAdapter.IListStudentAdapter, EditDBFragment.IEditDB, InsertDBFragment.IInsertDB {

    private RecyclerView rcStudent;
    private ListStudentAdapter mAdapter;
    private Toolbar toolbar;
    private List<ItemStudent> itemStudents;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public int getLayoutMain() {
        return R.layout.fragment_student;
    }

    @Override
    public void findViewByIds() {
        toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        rcStudent = (RecyclerView) getView().findViewById(R.id.rc_student);
        mAdapter = new ListStudentAdapter(this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        rcStudent.setLayoutManager(manager);
        rcStudent.setAdapter(mAdapter);
    }

    @Override
    public void initComponents() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Student");
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPresenter = new ListStudentPresenter(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_add_student, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                OpenFragmentUltil.openInsertStudentDB(getBaseActivity(), this, ListStudentFragment.class);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setEvents() {
        mPresenter.queryStudent();
    }

    @Override
    public void finishQueryStudent(List<ItemStudent> response) {
        itemStudents = response;
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void errorQueryStudent(Throwable error) {

    }

    @Override
    public void finishDeleteDB(String reponse) {

    }

    @Override
    public void errorDeleteDB(Throwable error) {
        itemStudents.clear();
        mPresenter.queryStudent();
    }

    @Override
    public int getCount() {
        if (itemStudents == null){
            return 0;
        }
        return itemStudents.size();
    }

    @Override
    public ItemStudent getData(int position) {
        return itemStudents.get(position);
    }

    @Override
    public void onClickButtonDelete(int position) {
        ItemStudent student = itemStudents.get(position);
        new MessageConfirmDialog(getBaseActivity(), getString(R.string.Do_you_want_delete_student), new MessageConfirmDialog.IMessageDialog() {
            @Override
            public void onClickOk() {
                mPresenter.deleteDB(student.getId());
            }

            @Override
            public void onClickCancel() {

            }
        }).show();
    }


    @Override
    public void onClickButtonEdit(int position) {
        ItemStudent student = itemStudents.get(position);
        OpenFragmentUltil.openEditStudentDB(getBaseActivity(), student.getId(), student.getName(), student.getBirth(), student.getAddress(),
                this, ListStudentFragment.class);
    }

    @Override
    public void finishUpdate(String id, String name, String birthday, String address) {
        if ( itemStudents == null || itemStudents.size() == 0 ) {
            return;
        }
        int index = 0;
        for (ItemStudent itemStudent : itemStudents) {
            if ( itemStudent.getId().equals(id)) {
                itemStudent.setAddress(address);
                itemStudent.setBirth(birthday);
                itemStudent.setName(name);
                mAdapter.notifyItemChanged(index);
                break;
            }
            index++;
        }

    }

    @Override
    public void finishInsert() {
        itemStudents.clear();
        mPresenter.queryStudent();
    }
}
