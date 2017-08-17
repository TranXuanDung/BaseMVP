package com.t3h.basemvp.ui.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.t3h.basemvp.R;

import static java.security.AccessController.getContext;


public class StatusAvatarCircleImageView extends CircleImageView {
    private static final int SIZE_STATUS_DEFAUFT = 15;
    private static final int ANGLE_STATUS_DEFAUFT = 45;
    private int sizeStatus;
    private int angle;
    private int colorStatus;
    private Paint mPaintStatus = new Paint();
    private Paint mPaintBolderStatus = new Paint();
    private int xStatusCircle, yStatusCircle;
    private int widthView = 0;
    private boolean hasCircleStatus;

    public StatusAvatarCircleImageView(Context context) {
        super(context);
    }

    public StatusAvatarCircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initComponent(attrs);
    }

    public StatusAvatarCircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initComponent(attrs);
    }

    private void initComponent(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.StatusAvatarCircleImageView);
        sizeStatus = (int) typedArray.getDimension(R.styleable.StatusAvatarCircleImageView_sizeStatusCicle, SIZE_STATUS_DEFAUFT);
//        colorStatus = typedArray.getColor(R.styleable.StatusAvatarCircleImageView_colorStatusCircle,
//                ContextCompat.getColor(getContext(), R.color.status_online));
        angle = (int) typedArray.getDimension(R.styleable.StatusAvatarCircleImageView_statusAngle, ANGLE_STATUS_DEFAUFT);
        hasCircleStatus = typedArray.getBoolean(R.styleable.StatusAvatarCircleImageView_hasCircleStatus, true);
        typedArray.recycle();

        mPaintStatus.setAntiAlias(true);
        mPaintStatus.setColor(colorStatus);
        mPaintStatus.setStyle(Paint.Style.FILL);

        mPaintBolderStatus.setAntiAlias(true);
        mPaintBolderStatus.setStyle(Paint.Style.STROKE);
        mPaintBolderStatus.setColor(Color.WHITE);
        mPaintBolderStatus.setStrokeWidth(sizeStatus / 3);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            super.onMeasure(widthMeasureSpec, widthMeasureSpec);
            return;
        }

        int drawableWidth = drawable.getIntrinsicWidth();
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        widthView = setViewSize(widthMode, widthSize, drawableWidth);
        xStatusCircle = widthView / 2 + (int) (Math.cos(Math.toRadians(angle)) * widthView / 2);
        yStatusCircle = widthView / 2 + (int) (Math.cos(Math.toRadians(angle)) * widthView / 2);
        setMeasuredDimension(widthView, widthView);

    }

    private int setViewSize(int mode, int size, int drawableWidth) {
        int viewSize;
        switch (mode) {
            case View.MeasureSpec.EXACTLY:
                viewSize = size;
                break;

            case View.MeasureSpec.AT_MOST:
                viewSize = Math.min(drawableWidth, size);
                break;

            case View.MeasureSpec.UNSPECIFIED:
                viewSize = drawableWidth;
                break;

            default:
                viewSize = size;
                break;
        }
        return viewSize;
    }

    public void setColorStatus(int colorStatus) {
        if (this.colorStatus != colorStatus) {
            this.colorStatus = colorStatus;
            mPaintStatus.setColor(this.colorStatus);
            invalidate();
        }
    }

    public void setHasCircleStatus(boolean hasCircleStatus) {
        if (hasCircleStatus != this.hasCircleStatus) {
            this.hasCircleStatus = hasCircleStatus;
            invalidate();
        }
    }

    public void setColorStatusResouce(int colorStatusResouce) {
        int colorStatus = getResources().getColor(colorStatusResouce);
        if (this.colorStatus != colorStatus) {
            this.colorStatus = colorStatus;
            mPaintStatus.setColor(this.colorStatus);
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (hasCircleStatus) {
            canvas.drawCircle(xStatusCircle, yStatusCircle, sizeStatus, mPaintStatus);
            canvas.drawCircle(xStatusCircle, yStatusCircle, sizeStatus, mPaintBolderStatus);
        }

    }
}
