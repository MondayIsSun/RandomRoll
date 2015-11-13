package mr.lmd.personal.randomgvapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import java.lang.ref.WeakReference;

public class RollCallLayout extends FrameLayout {


    private RollTitleView mRollTitleView;
    private ResultView mResultView;

    private RollView mRoll;

    public final static int SHOW_RESULT = 0;
    public final static int ROLL_CALL = 1;
    public final static int CLOSE = 2;
    public final static int OPEN = 3;

    public RollCallLayout(Context context) {
        super(context);
        init(context);
    }

    public RollCallLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RollCallLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        //初始化子控件
        mRollTitleView = new RollTitleView(context);

        mResultView = new ResultView(context);
        mResultView.setVisibility(INVISIBLE);

        mRoll = mRollTitleView.getRoll();

        //初始化事件监听
        mResultView.getBtnClose().setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                closeResult();
            }
        });
        mResultView.getBtnAgain().setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                closeResult();
                roll();
            }
        });

        addView(mRollTitleView);
        addView(mResultView);

        //默认启动开始点名一次
        roll();
    }

    static class RollCallHandler extends Handler {

        //记录之前点到学生的下标
        private int last;

        WeakReference<RollCallLayout> mRollCallLayoutReference;

        RollCallHandler(RollCallLayout RollCallLayout) {
            mRollCallLayoutReference = new WeakReference<>(RollCallLayout);
        }

        @Override
        public void handleMessage(Message msg) {

            final RollCallLayout mRollCallLayout = mRollCallLayoutReference.get();

            if (null != mRollCallLayout) {
                switch (msg.what) {
                    case ROLL_CALL:
                        //还原之前点到的学生
                        mRollCallLayout.mRoll.getStudentInfo()[last].setBgColor(Color.WHITE);
                        //点名下一个学生
                        mRollCallLayout.mRoll.getStudentInfo()[msg.arg1].setBgColor(Color.YELLOW);
                        last = msg.arg1;
                        break;
                    case SHOW_RESULT:
                        mRollCallLayout.mResultView.setVisibility(VISIBLE);
                        break;
                    case CLOSE:
                        mRollCallLayout.mResultView.setVisibility(INVISIBLE);
                        break;
                    case OPEN:
                        break;
                }
            }
        }
    }

    private RollCallHandler handler = new RollCallHandler(this);

    /**
     * 生成随机数
     *
     * @param size
     * @return
     */
    private int genRandom(int size) {
        return (int) (Math.random() * size);
    }

    /**
     * 开始点名
     */
    public void roll() {

        new Thread(new Runnable() {
            int mRandomCnt = 20;//随机次数

            @Override
            public void run() {

                Message message = handler.obtainMessage();
                message.what = ROLL_CALL;
                message.arg1 = genRandom(mRoll.getStudentInfo().length);
                message.sendToTarget();

                if (--mRandomCnt != 0) {
                    handler.postDelayed(this, 80);
                } else {
                    Message msg_show_result = handler.obtainMessage();
                    msg_show_result.what = SHOW_RESULT;
                    msg_show_result.sendToTarget();
                }
            }
        }).start();
    }

    /**
     * 关闭结果页面
     */
    public void closeResult() {
        Message msg_close = handler.obtainMessage();
        msg_close.what = CLOSE;
        msg_close.sendToTarget();
    }

}
