package com.example.user.mrgamsys.activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridLayout;
import android.support.annotation.NonNull;
import com.example.user.mrgamsys.R;
import com.example.user.mrgamsys.adapters.MenusAdapter;
import com.example.user.mrgamsys.pojo.MenuVo;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
public class  MainActivity extends AppCompatActivity
{
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    @BindView(R.id.recMenus)
    RecyclerView recMenus;
    List<MenuVo> mMenuList = null;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(MainActivity.this);

        initializeMenuItemList();                 //intilize menus items in card view


        //recycle view menus for viewing all menus
        recMenus.setLayoutManager(  new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));

        //menu adapter instance cast in recycle menus
        MenusAdapter adapter = new MenusAdapter(mMenuList, this);
        recMenus.setAdapter(adapter);

        recMenus = findViewById(R.id.recMenus);
        setSingleEvent(recMenus);
        /*Intitlization of recycle view*/

        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.gham);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_main);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.Open, R.string.Close);      //toogle button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);                //on drawer toggle button add
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.gham);
    }
    /*End of oncreate*/


    private void setSingleEvent(RecyclerView recyclerView)
    {
        for(int i = 0 ;i < recMenus.getChildCount();i++)
        {
            GridLayout gridLayout = (GridLayout) recMenus.getChildAt(i);
            final int finalI = i;

            gridLayout.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {


                }

            });
        }

    }
/*Intilizing menu items*/
    private void initializeMenuItemList()
    {
        if(mMenuList == null)
        {
            mMenuList = new ArrayList<MenuVo>();
            mMenuList.add(new MenuVo(R.drawable.ic_launcher_setting,"NEW REGISTRATION"));
            mMenuList.add(new MenuVo(R.drawable.ic_launcher_setting,"TARGETS"));

            mMenuList.add(new MenuVo(R.drawable.ic_launcher_setting,"CONFIRMEDCLIENTS"));
            mMenuList.add(new MenuVo(R.drawable.ic_launcher_setting,"FOLLOW UPS"));

            mMenuList.add(new MenuVo(R.drawable.ic_launcher_setting,"PENDINGDOCUMENTS"));
            mMenuList.add(new MenuVo(R.drawable.ic_launcher_setting,"DIRECT SALE"));

        }

    }
}
