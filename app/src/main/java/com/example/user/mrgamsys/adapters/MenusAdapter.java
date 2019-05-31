package com.example.user.mrgamsys.adapters;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.mrgamsys.R;
import com.example.user.mrgamsys.activity.FollowUp;
import com.example.user.mrgamsys.activity.Registration;
import com.example.user.mrgamsys.pojo.MenuVo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.MenusHolder>
{

    private Activity mactivity;
    private List<MenuVo> mMenuList;
    public static final String TAG = "YOUR-TAG-NAME";


        /*Constructor  of Menus and activity instance*/
    public MenusAdapter(List<MenuVo> menuVoList, Activity mactivity)
    {
        this.mMenuList = menuVoList;
        this.mactivity = mactivity;
    }

    @NonNull
    @Override
    public MenusHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
            //bind layout menus
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_menus, viewGroup,false);
        return new MenusHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MenusHolder viewHolder,final int position)
    {

        MenuVo menuVo = mMenuList.get(position);
        viewHolder.img.setImageResource(menuVo.img);
        viewHolder.txtImgName.setText(menuVo.imgName);

        viewHolder.txtImgName.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(position ==0)
                {
                    Intent intent = new Intent(new Intent(mactivity.getApplicationContext(), Registration.class));
                    mactivity.startActivity(intent);
                }
                if(position ==3)
                {
                    Intent i = new Intent(new Intent(mactivity.getApplicationContext(), FollowUp.class));
                    mactivity.startActivity(i);
                }
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return mMenuList.size();           //size of menus items
    }

    public class MenusHolder extends  RecyclerView.ViewHolder
    {

        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.txtImgName)
        TextView txtImgName;


        public MenusHolder(@NonNull View itemview)
        {
            super(itemview);
            ButterKnife.bind(this, itemview);
        }
    }
}
