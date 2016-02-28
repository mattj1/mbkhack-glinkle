package com.mbkhack.glinkle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mbkhack.glinkle.model.Charity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ThankYouActivity extends AppCompatActivity {

    public static final String PARAM_CHARITY_ID = "PARAM_CHARITY_ID";

    @Bind(R.id.btn_close)
    Button btn_close;

    @Bind(R.id.tv_message)
    TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
        ButterKnife.bind(this);

        final int charity_id = getIntent().getIntExtra(PARAM_CHARITY_ID, 0);

        GlinkleApplication application = (GlinkleApplication) getApplication();

        Charity charity = application.getCharityManager().getCharityList().get(charity_id);

        tv_message.setText("Thank you for your generous donation to "
                + charity.getName()
                + ". Your donation will help a lot of people in need.");

                btn_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
        });
    }
}
