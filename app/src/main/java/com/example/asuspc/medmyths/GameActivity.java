package com.example.asuspc.medmyths;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.asuspc.medmyths.Adapter.MedicalInfo;
import com.example.asuspc.medmyths.Adapter.MedicalInfoAdapter;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.SwipeDirection;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends BaseActivity {
    private ProgressBar progressBar;
    private CardStackView cardStackView;
    private MedicalInfoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setup();
        reload();
    }

    private List<MedicalInfo> createMedicalInfo() {
        int[] imgList = new int[]{
                R.drawable.imgsample,
                R.drawable.imgsample_1,
                R.drawable.imgsample_2,
                R.drawable.imgsample_3,
                R.drawable.imgsample_4};

        List<MedicalInfo> mi = new ArrayList<>();
        mi.add(new MedicalInfo("Yasaka Shrine", imgList[0]));
        mi.add(new MedicalInfo("Fushimi Inari Shrine", imgList[1]));
        mi.add(new MedicalInfo("Bamboo Forest", imgList[2]));
        mi.add(new MedicalInfo("Brooklyn Bridge", imgList[3]));
        mi.add(new MedicalInfo("Empire State Building", imgList[4]));
        return mi;
    }

    private MedicalInfoAdapter createMedicalInfoAdapter() {
        final MedicalInfoAdapter adapter = new MedicalInfoAdapter(getApplicationContext());
        adapter.addAll(createMedicalInfo());
        return adapter;
    }

    private void setup() {
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progress_bar);

        cardStackView = (CardStackView) findViewById(R.id.activity_main_card_stack_view);
        cardStackView.setCardEventListener(new CardStackView.CardEventListener() {
            @Override
            public void onCardDragging(float percentX, float percentY) {
                Log.d("CardStackView", "onCardDragging");
            }

            @Override
            public void onCardSwiped(SwipeDirection direction) {
                Log.d("CardStackView", "onCardSwiped: " + direction.toString());
                Log.d("CardStackView", "topIndex: " + cardStackView.getTopIndex());
                if (cardStackView.getTopIndex() == adapter.getCount() - 5) {
                    Log.d("CardStackView", "Paginate: " + cardStackView.getTopIndex());
                    paginate();
                }
            }

            @Override
            public void onCardReversed() {
                Log.d("CardStackView", "onCardReversed");
            }

            @Override
            public void onCardMovedToOrigin() {
                Log.d("CardStackView", "onCardMovedToOrigin");
            }

            @Override
            public void onCardClicked(int index) {
                Log.d("CardStackView", "onCardClicked: " + index);
            }
        });
    }

    private void reload() {
        cardStackView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter = createMedicalInfoAdapter();
                cardStackView.setAdapter(adapter);
                cardStackView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        }, 1000);
    }

    private void paginate() {
        cardStackView.setPaginationReserved();
        adapter.addAll(createMedicalInfo());
        adapter.notifyDataSetChanged();
    }
}
