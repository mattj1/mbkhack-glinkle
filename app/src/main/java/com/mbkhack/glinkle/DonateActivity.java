package com.mbkhack.glinkle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mbkhack.glinkle.model.Charity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DonateActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.tv_charityname)
    TextView tv_charityname;

    @Bind(R.id.btn_donate)
    Button btn_donate;

    public static final String PARAM_CHARITY_ID = "PARAM_CHARITY_ID";

    int selectedItem = -1;

    List<Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final int charity_id = getIntent().getIntExtra(PARAM_CHARITY_ID, 0);

        GlinkleApplication application = (GlinkleApplication) getApplication();

        Charity charity = application.getCharityManager().getCharityList().get(charity_id);

        tv_charityname.setText(charity.getName());

        btn_donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DonateActivity.this, ThankYouActivity.class);
                intent.putExtra(ThankYouActivity.PARAM_CHARITY_ID, charity_id);
                startActivity(intent);
                setResult(RESULT_OK);
                finish();
            }
        });

        btn_donate.setEnabled(false);
        btn_donate.setAlpha(0.5f);

        buttons = new ArrayList<>();
        buttons.add((Button) findViewById(R.id.btn_option0));
        buttons.add((Button) findViewById(R.id.btn_option1));
        buttons.add((Button) findViewById(R.id.btn_option2));
        buttons.add((Button) findViewById(R.id.btn_option3));
        buttons.add((Button) findViewById(R.id.btn_option4));
        buttons.add((Button) findViewById(R.id.btn_option5));

        for(int i = 0; i < buttons.size(); i++) {
            final int buttonIndex = i;
            Button b = buttons.get(i);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedItem = buttonIndex;
                    btn_donate.setEnabled(true);
                    btn_donate.setAlpha(1.0f);
                    updateButtons();
                }
            });
        }

        updateButtons();
    }

    private void updateButtons() {
        for(int i = 0; i < buttons.size(); i++) {
            Button b = buttons.get(i);

            b.setSelected(selectedItem == i);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
