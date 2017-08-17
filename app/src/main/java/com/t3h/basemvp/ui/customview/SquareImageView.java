package com.t3h.basemvp.ui.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.t3h.basemvp.R;

import io.reactivex.disposables.Disposable;

/**
 * Created by ducnd on 17/01/2017.
 */

public class SquareImageView extends AppCompatImageView {
    protected boolean isSquareWidth;

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inits(context, attrs, 0);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inits(context, attrs, 0);
    }

    private void inits(Context context, AttributeSet attrs, int defStyle) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SquareView, defStyle, 0);
        isSquareWidth = typedArray.getBoolean(R.styleable.SquareView_is_square_width, true);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (isSquareWidth) {
            super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        } else {
            super.onMeasure(heightMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        if ( getTag() != null ) {
            if ( getTag() instanceof Disposable ) {
                Disposable disposable = (Disposable)getTag();
                if ( !disposable.isDisposed() ) {
                    disposable.dispose();
                }
            }
        }
        super.onDetachedFromWindow();
    }
}
