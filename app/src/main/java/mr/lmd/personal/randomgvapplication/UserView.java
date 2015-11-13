package mr.lmd.personal.randomgvapplication;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UserView extends LinearLayout {

    private RollCircleImageView mCircleHead;
    private TextView mUserName_TV;

    private int bgColor = Color.WHITE;

    private LinearLayout.LayoutParams mUserHeadIVParams;
    private LinearLayout.LayoutParams mUserNameTVParams;

    public UserView(Context context) {
        super(context);
        init(context);
    }

    public UserView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public UserView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(bgColor);
        setOrientation(VERTICAL);

        //初始化控件
        mCircleHead = new RollCircleImageView(context);
        mCircleHead.setImageResource(R.drawable.stu_head);

        mUserName_TV = new TextView(context);
        mUserName_TV.setText("林明道");
        mUserName_TV.setTextColor(Color.BLACK);
        mUserName_TV.setTextSize(19);

        // 为组件元素设置相应的布局元素
        mUserHeadIVParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        mUserHeadIVParams.gravity = Gravity.CENTER;
        addView(mCircleHead, mUserHeadIVParams);

        // 为组件元素设置相应的布局元素
        mUserNameTVParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        mUserNameTVParams.gravity = Gravity.CENTER;

        addView(mUserName_TV, mUserNameTVParams);
    }

    public void setUserName(String name) {
        this.mUserName_TV.setText(name);
    }

    public void setUserHead(int res_id) {
        this.mCircleHead.setImageResource(res_id);
    }

    public void setBgColor(int color) {
        setBackgroundColor(color);
    }

}
