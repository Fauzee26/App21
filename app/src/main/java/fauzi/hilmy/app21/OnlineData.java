package fauzi.hilmy.app21;

import java.util.ArrayList;

public class OnlineData {
    public static String[][] namaWeb = new String[][]{
            {"Udacity","https://cdn.freebiesupply.com/logos/large/2x/udacity-logo-png-transparent.png","https://www.udacity.com/"},
            {"Udemy","https://cdn.freebiesupply.com/logos/large/2x/udemy-1-logo-png-transparent.png","https://www.udemy.com/"},
            {"Dicoding","https://avatars0.githubusercontent.com/u/22091590?s=460&v=4","https://www.dicoding.com/"},
            {"Coursera","https://d1v7d3ia9rcklg.cloudfront.net/providers/coursera.png","https://www.coursera.org/"},
            {"Alison","https://pbs.twimg.com/profile_images/851098110159986690/yRdpk2ty_400x400.jpg","https://alison.com/"},
            {"edX","https://www.wnet.org/education/files/2015/01/edX_Logo_Col_RGB_FINAL.jpg","https://www.edx.org/"}
    };

    public static ArrayList<Online> getDataWeb(){
        Online online = null;
        ArrayList<Online> onlineArrayList = new ArrayList<>();
        for (int i = 0; i < namaWeb.length; i++){
            online = new Online();
            online.setNama(namaWeb[i][0]);
            online.setGambar(namaWeb[i][1]);
            online.setLink(namaWeb[i][2]);
            onlineArrayList.add(online);
        }
        return onlineArrayList;
    }
}
