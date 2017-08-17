package com.t3h.basemvp.ui.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.t3h.basemvp.R;

/**
 * Created by dungtx on 8/16/17.
 */

public class MessageConfirmDialog extends Dialog implements View.OnClickListener {

    private IMessageDialog mInterf;

    public MessageConfirmDialog(Context context, String content, IMessageDialog interf) {
        super(context);
        mInterf = interf;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_show_confirm);
        inits(content);
    }

    private void inits(String content) {
        TextView tvContent = (TextView) findViewById(R.id.tv_content);
        tvContent.setText(content);

        findViewById(R.id.btn_ok).setOnClickListener(this);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ok:
                dismiss();
                mInterf.onClickOk();
                break;

            case R.id.btn_cancel:
                dismiss();
                mInterf.onClickCancel();
                break;

            default:
                break;
        }
    }

    public interface IMessageDialog{
        void onClickOk();

        void onClickCancel();
    }
}
