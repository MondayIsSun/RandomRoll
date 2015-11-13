package mr.lmd.personal.randomgvapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/12.
 */
public class RollTitleView extends LinearLayout {

    private TextView mClass;
    private TextView mCenterBlank;
    private TextView mOnline;
    private TextView mBlank;
    private RelativeLayout mRL;
    private RollView mRoll;

    public RollTitleView(Context context) {
        super(context);
        init(context);
    }

    public RollTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RollTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        setOrientation(VERTICAL);

        mRoll = new RollView(context);

//        mTitle = new TextView(context);
//        mTitle.setBackgroundResource(R.drawable.textview_border);
//        mTitle.setText("随机点名");
//        mTitle.setTextColor(Color.BLACK);
//        mTitle.setGravity(Gravity.CENTER);
//        mTitle.setTextSize(26);


//        LinearLayout.LayoutParams paramstest = new LayoutParams();


        mBlank = new TextView(context);
        mBlank.setText("   ");
        mBlank.setGravity(Gravity.CENTER);
        mBlank.setTextSize(20);

        mRL = new RelativeLayout(context);

        RelativeLayout.LayoutParams class_params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        class_params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        mClass = new TextView(context);
        mClass.setTextSize(26);
        mClass.setText("四年3班");

//        mTitleParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT);
//        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
//        addView(mTitleTextView, mTitleParams);

        RelativeLayout.LayoutParams online_params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        class_params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mOnline = new TextView(context);
        mOnline.setGravity(Gravity.LEFT);
        mOnline.setTextSize(26);
        mOnline.setText("在线 37/40");

        mRL.addView(mOnline, online_params);
        mRL.addView(mClass, class_params);
        addView(mRL);
        addView(mBlank);
        addView(mRoll);
    }

    public RollView getRoll() {
        return mRoll;
    }
}
