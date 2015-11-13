package mr.lmd.personal.randomgvapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import java.lang.ref.WeakReference;

public class RollView extends RelativeLayout {

    private UserView[] mStudentInfo = new UserView[40];

    public UserView[] getStudentInfo() {
        return this.mStudentInfo;
    }

    /**
     * 初始化学生数据源
     */
    public void initData() {
    }

    public RollView(Context context) {
        super(context);
        init();
    }

    public RollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 布局
     */
    private void init() {
        setBackgroundColor(Color.WHITE);

        //初始化学生信息数据源
        initData();

        int mMargin = 48;
        int mColumn = 10;

        //根据学生信息动态生成子控件，设置Rule，布局子控件
        for (int i = 0; i < mStudentInfo.length; i++) {
            UserView stu = new UserView(getContext());
            mStudentInfo[i] = stu;
            stu.setId(i + 1);

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(150, 150);
            lp.bottomMargin = 40;

            //设置Item间横向间隙，通过rightMargin
            //不是最后一列
            if ((i + 1) % mColumn != 0) {
                lp.rightMargin = mMargin;
            }

            //不是第一列
            if (i % mColumn != 0) {
                lp.addRule(RelativeLayout.RIGHT_OF, mStudentInfo[i - 1].getId());
            }

            //如果不是第一行 , 设置topMargin和rule
            if ((i + 1) > mColumn) {
                lp.topMargin = mMargin;
                lp.addRule(RelativeLayout.BELOW, mStudentInfo[i - mColumn].getId());
            }

            addView(stu, lp);
        }
    }
}
