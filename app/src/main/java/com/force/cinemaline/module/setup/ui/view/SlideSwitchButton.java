package com.force.cinemaline.module.setup.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.force.cinemaline.R;

/**
 * Created by asus on 2016/6/1.
 */
public class SlideSwitchButton extends View {

    private Bitmap bgOff;
    private Bitmap bgOn;
    private Bitmap slideBtn;
    private int bgWidth;
    private int bgHeight;
    //currentX用于代表圆心的x坐标
    private float currentX;
    private int slideWidth;
    private OnStateChangedListener listener;
    private boolean state;//代表开关的状态
    private boolean prevState;//记录手指触摸前的状态

    //自定义接口，用于申明按钮的状态改变的时候的回调方法
    public interface OnStateChangedListener{
        void onStateChanged(boolean on);
    }

    //自定义一个方法，提供给使用者用于设置监听器对象
    public void setOnStateChangedListener(OnStateChangedListener listener){
        //接收使用者传入的监听器对象
        this.listener = listener;
    }

    public SlideSwitchButton(Context context) {
        super(context);
        init();
    }

    public SlideSwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    //将图片转换成位图对象，获得位图的宽高
    private void init() {
        bgOff = BitmapFactory.decodeResource(getResources(), R.mipmap.slide_bg_off);
        bgOn = BitmapFactory.decodeResource(getResources(), R.mipmap.slide_bg_on);
        slideBtn = BitmapFactory.decodeResource(getResources(), R.mipmap.slide_btn);

//        获得背景位图的宽高
        bgWidth = bgOff.getWidth();
        bgHeight = bgOff.getHeight();

        //获得滑块的宽
        slideWidth = slideBtn.getWidth();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //不想让使用者去修改控件的大小
        //直接用底图的宽高作为控件的宽高
        setMeasuredDimension(bgWidth,bgHeight);
    }

    //绘制图案
    @Override
    protected void onDraw(Canvas canvas) {
        //currentX用于代表圆心的x坐标
        //如果手指的位置超过右边界，
        if (currentX > bgWidth-slideWidth/2)
            currentX = bgWidth-slideWidth/2;
        //如果设置位置超过左边界
        if (currentX < slideWidth/2)
            currentX = slideWidth/2;

        //画底图
        if (currentX>bgWidth/2)
        {
            //滑块的圆心坐标超过一半的时候，画 开的背景
            canvas.drawBitmap(bgOn,0,0,null);
        }else
        {
            canvas.drawBitmap(bgOff,0,0,null);
        }

        //画滑块:绘制都是以左上角为准的，所以绘制滑块的左边界要在减掉滑块的半径
        canvas.drawBitmap(slideBtn,currentX-slideWidth/2,0,null);
    }

    //手指触摸控件的过程中会回调
    //从MotionEvent参数中可以获得当前手指的坐标，可以获得手指的状态：
    //返回值：如果是false,代表屏蔽手指的移动和离开状态
    //如果要对移动和离开状态做操作，必须返回true
    @Override
    public boolean onTouchEvent(MotionEvent event) {
       /* if (event.getAction() == MotionEvent.ACTION_DOWN)
              Log.e("print","手指按下。。。");
        if (event.getAction() == MotionEvent.ACTION_MOVE)
            Log.e("print","手指移动。。。。"+event.getX());

        if (event.getAction() == MotionEvent.ACTION_UP)
            Log.e("print","手指离开。。。。");*/
        //在移动过程中，滑块的位置要跟随手指变化
        currentX = event.getX();

        prevState = state;
        //当手指离开的时候，判断离开的点在靠右还是靠左
        if (event.getAction() == MotionEvent.ACTION_UP)
        {
            //如果靠右，滑块弹回最右边
            if (currentX>bgWidth/2) {
                currentX = bgWidth;
                state = true;
            }
            //如果靠左，滑块弹回最左边
            else {
                currentX = 0;
                state = false;
            }
            //如果调用者设置了状态改变的监听器
            if (listener != null){
                //如果状态发生改变，回调接口中的状态改变方法
                if (prevState != state)
                    listener.onStateChanged(state);
            }
        }

        //通知尽快重新绘图
        invalidate();
        return true;
    }
}
