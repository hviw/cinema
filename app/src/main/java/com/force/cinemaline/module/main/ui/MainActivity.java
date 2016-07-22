package com.force.cinemaline.module.main.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.force.cinemaline.R;
import com.force.cinemaline.common.constant.Constant;
import com.force.cinemaline.module.buy.ui.BuyFragment;
import com.force.cinemaline.module.cinema.ui.CinemaFragment;
import com.force.cinemaline.module.find.ui.FindFragment;
import com.force.cinemaline.module.first.ui.FirstFragment;
import com.force.cinemaline.module.me.ui.MeFragment;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    LinearLayout fragmentContainer;
    Fragment lastFragemnt;

    FirstFragment firstFragment;
    BuyFragment buyFragment;
    CinemaFragment cinemaFragment;
    FindFragment findFragment;
    MeFragment meFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        init();
        initEvents();
    }

    private void init() {

        buyFragment = new BuyFragment();
        cinemaFragment = new CinemaFragment();
        findFragment = new FindFragment();
        firstFragment = new FirstFragment();
        meFragment = new MeFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.main_fragment_container, meFragment);
        transaction.hide(meFragment);
        transaction.add(R.id.main_fragment_container, findFragment);
        transaction.hide(findFragment);
        transaction.add(R.id.main_fragment_container, cinemaFragment);
        transaction.hide(cinemaFragment);
        transaction.add(R.id.main_fragment_container, buyFragment);
        transaction.hide(buyFragment);
        transaction.add(R.id.main_fragment_container, firstFragment);
        transaction.show(firstFragment);

        lastFragemnt = firstFragment;
        transaction.commit();
    }

    private void initEvents() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                Log.e("tag", "----------" + checkedId);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (checkedId) {
                    case R.id.main_first_page:
//                Log.e("tag", "R.id.main_first_page----------" + R.id.main_first_page);
                        if (!(lastFragemnt instanceof FirstFragment)) {
                            transaction.hide(lastFragemnt);
                            transaction.show(firstFragment);
                        }
                        lastFragemnt = firstFragment;
                        break;
                    case R.id.main_buy_ticket:
                        if (!(lastFragemnt instanceof BuyFragment)) {
                            transaction.hide(lastFragemnt);
                            transaction.show(buyFragment);
                        }
                        lastFragemnt = buyFragment;
                        break;
                    case R.id.main_cinema:
                        if (!(lastFragemnt instanceof CinemaFragment)) {
                            transaction.hide(lastFragemnt);
                            transaction.show(cinemaFragment);
                        }
                        lastFragemnt = cinemaFragment;
                        break;
                    case R.id.main_find_out:
                        if (!(lastFragemnt instanceof FindFragment)) {
                            transaction.hide(lastFragemnt);
                            transaction.show(findFragment);
                        }
                        lastFragemnt = findFragment;
                        break;
                    case R.id.main_self:
                        if (!(lastFragemnt instanceof MeFragment)) {
                            transaction.hide(lastFragemnt);
                            transaction.show(meFragment);
                        }
                        lastFragemnt = meFragment;
                        break;
                    default:
                        break;
                }
                transaction.commit();
            }
        });
    }

    private void findViews() {
        radioGroup = (RadioGroup) findViewById(R.id.radio_group_main);
        fragmentContainer = (LinearLayout) findViewById(R.id.main_fragment_container);
    }

    //转至cinemaFragment
    public void toBuyFragment() {
        RadioButton cinemaRadioButton = (RadioButton) radioGroup.getChildAt(1);
        cinemaRadioButton.setChecked(true);
    }

    //转至findFragment
    public void toFindFragment() {
        RadioButton cinemaRadioButton = (RadioButton) radioGroup.getChildAt(3);
        cinemaRadioButton.setChecked(true);
    }

    //跳转至cinemaFragment
    public void toCinemaFragment() {
        RadioButton cinemaRadioButton = (RadioButton) radioGroup.getChildAt(2);
        cinemaRadioButton.setChecked(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case Constant.LOCATION_REQUEST_CODE:

                if (resultCode == Constant.RESULT_OK) {
                    String location = data.getStringExtra("location");
//                    textViewLocation.setText(location);
                    Log.e("tag mainActivity ", location);
                }
                break;
            default:
                break;
        }
    }

    long lastTime = 0;

    public void onBackPressed() {
        //判断是否为第一次点击
        if (System.currentTimeMillis() - lastTime < 3000) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_LONG).show();
            //否则赋值给上一次点击的时间
            lastTime = System.currentTimeMillis();
        }
    }

}
