package com.t3h.basemvp.ui.main.liststudent;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t3h.basemvp.R;
import com.t3h.basemvp.module.ItemStudent;
import com.t3h.basemvp.ui.main.playmusic.IGetPosition;

/**
 * Created by dungtx on 8/15/17.
 */

public class ListStudentAdapter extends RecyclerView.Adapter<ListStudentAdapter.ViewHolderListStudent> implements View.OnClickListener {

    private IListStudentAdapter mInterf;

    public ListStudentAdapter(IListStudentAdapter interf) {
        mInterf = interf;
    }

    @Override
    public ViewHolderListStudent onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_student, parent, false);
        return new ViewHolderListStudent(view, this);
    }

    @Override
    public void onBindViewHolder(ViewHolderListStudent holder, int position) {
        ItemStudent student = mInterf.getData(position);
        holder.tvName.setText(student.getName());
        holder.tvBirth.setText(student.getBirth());
        holder.tvAddress.setText(student.getAddress());
    }

    @Override
    public int getItemCount() {
        return mInterf.getCount();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_edit:
                IGetPosition interf = (IGetPosition) v.getTag();
                mInterf.onClickButtonEdit(interf.getPosition());
                break;

            case R.id.btn_delete:
                interf = (IGetPosition) v.getTag();
                mInterf.onClickButtonDelete(interf.getPosition());
                break;

            default:
                break;
        }
    }

    public class ViewHolderListStudent extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvBirth;
        private TextView tvAddress;
        private ImageButton btnDelete;
        private ImageButton btnEdit;

        public ViewHolderListStudent(View itemView, View.OnClickListener onClick) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvBirth = (TextView) itemView.findViewById(R.id.tv_birth);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_address);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btn_delete);
            btnEdit = (ImageButton) itemView.findViewById(R.id.btn_edit);

            IGetPosition getPosition = this::getAdapterPosition;
            btnEdit.setTag(getPosition);
            btnEdit.setOnClickListener(onClick);

            btnDelete.setTag(getPosition);
            btnDelete.setOnClickListener(onClick);
        }
    }

    public interface IListStudentAdapter{
        int getCount();
        ItemStudent getData(int position);
        void onClickButtonDelete(int position);
        void onClickButtonEdit(int position);
    }
}
