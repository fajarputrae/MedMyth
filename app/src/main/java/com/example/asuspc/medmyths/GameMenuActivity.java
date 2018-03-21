package com.example.asuspc.medmyths;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.asuspc.medmyths.Adapter.GameMenu;
import com.example.asuspc.medmyths.Adapter.GameMenuAdapter;

import java.util.ArrayList;
import java.util.List;

public class GameMenuActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private GameMenuAdapter gameMenuAdapter;
    private List<GameMenu> gameMenuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        gameMenuList = new ArrayList<>();
        gameMenuAdapter = new GameMenuAdapter(this, gameMenuList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(gameMenuAdapter);

        prepareGameMenu();

    }

    private void prepareGameMenu() {
        int[] gameMenu = new int[]{
                R.drawable.lingkaran,
                R.drawable.lingkaran_copy,
                R.drawable.lingkaran_copy_2,
                R.drawable.lingkaran,
                R.drawable.lingkaran_copy};

        GameMenu gm = new GameMenu(1, "Level 1", gameMenu[0]);
        gameMenuList.add(gm);

        gm = new GameMenu(2, "Level 2", gameMenu[1]);
        gameMenuList.add(gm);

        gm = new GameMenu(3, "Level 3", gameMenu[2]);
        gameMenuList.add(gm);

        gm = new GameMenu(4, "Level 4", gameMenu[3]);
        gameMenuList.add(gm);

        gm = new GameMenu(5, "Level 5", gameMenu[4]);
        gameMenuList.add(gm);

        gameMenuAdapter.notifyDataSetChanged();
    }
}
