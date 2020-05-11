package com.example.guideview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;


/**
 * author : Yangkongming
 * date   : 2020/5/5
 * desc   :新手引导自定义view
 */
public class GuideView extends ConstraintLayout {

    Paint paint;
    Path path;
    RectF rectF;
    boolean isCircle = false;
    boolean isMore = false;
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.base_guide_finger_down).copy(Bitmap.Config.ARGB_8888, true);
    private float value = 0;//当前位置

    public GuideView(Context context) {
        super(context);
        initPaint();
    }

    public GuideView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public GuideView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    public void setRectF(RectF rectF) {
        this.rectF = rectF;
    }

    public void setCircle(boolean circle) {
        this.isCircle = circle;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    public void setValue(int level) {
        if (level > 0 && level <= 15) {
            if (level % 5 == 0) {
                this.value = 0;
            } else {
                this.value = (5 - level % 5) * 62;
            }
        } else {
            this.value = 0;
        }
        invalidate();
    }


    public void initPaint() {
        paint = new Paint();
        path = new Path();
        rectF = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isCircle) {
            path.addCircle(getMeasuredWidth() / 2, getMeasuredHeight() - ConvertUtils.dp2px(25), ConvertUtils.dp2px(25), Path.Direction.CW);
        } else {
            if (isMore) {
                rectF.set(getMeasuredWidth() - ConvertUtils.dp2px(80) - ConvertUtils.dp2px(value), ConvertUtils.dp2px(340) + ConvertUtils.getStatusHeight(getContext()), getMeasuredWidth() - ConvertUtils.dp2px(32) - ConvertUtils.dp2px(value), ConvertUtils.dp2px(420) + ConvertUtils.getStatusHeight(getContext()));
            }
            path.addRoundRect(rectF, ConvertUtils.dp2px(30), ConvertUtils.dp2px(30), Path.Direction.CW);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            canvas.clipOutPath(path);
        } else {
            canvas.clipRect(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.clipPath(path, Region.Op.XOR);
        }
        canvas.drawColor(getContext().getResources().getColor(R.color.color_80000000));


        if (isMore) {
            canvas.drawBitmap(bitmap, getMeasuredWidth() - ConvertUtils.dp2px(80) - ConvertUtils.dp2px(value), ConvertUtils.dp2px(320), paint);
        }
    }


}
