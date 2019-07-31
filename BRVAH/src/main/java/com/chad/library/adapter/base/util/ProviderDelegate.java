package com.chad.library.adapter.base.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;

import com.chad.library.adapter.base.provider.BaseItemProvider;

/**
 * https://github.com/chaychan
 *
 * @author ChayChan
 * @date 2018/3/21  11:04
 */

public class ProviderDelegate {

    @NonNull
    private SparseArray<BaseItemProvider> mItemProviders = new SparseArray<>();

    public void registerProvider(@Nullable BaseItemProvider provider) {
        if (provider == null) {
            throw new ItemProviderException("ItemProvider can not be null");
        }

        int viewType = provider.viewType();

        if (mItemProviders.get(viewType) == null) {
            mItemProviders.put(viewType, provider);
        }
    }

    @NonNull
    public SparseArray<BaseItemProvider> getItemProviders() {
        return mItemProviders;
    }

}
