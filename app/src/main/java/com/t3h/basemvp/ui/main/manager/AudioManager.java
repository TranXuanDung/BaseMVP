package com.t3h.basemvp.ui.main.manager;

import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by dungtx on 7/16/17.
 */

public class AudioManager {
    private MediaPlayer mPlay;

    public AudioManager() {
        mPlay = new MediaPlayer();
    }

    public void initSong(String path) throws IOException {
        try {
            mPlay.setDataSource(path);
        } catch (IllegalStateException e) {
            mPlay = new MediaPlayer();
            mPlay.setDataSource(path);
        }
        mPlay.prepare();
    }

    public void play(){
        if (!mPlay.isPlaying()){
            mPlay.start();
        }
    }

    public void pause(){
        if (mPlay.isPlaying()){
            mPlay.pause();
        }
    }

    public void release(){
        mPlay.release();
    }

    public boolean isPlaying(){
        return mPlay.isPlaying();
    }
}
