package com.t3h.basemvp.ui.main.playmusic;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.t3h.basemvp.R;
import com.t3h.basemvp.ui.base.fragment.BaseFragment;

/**
 * Created by dungtx on 7/16/17.
 */

public class PlayMusicFragment extends BaseFragment implements View.OnClickListener {

    private TextView tvName;
    private Button btnPrevious;
    private Button btnPause;
    private Button btnNext;
    private Button btnPlay;

    @Override
    public int getLayoutMain() {
        return R.layout.fragment_play_music;
    }

    @Override
    public void findViewByIds() {
        tvName = (TextView) getView().findViewById(R.id.tv_name);
        btnPlay = (Button) getView().findViewById(R.id.btn_play);
        btnPrevious = (Button) getView().findViewById(R.id.btn_previous);
        btnNext = (Button) getView().findViewById(R.id.btn_next);
    }

    @Override
    public void initComponents() {

    }

    @Override
    public void setEvents() {
        btnPlay.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_play:

                break;

            case R.id.btn_next:

                break;

            case R.id.btn_previous:

                break;

            default:
                break;
        }
    }
}
