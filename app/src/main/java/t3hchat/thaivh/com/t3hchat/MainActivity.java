package t3hchat.thaivh.com.t3hchat;

import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.transition.Transition;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import t3hchat.thaivh.com.t3hchat.base.BaseActivity;
import t3hchat.thaivh.com.t3hchat.base.BaseFragment;
import t3hchat.thaivh.com.t3hchat.view.contactlist.ContactListFragment;


public class MainActivity extends BaseActivity {
    BottomBar bottomBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        replaceFrg(new ContactListFragment());
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initLizeComponent() {
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
    }

    @Override
    public void registerListener() {
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                Toast.makeText(getApplicationContext(), "reselect tab", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void replaceFrg(BaseFragment frg) {
        if (frg != null) {
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.main_container, frg)
                    .addToBackStack(frg.getClass().getSimpleName())
                    .commit();
        }
    }
}
