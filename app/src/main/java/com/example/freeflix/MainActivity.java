package com.example.freeflix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.freeflix.adapter.BannerMoviesPagerAdapter;
import com.example.freeflix.adapter.MainRecylerAdapter;
import com.example.freeflix.model.AllCategory;
import com.example.freeflix.model.BannerMovies;
import com.example.freeflix.model.CategoryItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout indicatorTab,categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> tvShowBannerList;
    List<BannerMovies> movieBannerList;
    List<BannerMovies> kidsBannerList;
    Timer sliderTimer;
    List<AllCategory> allCategoryList;


    MainRecylerAdapter mainRecylerAdapter;
    RecyclerView mainRecycler;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indicatorTab = findViewById(R.id.tab_indicator);
        categoryTab=findViewById(R.id.tabLayout);

        homeBannerList= new ArrayList<>();
        homeBannerList.add(new BannerMovies(1, "Kabir Singh", "https://m.media-amazon.com/images/M/MV5BZTI4ZThiY2ItNzMxZi00YTk1LTg0OTktZjY2MDE5NzRjMzEzXkEyXkFqcGdeQXVyMTA4NjE0NjEy._V1_.jpg", ""));
        homeBannerList.add(new BannerMovies(2, "Taitanic", "https://i.pinimg.com/564x/6f/4c/f3/6f4cf3bf33e8b8038b378826c7b6e072.jpg", ""));
        homeBannerList.add(new BannerMovies(3, "Kissing Booth", "https://m.media-amazon.com/images/M/MV5BOWQ5ZGU2ZGQtOTJjYi00MWI3LWE1ZDQtM2EzOGI2MzJjNTA4XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg", ""));
        homeBannerList.add(new BannerMovies(4, "Money Heist", "\"https://resizing.flixster.com/fLiPKJwqtPJZ1ZFSwYl4-YoYaBQ=/ems.ZW1zLXByZC1hc3NldHMvdHZzZWFzb24vUlRUVjEwMTMyOTMud2VicA==:", ""));
        setBannerMoviesPagerAdapter(homeBannerList);

        tvShowBannerList= new ArrayList<>();
        tvShowBannerList.add(new BannerMovies(1, "Money heist", "https://resizing.flixster.com/fLiPKJwqtPJZ1ZFSwYl4-YoYaBQ=/ems.ZW1zLXByZC1hc3NldHMvdHZzZWFzb24vUlRUVjEwMTMyOTMud2VicA==", ""));
        tvShowBannerList.add(new BannerMovies(2, "House of Secrets", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNkSaitWEQ4ce_DuuSRXP2B1kAwXADSQ7c7B6zzGBTgyQlMgoM", ""));
        tvShowBannerList.add(new BannerMovies(3, "little things", "https://assets.gadgets360cdn.com/pricee/assets/product/202110/Little-Things-250_1634662771.jpg", ""));
        tvShowBannerList.add(new BannerMovies(4, "All of us are dead", "https://www.pinkvilla.com/imageresize/all_main.jpg?width=752&format=webp&t=pvorg", ""));



        movieBannerList= new ArrayList<>();
        movieBannerList.add(new BannerMovies(1, "Rockstar", "https://m.media-amazon.com/images/M/MV5BOTc3NzAxMjg4M15BMl5BanBnXkFtZTcwMDc2ODQwNw@@._V1_.jpghttps://m.media-amazon.com/images/M/MV5BOTc3NzAxMjg4M15BMl5BanBnXkFtZTcwMDc2ODQwNw@@._V1_.jpg", ""));
        movieBannerList.add(new BannerMovies(2, "Gangubai Kathaiwadi", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRy2mCbfp6Om9k_WICSsDNY8ZWVr6zd48JGlrMTjqWZtt_QYTsO",""));
        movieBannerList.add(new BannerMovies(3, "Thar", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQO_2aY_zm39NUkGYBz42KFDW6K76nHcnL6l9rofpZZlRomHseq", ""));
        movieBannerList.add(new BannerMovies(4, "The invisible man", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRF_P78fzLMWkmN6VmyfKGTyDXs0AjwEpoXH57XJqwLofyMbDkz", ""));



        kidsBannerList= new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1, "Zig and sharko", "https://m.media-amazon.com/images/M/MV5BYmRhN2I1YTItMTQ0Yi00ZmUzLThkZWItZGY1NzljMGNiZGY5XkEyXkFqcGdeQXVyMTMxODU3NzM@._V1_.jpg", ""));
        kidsBannerList.add(new BannerMovies(2, "Transformers", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRcpOwfFXdbmv4e81H2famnJgGNbe-NOyhum1Konk_x0Iw75CK8", ""));
        kidsBannerList.add(new BannerMovies(3, "Oggy oggy", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDAHV4CUpjHHOzsfAS_NMc4bg0D12fQUKnCyDsBjJ6UIIJhv0q", ""));
        kidsBannerList.add(new BannerMovies(4, "Mighty little bheem", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSd1xbbmb2TOVmnp_jzG6bXnnUFl006SuKhThz4mB7xktnLtgBK ", ""));

        setBannerMoviesPagerAdapter(homeBannerList);

        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
                         setBannerMoviesPagerAdapter(tvShowBannerList);
                         return;



                    case 2:
                         setBannerMoviesPagerAdapter(movieBannerList);
                         return;


                    case 3:
                            setBannerMoviesPagerAdapter(kidsBannerList);

                    default:
                        setBannerMoviesPagerAdapter(homeBannerList);

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        List<CategoryItem> homeCatListItem1=new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1,"Panchayat","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/1bb55206139e64da420615e947102ce4f10231ed8e4613fe238f3810b8460a9f._UR1920,1080_RI_SX712_FMwebp_.jpg",""));
        homeCatListItem1.add(new CategoryItem(2,"Guilty Minds","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/00db64ef1f40ad7ede467a2cb5cf3f384a3c9ce2dbbe48440fc107256c676e87._UR1920,1080_RI_SX712_FMwebp_.jpg",""));
        homeCatListItem1.add(new CategoryItem(3,"Dear Father","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/91af93147109c00d05e4ff63bb9c10316ed4acb3922d3bc353c653dfce658fdd._UR1920,1080_RI_SX712_FMwebp_.jpg",""));
        homeCatListItem1.add(new CategoryItem(4,"Guardians The superheros","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/53fbcc4e3eb068f83f092645b2dc1e961d32144ee043559cf01d828cdd00fbfc._UR1920,1080_RI_SX712_FMwebp_.jpg",""));


        List<CategoryItem> homeCatListItem2=new ArrayList<>();
        homeCatListItem2.add(new CategoryItem(1,"Jab we Met","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/163503ad41f02dbe2a142e85004bfc079988dd53d2808491bdd4791f25e6ae8c._UR1920,1080_RI_UX400_UY225_.jpg",""));
        homeCatListItem2.add(new CategoryItem(2,"Karwaan","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/fcd186f36635b91c47216f6559464e2add5930c4b983dad8e344f354b2aded0b._UR1920,1080_RI_UX400_UY225_.jpg",""));
        homeCatListItem2.add(new CategoryItem(3,"Rab ne Bana Jodi","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/1234c2cc827b90aec6b4a410227973948eae633ca5c0e2b45a7a959a408c4fbe._UR1920,1080_RI_UX400_UY225_.jpg",""));
        homeCatListItem2.add(new CategoryItem(4,"Humpty Sharma ki Dhulhaniya","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/2df04f145449bed7e46e1411836d432588b5b9eb3496bf59a7bac371028ba5a6._UR1920,1080_RI_UX400_UY225_.jpg",""));


        List<CategoryItem> homeCatListItem3=new ArrayList<>();
        homeCatListItem3.add(new CategoryItem(1,"Home","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/0a19126b1bbfc4f182fb928bc565f8a94d6025f0122e0423d23574739fb1ca78._UR1920,1080_RI_UX400_UY225_.jpg",""));
        homeCatListItem3.add(new CategoryItem(2,"Hotel Transylvania 2 ","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/77c452046de2a6745f6f08edb35894a39ce137494bd95b04bcc9a246d1c4dac7._UR1920,1080_RI_UX400_UY225_.jpg",""));
        homeCatListItem3.add(new CategoryItem(3,"Penguins of Madagascar","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/9745e3f6663612f1edc43ca4efb1da463f85d5e2be68504b32906f86835c6ede._UR1920,1080_RI_UX400_UY225_.jpg",""));
        homeCatListItem3.add(new CategoryItem(4,"Shrek","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/31a6043a5b2b48399be106de6d0692739635748cba6ea5005141d93091d276f4._UR1920,1080_RI_UX400_UY225_.jpg",""));

        List<CategoryItem> homeCatListItem4=new ArrayList<>();
        homeCatListItem4.add(new CategoryItem(1,"fanney Khan","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/58fc665c4c8fd4f9033fc22b7b3f9c018b4b8827216cca8218ef5fb268915929._UR1920,1080_RI_UX400_UY225_.jpg",""));
        homeCatListItem4.add(new CategoryItem(2,"Rango","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/d0a2aba69040a5a7df2d0d101a8105ffdc0077f601c34d242fb406ed3100bf35._UR1920,1080_RI_UX400_UY225_.jpg",""));
        homeCatListItem4.add(new CategoryItem(3,"Just my Luck","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/5fb321340a6bc0aadc5de306466248d7221d3b0784f6560c661d77d8bd203d41._UR1920,1080_RI_UX400_UY225_.jpg",""));
        homeCatListItem4.add(new CategoryItem(4,"All Roads Leads to Rome","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/1888af94f13593724b7edf8fa8dc67f2535e8966ea6ad913b7cb61ce34b02f88._UR1920,1080_RI_UX400_UY225_.jpg",""));





        allCategoryList=new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Watch next TV and movies",homeCatListItem1));
        allCategoryList.add(new AllCategory(2,"Movies in Hindi",homeCatListItem2));
        allCategoryList.add(new AllCategory(3,"Kids and Family movies",homeCatListItem3));
        allCategoryList.add(new AllCategory(4,"FreeFlix exclusive",homeCatListItem4 ));

        setMainRecycler(allCategoryList);

        }


    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList) {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager);

        Timer sliderTimer=new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(),4000,6000);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager,true);

    }


    class AutoSlider extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (bannerMoviesViewPager.getCurrentItem() < homeBannerList.size() - 1) {
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);
                    } else {
                        bannerMoviesViewPager.setCurrentItem(0);

                    }
                }
            });

        }
    }
public void setMainRecycler(List<AllCategory> allCategoryList) {
    mainRecycler = findViewById(R.id.main_recyler);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
    mainRecycler.setLayoutManager(layoutManager);
    mainRecylerAdapter = new MainRecylerAdapter(this, allCategoryList);
    mainRecycler.setAdapter(mainRecylerAdapter);
}
}






