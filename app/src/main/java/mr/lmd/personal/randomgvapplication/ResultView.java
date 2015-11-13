package mr.lmd.personal.randomgvapplication;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultView extends LinearLayout {

    private TextView mTitle;
    private UserView mUser;
    private Button btnAgain;
    private Button btnClose;
    private LinearLayout mLinearLayout;

    public Button getBtnClose() {
        return this.btnClose;
    }

    public Button getBtnAgain() {
        return this.btnAgain;
    }

    public ResultView(Context context) {
        super(context);
        init(context);
    }

    public ResultView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ResultView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        setBackgroundColor(Color.GRAY);
        setOrientation(VERTICAL);

        //初始化子控件
        mTitle = new TextView(context);
        mTitle.setText("同学你很幸运的被点中了，请回答问题吧！");
        mTitle.setTextSize(20);
        mTitle.setTextColor(Color.BLACK);

        mUser = new UserView(context);

        mLinearLayout = new LinearLayout(context);
        mLinearLayout.setOrientation(HORIZONTAL);
        mLinearLayout.setGravity(Gravity.CENTER);

        btnClose = new Button(context);
        btnClose.setText("关闭");
        btnClose.setTextColor(Color.BLACK);

        btnAgain = new Button(context);
        btnAgain.setText("再点一次");
        btnAgain.setTextColor(Color.BLACK);

        mLinearLayout.addView(btnAgain);
        mLinearLayout.addView(btnClose);

        //添加子控件到父布局
        addView(mTitle);
        addView(mUser);
        addView(mLinearLayout);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//        int width;
//        int height;
//
//        width = mTitle.getWidth();
//        height = mTitle.getHeight() + mUser.getHeight() + btnAgain.getHeight();
//
//        Log.d("ELSeed", "w = " + width + " h = " + height);
//
//        setMeasuredDimension(500, 500);
//    }
}
