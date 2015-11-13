package mr.lmd.personal.randomgvapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RollCallLayout rollCallLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollCallLayout = (RollCallLayout) findViewById(R.id.roll_call_layout);
    }
}
