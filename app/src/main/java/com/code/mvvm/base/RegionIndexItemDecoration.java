package com.code.mvvm.base;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.code.mvvm.R;

/**
 * Created by Android_ZzT on 17/7/9.
 */

public class RegionIndexItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildLayoutPosition(view);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = ((GridLayoutManager) parent.getLayoutManager()).getSpanSizeLookup();
        int spanSize = spanSizeLookup.getSpanSize(position);
        int margin_normal = view.getContext().getResources().getDimensionPixelOffset(R.dimen.margin_normal);
        int margin_small = view.getContext().getResources().getDimensionPixelOffset(R.dimen.margin_small);
        int margin_tiny = view.getContext().getResources().getDimensionPixelOffset(R.dimen.margin_4);
        if (spanSize == 2) {
            if (position == 0) { //header
                outRect.top = margin_small;
                outRect.left = margin_small;
            } else {
                outRect.top = margin_normal;
                outRect.left = margin_small;
            }
        } else {
            int index = spanSizeLookup.getSpanIndex(position , 2);
            switch (index) {
                case 0:
                    outRect.left = margin_small;
                    outRect.right = margin_tiny;
                    break;
                case 1:
                    outRect.left = margin_tiny;
                    outRect.right = margin_small;
                    break;
            }
            outRect.top = margin_small;
        }
    }
}
