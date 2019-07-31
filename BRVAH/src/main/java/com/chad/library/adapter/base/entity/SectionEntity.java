package com.chad.library.adapter.base.entity;

import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.Objects;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class SectionEntity<T> implements Serializable {
    public boolean isHeader;
    @Nullable
    public T t;
    @Nullable
    public String header;

    public SectionEntity(boolean isHeader, String header) {
        this.isHeader = isHeader;
        this.header = header;
        this.t = null;
    }

    public SectionEntity(T t) {
        this.isHeader = false;
        this.header = null;
        this.t = t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionEntity)) return false;
        SectionEntity<?> that = (SectionEntity<?>) o;
        return isHeader == that.isHeader &&
                Objects.equals(t, that.t) &&
                Objects.equals(header, that.header);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isHeader, t, header);
    }
}
