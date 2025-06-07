package com.duung.applepieapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.duung.applepieapp.UI.OrdersOngoingFragment;
import com.duung.applepieapp.UI.OrdersCompletedFragment;
import com.duung.applepieapp.UI.OrdersCanceledFragment;

public class OrdersPagerAdapter extends FragmentStateAdapter {

    public OrdersPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new OrdersOngoingFragment();
            case 1:
                return new OrdersCompletedFragment();
            case 2:
                return new OrdersCanceledFragment();
            default:
                return new OrdersOngoingFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // 3 tab: Active, Completed, Cancelled
    }
}
