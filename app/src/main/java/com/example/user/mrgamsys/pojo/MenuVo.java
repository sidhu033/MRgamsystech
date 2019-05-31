package com.example.user.mrgamsys.pojo;

public class MenuVo
{
    public int img;
    public String imgName;

    public MenuVo(int img, String imgName)
    {
        this.img = img;
        this.imgName = imgName;
    }

    public int getImg()
    {
        return img;
    }

    public void setImg(int img)
    {
        this.img = img;
    }

    public String getImgName()
    {
        return imgName;
    }
    public void setImgName(String imgName)
    {
        this.imgName = imgName;
    }





    /*Object to string conversion*/
    @Override
    public String toString()
    {
        return "MenuVo{" +
                "img=" + img +
                ", imgName='" + imgName + '\'' +
                '}';
    }
}
