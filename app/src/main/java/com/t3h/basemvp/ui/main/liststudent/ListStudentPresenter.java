package com.t3h.basemvp.ui.main.liststudent;

import com.t3h.basemvp.interact.AccountInteractor;
import com.t3h.basemvp.module.ItemStudent;
import com.t3h.basemvp.ui.base.Action;
import com.t3h.basemvp.ui.base.BasePresenter;

import java.util.List;

/**
 * Created by dungtx on 8/15/17.
 */

public class ListStudentPresenter extends BasePresenter<IListStudent.View> implements IListStudent.Presenter {
    public ListStudentPresenter(IListStudent.View view) {
        super(view);
    }

    @Override
    public void queryStudent() {
        interact(AccountInteractor.getInstance().queryStudent(), new Action<List<ItemStudent>>() {
            @Override
            public void call(List<ItemStudent> itemStudents) {
                mView.finishQueryStudent(itemStudents);
            }
        }, new Action<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                mView.errorQueryStudent(throwable);
            }
        });
    }

    @Override
    public void deleteDB(String id) {
        interact(AccountInteractor.getInstance().deleteDB(id), new Action<String>() {
            @Override
            public void call(String s) {
                mView.finishDeleteDB(s);
            }
        }, new Action<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                mView.errorDeleteDB(throwable);
            }
        });
    }
}
